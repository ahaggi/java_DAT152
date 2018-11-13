package no.hib.dat152.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello world example using spring mvc.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
@Controller
public class HelloController {

    /**
     * The hello world controller.
     *
     * @return Model and view
     */
    @RequestMapping("/hello.do")
    public final ModelAndView helloWorld() {
        return new ModelAndView("HelloWorld.jsp", "message", "Hello World");
//        return new ModelAndView(fyll på her );
    }

}
