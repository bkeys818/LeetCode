import solution from '@/new-21-game'

describe('New 21 Game', () => {
    test.each<[number, [number, number, number]]>([
        [1, [10, 1, 10]],
        [0.6, [6, 1, 10]],
        [0.73278, [21, 17, 10]],
    ])(`case %#`, (expected, args) => {
        expect(solution(...args)).toBeCloseTo(expected, 5)
    })
})
