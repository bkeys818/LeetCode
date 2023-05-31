declare global {
    interface Array<T> {
        groupBy(fn: (item: T) => string): Record<string, T[]>
    }
}

Array.prototype.groupBy = function(fn) {
    const obj: Record<string,any[]> = {}
    for (const item of this) {
        const key = fn(item)
        if (key in obj) obj[key].push(item)
        else obj[key] = [item]
    }
    return obj
}

export default Array.prototype.groupBy