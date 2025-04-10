package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping("/comment/write")
  public ModelAndView save(@ModelAttribute Comment comment) {
    commentService.save(comment);
    return new ModelAndView("redirect:/board/read?bno=" + comment.getBno());
  }
}
