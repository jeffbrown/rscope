package rscope;

import io.micronaut.http.annotation.*;

@Controller("/foo")
public class FooController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}