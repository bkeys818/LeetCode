#!/usr/bin/env node
import { program, Option } from 'commander'
import { readFile, writeFile, appendFile } from 'fs/promises'
import { resolve } from 'path'
import { execSync } from 'child_process'

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
    let srcFilename: string, testFilename: string
    if (lang == 'java') {
        srcFilename = camelName[0].toUpperCase() + camelName.slice(1)
        testFilename = srcFilename + 'Test'
    } else {
        srcFilename = snakeName
        testFilename = srcFilename + '.test'
    }

    const srcFile = file('src/', srcFilename, lang),
        testFile = file('tests/', testFilename, lang),
        nameMD = `[${name}](https://leetcode.com/problems/${snakeName})`,
        srcMD = `[${properLangNames[lang]}](src/${srcFilename}.${lang})`,
        testMD = `[${properLangNames[lang]}](tests/${testFilename}.${lang})`

    await Promise.all([
        copy('src', lang, srcFile),
        copy('test', lang, testFile),
        appendFile(
            file('', 'README', 'md'),
            `| ${num ?? ''} | ${nameMD} | ${date} | ${srcMD} | ${testMD} |\n`
        ),
    ])

    execSync(`prettier -w README.md ${srcFile} ${testFile}`)

    async function copy(type: 'src' | 'test', lang: Lang, destFile: string) {
        const vars = { name, camelName, srcFilename }
        const regexp = new RegExp(
            Object.keys(vars)
                .map(k => `__${k}__`)
                .join('|'),
            'gi'
        )
        const contents = await readFile(file('templates/', type, lang), 'utf-8')
        await writeFile(
            destFile,
            contents.replace(regexp, key => vars[key.slice(2, -2)])
        )
    }
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
function file(path: string, filename: string, ext: string) {
    return resolve(__dirname, `../${path}${filename}.${ext}`)
}
