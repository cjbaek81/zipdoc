package com.zipdoc.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * paste 페이지 이동 controller
 * @author 백찬주
 * @date 2021.03.05
 */
@Controller
public class HomeController {
	private static final String MAIN_PAGE = "redirect:/index";
	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("favicon.ico")
	@ResponseBody
	void returnNoFavicon() {}


	@RequestMapping("")
	public ModelAndView urlEmpty(HttpServletRequest request) throws Exception {
		return redirectPage(request);
	}

	@RequestMapping("/")
	public ModelAndView urlSlash(HttpServletRequest request) throws Exception {
		LOGGER.info("urlSlash");
		return redirectPage(request);
	}

	@RequestMapping("/index")
	public String index(ModelMap model) throws Exception {
		return "paste/index";
	}

	//글 등록 후 페이지 이동
	@RequestMapping("/{url}")
	public String oneUrl(ModelMap model, @PathVariable String url) throws Exception {
		LOGGER.info(url);
		String strUrl = "view";
		model.addAttribute("pageUrl", url);
		return "paste/" + strUrl;
	}
	
	private ModelAndView redirectPage(HttpServletRequest request){
		return new ModelAndView(MAIN_PAGE);
	}

}