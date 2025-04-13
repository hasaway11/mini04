package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CommentService {
  @Autowired
  private CommentDao commentDao;

  public List<Comment> save(Comment comment) {
    commentDao.save(comment);
    return commentDao.findByBno(comment.getBno());
  }
}
