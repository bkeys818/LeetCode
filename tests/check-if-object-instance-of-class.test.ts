import solution from '../src/check-if-object-instance-of-class'

describe('Check if Object Instance of Class', () => {
    test.each<[boolean, () => boolean]>(
        // prettier-ignore
        [
            [
                true,
                () => solution(new Date(), Date)
            ],
            [
                true,
                () => { class Animal {}; class Dog extends Animal {}; return solution(new Dog(), Animal); }
            ],
            [
                false,
                () => solution(Date, Date)
            ],
            [
                true,
                () => solution(5, Number)
            ]
        ]
    )('case %#', (expected, testSolution) => {
        expect(testSolution()).toBe(expected)
    })
})
