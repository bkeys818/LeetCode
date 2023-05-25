import solution from '../src/new-21-game'

describe('New 21 Game', () => {
    test.each([
        [1, [10, 1, 10], 1],
        [2, [6, 1, 10], 0.6],
        [3, [21, 17, 10], 0.73278],
    ])(`case %i`, (_, args: [number, number, number], expected) => {
        expect(solution(...args)).toBeCloseTo(expected, 5)
    })
})
