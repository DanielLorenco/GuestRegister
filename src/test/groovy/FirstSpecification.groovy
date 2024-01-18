import spock.lang.Specification

class FirstSpecification extends Specification {

    def "one plus one equals two" () {
        expect:
        1 + 1 == 2
    }
}
