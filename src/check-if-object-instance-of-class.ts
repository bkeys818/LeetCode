export default function checkIfInstanceOf(obj: any, classFunction: any): boolean {
    if (obj === undefined || obj === null || typeof classFunction != 'function')
        return false
    return (typeof obj == 'object' ? obj : Object(obj)) instanceof classFunction
}
