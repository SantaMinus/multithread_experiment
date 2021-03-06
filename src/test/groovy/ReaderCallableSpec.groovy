import com.company.ReaderCallable
import spock.lang.Specification

public class ReaderCallableSpec extends Specification {
    def "it should require at least 1 URL"() {
        when:
        new ReaderCallable()
        then:
        def e = thrown NullPointerException
        e.getMessage() == "url should not be null"
    }

    def "it should accept a URL"() {
        given:
        URL url = new URL('https://vk.com')

        when:
        new ReaderCallable(url)

        then:
        noExceptionThrown()
    }

    def "it should get a response from a URL"() {
        given:
        URL url = new URL('https://vk.com')
        ReaderCallable rc = new ReaderCallable(url)

        when:
        def res = rc.call()

        then:
        res == url.toString() + ': 200  OK'
    }
}