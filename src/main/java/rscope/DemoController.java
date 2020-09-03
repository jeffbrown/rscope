package rscope;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class DemoController {

    private final DemoBean demoBean;

    public DemoController(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

    @Get("/doit")
    public String doit() {
        return String.format("Bean identity: %d", demoBean.getBeanIdentity());
    }
}
