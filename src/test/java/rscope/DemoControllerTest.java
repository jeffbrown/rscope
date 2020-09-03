package rscope;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class DemoControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testIndex() throws Exception {
        // these will contain the identity of the the DemoBean used to handle these requests
        String firstResponse = client.toBlocking().retrieve("/doit");
        String secondResponse = client.toBlocking().retrieve("/doit");

        assertTrue(firstResponse.matches("^Bean identity: \\d*$"));
        assertTrue(secondResponse.matches("^Bean identity: \\d*$"));

        // if you modify DemoBean to be @Singleton instead of
        // @RequestScope, this will fail because the same instance
        // will be used for both requests
        assertNotEquals(firstResponse, secondResponse);
    }
}
