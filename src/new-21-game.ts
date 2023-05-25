export default function new21Game(n: number, bust: number, maxPts: number) {
    const probs: number[] = new Array(n + 1).fill(0)
    probs[0] = 1
    for (let someScore = 1; someScore <= n; someScore++) {
        for (let lastDraw = 1; lastDraw <= maxPts; lastDraw++) {
            if (someScore - lastDraw >= 0 && someScore - lastDraw < bust) {
                probs[someScore] += probs[someScore - lastDraw] / maxPts
            }
        }
    }
    let ans = 0
    for (let someScore = bust; someScore <= n; someScore++) {
        ans += probs[someScore]
    }
    return ans
}
