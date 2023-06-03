import solution, {
    type MultidimensionalArray,
} from '../src/nested-array-generator'

describe('Nested Array Generator', () => {
    test.each<[number[], MultidimensionalArray]>(
        // prettier-ignore
        [
            [
                [6,1,3],
                [[[6]],[1,3],[]]
            ],
            [
                [],
                []
            ]
        ]
    )('case %#', (expected, arr) => {
        const gen = solution(arr)
        for (const num of expected) {
            expect(gen.next().value).toBe(num)
        }
        expect(gen.next().value).toBeUndefined()
    })
})
