package no.hib.dat152.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;


@Controller
@RequestMapping("/viewshoppinglist.do")
public class ViewShoppingListController {

        @RequestMapping(method = RequestMethod.GET)
        public ModelAndView viewshoppinglist ( HttpServletRequest req, HttpServletResponse resp) {
        	
            final List<Item> items = ItemDAOMemorySingleton.getInstance().findAllItems();
            req.getSession().setAttribute("items", items);

            return new ModelAndView("Shoppinglist.jsp", "items", items);
        }
}
