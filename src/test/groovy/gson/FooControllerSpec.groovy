package gson

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class FooControllerSpec extends Specification implements ControllerUnitTest<FooController> {

    def setup() {
    }

    def cleanup() {
    }

    void "4.0.4 response.text"() {
        when: "I call controller.foo"
        controller.bar()

        then: "my response has text."
        println "response.text = ${response.text}"
        println "model = $model"
        println "view = $view"

        response.text != ""

    }

    void "4.0.4 response.json"() {
        when: "I call controller.foo"
        controller.bar()

        then: "my response has a json message"
        println "response.text = ${response.text}"
        println "model = $model"
        println "view = $view"

        response.json.message == "from bar.gson"
    }

    void "4.0.4 model is empty"() {
        when: "I call controller.foo"
        controller.bar()


        then: "the model is empty.  (feels like it should be set)"
        model.keySet().size()==0

        and: "the view is messed up.  it reports /foo/bar.gsp instead of /foo/bar.gson"
        view == "/foo/bar.gsp"

    }

    void "4.0.10 response.text"() {
        when: "I call controller.foo"
        controller.bar()

        then: "my response has no text."
        println "response.text = ${response.text}"
        println "model = $model"
        println "view = $view"

        response.text == ""

    }

    void "4.0.10 response.json"() {
        when: "I call controller.foo"
        controller.bar()

        println "response.text = ${response.text}"
        println "model = $model"
        println "view = $view"

        and: "ask for the json"

        println response.json.message

        then: "my response has no json message"
        thrown(Exception)

    }

    void "4.0.10 model is set"() {
        when: "I call controller.foo"
        controller.bar()

        then: "the model is empty.  (feels like it should be set)"
        model.keySet().size()==2

        and: "the view is messed up.  it reports /foo/bar.gsp instead of /foo/bar.gson"
        view == "/foo/bar.gsp"


    }

}