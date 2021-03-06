package life.silenceradio.community.controller;

import life.silenceradio.community.dto.PaginationDTO;
import life.silenceradio.community.model.User;
import life.silenceradio.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;



@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "8") Integer size,
                          HttpServletRequest request,
                          Model model) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)){
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName","最新回复");
        }

        PaginationDTO pagination = questionService.listByUserId(user.getId(), page, size);
        model.addAttribute("pagination", pagination);
        return "profile";
    }
}
