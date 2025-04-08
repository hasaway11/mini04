package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardService {
  @Autowired
  private BoardDao boardDao;

  public int save(Board board) {
    boardDao.save(board);
    return board.getBno();
  }

  public List<Board> findAll() {
    return boardDao.findAll();
  }

  public Board findByBno(int bno) {
    boardDao.increaseReadCnt(bno);
    return boardDao.findByBno(bno);
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
      boardDao.delete(bno);
      return true;
    }
    return false;
  }
}
