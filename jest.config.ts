import { type JestConfigWithTsJest, pathsToModuleNameMapper } from 'ts-jest'
import { compilerOptions } from './tests/tsconfig.json'

export default {
    preset: 'ts-jest',
    testEnvironment: 'node',
    moduleNameMapper: pathsToModuleNameMapper(compilerOptions.paths),
    testMatch: ['**/tests/**/*.test.(t|j)s'],
    transform: {
        '^.+\\.tsx?$': [
            'ts-jest',
            {
                tsconfig: './tests/tsconfig.json',
            }
        ]
    }
} satisfies JestConfigWithTsJest
