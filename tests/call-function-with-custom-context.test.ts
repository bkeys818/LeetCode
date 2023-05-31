import solution from '@/call-function-with-custom-context'

declare global {
    interface Function {
        callPolyfill(context: Record<any, any>, ...args: any[]): any
    }
}
Function.prototype.callPolyfill = solution

describe('Call Function with Custom Context', () => {
    test.each<[any, Function, Parameters<Function['callPolyfill']>]>(
        // prettier-ignore
        [
            [
                12,
                function add(b) { return this.a + b; },
                [{"a":5},7]
            ],
            [
                'The cost of the burger is 11',
                function tax(price, taxRate) {
                    return `The cost of the ${this.item} is ${price * taxRate}`
                },
                [{ item: 'burger' }, 10, 1.1],
            ]
        ]
    )('case %#', (expected, fn, args) => {
        expect(fn.callPolyfill(...args)).toBe(expected)
    })
})
