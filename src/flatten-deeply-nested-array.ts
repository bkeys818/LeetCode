export type MultiDimensionalArray = (number | MultiDimensionalArray)[]

/**
 * This solution is best when the average number of item that are arrays is low.
 *
 * It's time complexity is `O(k * n)` where:
 *   - `k` = average number of nested arrays at each level
 *   - `n` = maximum depth level
 */
export function flattenDeeplyNestedArray1(
    arr: MultiDimensionalArray,
    n: number
) {
    const flattened: MultiDimensionalArray = []
    const flatten = (items: MultiDimensionalArray, l: number) => {
        for (const item of items)
            if (Array.isArray(item) && l > 0 && l <= n) flatten(item, l - 1)
            else flattened.push(item)
    }
    flatten(arr, n)
    return flattened
}

/**
 * This solution is best when the elements are mostly arrays.
 *
 * It's time complexity is `O(m)` where:
 *   - `m` = totol number of elements in the array (and sub arrays)
 */
export function flattenDeeplyNestedArray2(
    arr: MultiDimensionalArray,
    n: number
) {
    const queue = arr.map<[number | MultiDimensionalArray, number]>(v => [v, n])
    const flattened: MultiDimensionalArray = []
    while (queue.length > 0) {
        const [item, d] = queue.pop()
        if (Array.isArray(item) && d != 0)
            queue.push(
                ...item.map<[number | MultiDimensionalArray, number]>(v => [
                    v,
                    d - 1,
                ])
            )
        else flattened.push(item)
    }
    return flattened.reverse()
}
