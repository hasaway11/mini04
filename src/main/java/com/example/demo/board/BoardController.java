package com.example.demo.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@Controller
public class BoardController {
  @Autowired
  private BoardService boardService;

  @PostMapping("/board/write")
  public ResponseEntity<Integer> write(@RequestBody Board board) {
    System.out.println(board);
    int bno = boardService.save(board);
    return ResponseEntity.ok(bno);
  }

  @GetMapping("/")
  public ResponseEntity<List<Board>> list() {
    List<Board> boards = boardService.findAll();
    return ResponseEntity.ok(boards);
  }

  @GetMapping("/board/read")
  public ResponseEntity<Map<String,Object>> findByBno(int bno) {
    Map<String,Object> map = boardService.findByBno(bno);
    return ResponseEntity.ok(map);
  }

  @PostMapping("/board/update")
  public ResponseEntity<Void> update(Board board) {
    boolean result = boardService.update(board);
    if (result)
      return ResponseEntity.ok().build();
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/board/delete")
  public ResponseEntity<Void> update(Integer bno, String password) {
    boolean result = boardService.delete(bno, password);
    if (result)
      return ResponseEntity.ok().build();
    return ResponseEntity.notFound().build();
  }
}
