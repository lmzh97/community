package life.silenceradio.community.controller;

import life.silenceradio.community.dto.CommentDTO;
import life.silenceradio.community.dto.QuestionDTO;
import life.silenceradio.community.enums.CommentTypeEnum;
import life.silenceradio.community.service.CommentService;
import life.silenceradio.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        questionService.incView(id);
        QuestionDTO question = questionService.getById(id);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        model.addAttribute("question", question);
        model.addAttribute("comments", comments);
        return "question";
    }
}
