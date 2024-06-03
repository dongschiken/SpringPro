package org.doit.ik;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@RequestMapping(value = "/")
public class HomeController {
	
	@RequestMapping(value = "/index.htm")
	public String home(Locale locale, Model model) {
		
		return "home.index"; // viewname
	}
}
