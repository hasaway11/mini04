package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@Controller
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping("/comment/write")
  public ResponseEntity<List<Comment>> save(@ModelAttribute Comment comment) {
    return ResponseEntity.ok(commentService.save(comment));
  }
}
