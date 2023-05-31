import {
    flattenDeeplyNestedArray1 as solution1,
    flattenDeeplyNestedArray2 as solution2,
    type MultiDimensionalArray,
} from '@/flatten-deeply-nested-array'

describe('Flatten Deeply Nested Array', () => {
    // prettier-ignore
    const testData: [MultiDimensionalArray, MultiDimensionalArray, number][] = [
        [
            [1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]],
            [1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]],
            0
        ],
        [
            [1,2,3,4,5,6,7,8,[9,10,11],12,13,14,15],
            [1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]],
            1
        ],
        [
            [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15],
            [1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]],
            2
        ]
    ]
    describe('Solution 1: Recursive approach', () => {
        test.each(testData)('case %#', (expected, ...args) => {
            expect(solution1(...args)).toStrictEqual(expected)
        })
    })
    describe('Solution 1: Iterative Stack', () => {
        test.each(testData)('case %#', (expected, ...args) => {
            expect(solution2(...args)).toStrictEqual(expected)
        })
    })
})
