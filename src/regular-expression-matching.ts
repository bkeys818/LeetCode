export default function isMatch(s: string, p: string): boolean {
    const chars = s.split(''),
        symbols: string[] = []
    for (const char of p.split(''))
        if (char == '*') symbols[symbols.length - 1] += char
        else symbols.push(char)
    let i: number = 0,
        j: number = 0
    while (j < symbols.length) {
        if (symbols[j].endsWith('*')) {
            while (
                i < chars.length &&
                charMatch(chars[i], symbols[j]) &&
                !(
                    j < symbols.length - 1 &&
                    isMatch(s.slice(i), symbols.slice(j + 1).join(''))
                )
            )
                i++
            j++
        } else if (charMatch(chars[i], symbols[j])) {
            i++, j++
        } else return false
    }
    return i == chars.length && j == symbols.length
}

function charMatch(char: string, symbol: string) {
    return (char && symbol[0] == '.') || symbol[0] == char
}
