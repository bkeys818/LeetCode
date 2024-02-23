#!/usr/bin/env node
import { program, Option } from 'commander'
import { readFile, writeFile, appendFile, mkdir } from 'fs/promises'
import { existsSync } from 'fs'
import path from 'path'
import { execSync } from 'child_process'

const srcDir = 'src/', testDir = 'tests/'

const properLangNames = {
    java: 'Java',
    js: 'JavaScript',
    ts: 'TypeScript',
}
type Lang = keyof typeof properLangNames

const date = new Date().toLocaleDateString(undefined, {
    year: '2-digit',
    month: '2-digit',
    day: '2-digit',
})

program
    .nameFromFilename(require.main!.filename)
    .description('Creates the template files for a new LeetCode problem.')
    .argument(
        '<name>',
        'The name of the problem. Preceeding with problem number is optional'
    )
    .addOption(
        new Option('-l --lang <language>', 'The programming language.')
            .choices(Object.keys(properLangNames))
            .default('java')
    )
    .action(action)

program.parseAsync()

async function action(nameStr: string, { lang }: { lang: Lang }) {
    const [_, num, name] = /(?:(\d+)\. )?(.+)/.exec(nameStr)
    const camelName = camelize(name),
        snakeName = snakize(name)

    let srcFilename: string,
        srcPath = srcDir,
        testPath = testDir

    if (lang == 'java') {
        srcFilename = camelName[0].toUpperCase() + camelName.slice(1)
        srcPath += srcFilename
        testPath += srcFilename
        await Promise.all([createPackage(srcPath), createPackage(testPath)])
        srcPath += `/${srcFilename}.java`
        testPath += `/${srcFilename}Test.java`
    } else {
        srcFilename = snakeName
        srcPath += `${srcFilename}.ts`
        testPath += `${srcFilename}.test.ts`
    }

    const srcFile = resolve(srcPath),
        testFile = resolve(testPath)

    if (existsSync(srcFile) || existsSync(testFile)) {
        return console.warn("Oops: A solution for this problem already exisit.")
    }

    const nameMD = `[${name}](https://leetcode.com/problems/${snakeName})`,
        srcMD = `[${properLangNames[lang]}](${srcPath})`,
        testMD = `[${properLangNames[lang]}](${testPath})`

    const templateValues = { name, camelName, srcFilename }
    await Promise.all([
        copyTemplate('src', lang, srcFile, templateValues),
        copyTemplate('test', lang, testFile, templateValues),
        appendFile(
            resolve('README.md'),
            `| ${num ?? ''} | ${nameMD} | ${date} | ${srcMD} | ${testMD} |\n`
        ),
    ])

    if (lang == 'ts' || lang == 'js') execSync(`prettier -w README.md ${srcFile} ${testFile}`)
}

async function copyTemplate(type: 'src' | 'test',lang: Lang, destFile: string, values: Record<string,string>) {
    const regexp = new RegExp(
        Object.keys(values)
            .map(k => `__${k}__`)
            .join('|'),
        'gi'
    )
    const contents = await readFile(resolve(`templates/${type}.${lang}`), 'utf-8')
    await writeFile(
        destFile,
        contents.replace(regexp, key => values[key.slice(2, -2)])
    )
}

function camelize(str: string) {
    return str
        .replace(/(?:^\w|[A-Z]|\b\w)/g, function (word, index) {
            return index === 0 ? word.toLowerCase() : word.toUpperCase()
        })
        .replace(/\s+/g, '')
}
function snakize(str: string) {
    return str
        .replace(/\W+/g, ' ')
        .split(/ |\B(?=[A-Z])/)
        .map(word => word.toLowerCase())
        .join('-')
}

function resolve(filePath: string) {
    return path.resolve(__dirname, '../' + filePath)
}

function createPackage(packagePath: string) {
    if (existsSync(packagePath)) return
    return mkdir(packagePath)
}