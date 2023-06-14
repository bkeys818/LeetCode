import solution from '../src/regular-expression-matching'

describe('Regular Expression Matching', () => {
    test.each<[boolean, string, string]>(
        // prettier-ignore
        [
            [false, 'aa', 'a'],
            [true, 'aa', 'a*'],
            [true, 'ab', '.*'],
            [true, 'abc', '.*c'],
            [true, 'aab', 'c*a*b'],
            [true, 'mississippi', 'mis*is*ip*.'],
            [false, 'mississippi', 'mis*is*p*.'],
            [false, 'aaa', 'ab*a'],
            [true, 'a', 'ab*'],
            [true, 'bbbba', '.*a*a']
        ]
    )('case %#', (expected, ...args) => {
        expect(solution(...args)).toBe(expected)
    })
})
