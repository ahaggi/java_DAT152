package no.hib.dat152.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

@Controller
@RequestMapping("/createitemsave.do")
public class CreateItemSaveController {

    

        @RequestMapping(method = RequestMethod.POST)
        public ModelAndView CreateItemSave (HttpServletRequest req, HttpServletResponse resp) {
        	
            final String id = req.getParameter("id");
            final String name = req.getParameter("name");
            Double price = 0.0;
            try {
                price = Double.parseDouble(req.getParameter("price"));
            } catch (final NumberFormatException e) {
            }
            final String description = req.getParameter("description");

            final Item newItem = new Item(id, name, price, description);
            ItemDAOMemorySingleton.getInstance().createItem(newItem);

//            return ("redirect:/viewshoppinglist.do"); return String

            return new ModelAndView("redirect:/viewshoppinglist.do");
        }
    
}
	