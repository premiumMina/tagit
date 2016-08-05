package tagit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tiles")
public class TilesController {
	
	@RequestMapping("/home")
	public ModelAndView tiles() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tiles/body");
		return mv;
	}
	
	@RequestMapping("/timeLine")
	public ModelAndView timeLine() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tiles/timeLine");
		return mv;
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();	// session 파괴
		return "home";
	}
	@RequestMapping("/default")
	public String tilesHome() {
		return "tiles/header";
	}
}
