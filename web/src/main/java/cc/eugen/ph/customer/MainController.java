package cc.eugen.ph.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class MainController {

	@RequestMapping(value = "/c", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();

		ModelAndView model = new ModelAndView("customer");
		model.addObject("lists", list);

		return model;
	}

	private List<String> getList() {

		List<String> list = new ArrayList<>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}

}