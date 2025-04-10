package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardService {
  @Autowired
  private BoardDao boardDao;
  @Autowired
  private CommentDao commentDao;

  public int save(Board board) {
    boardDao.save(board);
    return board.getBno();
  }

  public List<Board> findAll() {
    return boardDao.findAll();
  }

  public Map<String,Object> findByBno(int bno) {
    boardDao.increaseReadCnt(bno);
    Board board = boardDao.findByBno(bno);
    List<Comment> comments = commentDao.findByBno(bno);
    return Map.of("board", board, "comments", comments);
  }

  // storedPassword : 데이터베이스에 저장된 글의 비밀번호
  // board.getPassword() : 글을 변경하려고 입력한 비밀번호
  public boolean update(Board board) {
    String storedPassword = boardDao.findByBno(board.getBno()).getPassword();
    if (storedPassword.equals(board.getPassword())) {
      // storedPassword와 board.getPassword()가 일치하면 글을 변경
      boardDao.update(board);
      return true;
    }
    return false;
  }

  public boolean delete(int bno, String password) {
    String storedPassword = boardDao.findByBno(bno).getPassword();
    if (storedPassword.equals(password)) {
      // storedPassword와 board.getPassword()가 일치하면 글을 변경
      // 삭제할 때는 부모부터 - 부모를 참조하는 자식이 있는 경우 부모를 삭제할 수 없다
      commentDao.deleteByBno(bno);
      boardDao.delete(bno);
      return true;
    }
    return false;
  }
}
