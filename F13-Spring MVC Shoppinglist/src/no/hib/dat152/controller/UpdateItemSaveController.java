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
@RequestMapping("/updateitemsave.do")
public class UpdateItemSaveController{

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView updateitemsave( HttpServletRequest req, HttpServletResponse resp) {
    	
        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final Double price = Double.parseDouble(req.getParameter("price"));
        final String description = req.getParameter("description");

        final Item updatedItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().updateItem(id, updatedItem);
        
//      return ("redirect:/viewitem.do?id=" + id);  //String
        return new ModelAndView("redirect:/viewitem.do" ,"id", id);
    }
}
