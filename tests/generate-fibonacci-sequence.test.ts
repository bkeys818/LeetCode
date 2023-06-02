import solution from '../src/generate-fibonacci-sequence'

describe('Generate Fibonacci Sequence', () => {
    test.each<[number[], number]>(
        // prettier-ignore
        [
            [[0,1,1,2,3], 5],
            [[], 0]
        ]
    )('case %#', (expected, n) => {
        const gen = solution()
        for (let i = 0; i < n; i++) {
            expect(gen.next().value).toBe(expected[i])
        }
    })
})
