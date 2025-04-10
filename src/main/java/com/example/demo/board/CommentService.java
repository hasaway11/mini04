package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class CommentService {
  @Autowired
  private CommentDao commentDao;

  public boolean save(Comment comment) {
    return commentDao.save(comment)>0;
  }
}
