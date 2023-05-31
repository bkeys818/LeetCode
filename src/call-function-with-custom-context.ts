declare global { 
    interface Function {
      callPolyfill(context: Record<any, any>, ...args: any[]): any;
	}
}

Function.prototype.callPolyfill = function(context, ...args) {
    return this.bind(context)(...args)
}

export default Function.prototype.callPolyfill
