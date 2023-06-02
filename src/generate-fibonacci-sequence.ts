export default function* fibGenerator(): Generator<number, any, number> {
    const history = [0, 1]
    while (true) {
        history.push(history[0] + history[1])
        yield history.shift()
    }
}
