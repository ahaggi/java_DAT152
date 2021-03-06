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
@RequestMapping("/updateitemform.do")
public class UpdateItemFormController{

        @RequestMapping(method = RequestMethod.GET)
        public ModelAndView updateitemform ( HttpServletRequest req, HttpServletResponse resp) {
        	
            final String id = req.getParameter("id");
            final Item item = ItemDAOMemorySingleton.getInstance().findItem(id);

            return new ModelAndView("updateitemform.jsp", "item", item);
        }
}

