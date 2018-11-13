package no.hib.dat152.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * Create item form controller.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
@Controller   
@RequestMapping("/createitemform.do")
public class CreateItemFormController {

    /**
     * Create item form Controller.
     *
     * @return model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public final ModelAndView createItemForm() {

        final String id = ItemDAOMemorySingleton.getInstance().getNextId();

        return new ModelAndView("CreateItemForm.jsp", "id", id);
    }
}
