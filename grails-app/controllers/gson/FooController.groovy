package gson


import grails.rest.*
import grails.converters.*

class FooController {
	static responseFormats = ['json', 'xml']


    def bar() {
        respond a:"hello", b: "world"
    }
}
