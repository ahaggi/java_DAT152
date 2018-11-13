package no.hvl.dat152.helloworld;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * 
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class HelloWorldUI extends UI {
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Panel contentPane = new Panel();

        VerticalLayout layout = new VerticalLayout();
        
        Label helloworldLabel = new Label();
        helloworldLabel.setValue("Hello World!");
        layout.addComponent(helloworldLabel);
        
         TextField textbox = new TextField("Ok");

        
        Button okButton = new Button("Ok");
        okButton.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent( new Button("Ok"));
            }
        } );
        layout.addComponent(okButton);
        
        contentPane.setContent(layout);
        setContent(contentPane);

    	hash<Integer> tall = new ArrayList<Integer>();
    	
    	for(int i=0 ; i<10 ; i++) {
    		tall.add(i);
    		
    	}

    
    
    }

    @WebServlet(urlPatterns = "/*", name = "HelloWorldUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HelloWorldUI.class, productionMode = false)
    public static class HelloWorldUIServlet extends VaadinServlet {
    }
}
