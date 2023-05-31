import solution from '../src/group-by'

declare global {
    interface Array<T> {
        groupBy(fn: (item: T) => string): Record<string, T[]>
    }
}
Array.prototype.groupBy = solution

describe('Group By', () => {
    test.each<[any[], (item: any) => string, Record<string,any[]>]>(
        // prettier-ignore
        [
            [
                [{"id":"1"},{"id":"1"},{"id":"2"}],
                item => item.id,
                {"1":[{"id":"1"},{"id":"1"}],"2":[{"id":"2"}]}
            ],
            [
                [[1,2,3],[1,3,5],[1,5,9]],
                list => String(list[0]),
                {"1":[[1,2,3],[1,3,5],[1,5,9]]},
            ],
            [
                [1,2,3,4,5,6,7,8,9,10],
                n => String(n > 5),
                {"false":[1,2,3,4,5],"true":[6,7,8,9,10]}
            ]
        ]
    )('case %#', (arr, fn, expected) => {
        expect(arr.groupBy(fn)).toStrictEqual(expected)
    })
})
