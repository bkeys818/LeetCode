#!/usr/bin/env node
"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const commander_1 = require("commander");
const promises_1 = require("fs/promises");
const path_1 = require("path");
const properLangNames = {
    java: 'Java',
    js: 'JavaScript',
    ts: 'TypeScript',
};
const date = new Date().toLocaleDateString(undefined, {
    year: '2-digit',
    month: '2-digit',
    day: '2-digit',
});
commander_1.program
    .nameFromFilename(require.main.filename)
    .description('Creates the template files for a new LeetCode problem.')
    .argument('<number>', 'The number of the problem')
    .argument('<name>', 'The name of the problem')
    .addArgument(new commander_1.Argument('lang', 'The programming language')
    .choices(Object.keys(properLangNames))
    .argOptional()
    .default('java'))
    .action(action);
commander_1.program.parseAsync();
function action(number, name, lang) {
    return __awaiter(this, void 0, void 0, function* () {
        let filename, srcFilename, testFilename;
        const camelName = camelize(name);
        if (lang == 'java') {
            srcFilename = camelName[0].toUpperCase() + camelName.slice(1);
            testFilename = srcFilename + 'Test';
        }
        else {
            srcFilename = snakize(name);
            testFilename = srcFilename + '.test';
        }
        const srcFile = file('src/', srcFilename, lang), testFile = file('tests/', testFilename, lang), srcMD = `[${properLangNames[lang]}](src/${srcFilename}.${lang})`, testMD = `[${properLangNames[lang]}](tests/${testFilename}.${lang})`;
        yield Promise.all([
            copy('src', lang, srcFile),
            copy('test', lang, testFile),
            (0, promises_1.appendFile)('./README.md', `| ${number} | ${date} | ${name} | ${srcMD} | ${testMD} |\n`),
        ]);
        function copy(type, lang, destFile) {
            return __awaiter(this, void 0, void 0, function* () {
                const vars = { name, filename, camelName, srcFilename };
                const regexp = new RegExp(Object.keys(vars)
                    .map(k => `__${k}__`)
                    .join('|'), 'gi');
                const contents = yield (0, promises_1.readFile)(file('templates/', type, lang), 'utf-8');
                yield (0, promises_1.writeFile)(destFile, contents.replace(regexp, key => vars[key.slice(2, -2)]));
            });
        }
    });
}
function camelize(str) {
    return str
        .replace(/(?:^\w|[A-Z]|\b\w)/g, function (word, index) {
        return index === 0 ? word.toLowerCase() : word.toUpperCase();
    })
        .replace(/\s+/g, '');
}
function snakize(str) {
    return str
        .replace(/\W+/g, ' ')
        .split(/ |\B(?=[A-Z])/)
        .map(word => word.toLowerCase())
        .join('_');
}
function file(path, filename, ext) {
    return (0, path_1.resolve)(__dirname, `../${path}${filename}.${ext}`);
}
