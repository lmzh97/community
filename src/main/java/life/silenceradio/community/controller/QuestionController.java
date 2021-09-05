package life.silenceradio.community.controller;

import life.silenceradio.community.dto.QuestionDTO;
import life.silenceradio.community.mapper.QuestionMapper;
import life.silenceradio.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        questionService.incView(id);
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("question", question);
        return "question";
    }
}
