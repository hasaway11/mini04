package com.example.demo;

import com.example.demo.board.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardServiceTest {
  @Autowired
  private BoardService boardService;

//  @Test
  public void initTest() {
    assertNotNull(boardService);
  }

//  @Test
  public void saveTest() {
    Board board = Board.builder().title("연습").content("연습 연습").nickname("spring").password("1234").build();
    // BoardService의 리턴값은 시퀀스로 생성한 새로운 글번호
    // 개발자는 정확한 값을 예측하기 어렵다
    int bno = boardService.save(board);

    // 어쨌든 0보다는 큰 값이겠지
    assertEquals(true, bno>0);
  }

  //@Test
  public void findAllTest() {
    // 바로 위 테스트에서 글을 추가했으므로 게시판에 저장된 글의 숫자는 0보다 크다
    assertEquals(true, boardService.findAll().size()>0);
  }

  // 변경하는 테스트 -> 값이 변경되므로 재 테스트가 불가능 -> 테스트한 다음 결과를 rollback -> 재 테스트 가능
  @Transactional
//  @Test
  public void findByBnoTest() {
    // 테스트하려는 글의 글번호와 조회수를 먼저 확인
    // 1번글의 조회수가 현재 0이라면
    Board board = boardService.findByBno(1);

    // 읽기에 성공했다면 board가 null이 아니고 bno는 0에서 증가해서 1이 되었다
    assertEquals(1, board.getBno());
  }

  @Transactional
//  @Test
  public void update실패Test() {
    // 비밀번호 틀림
    Board board = Board.builder().bno(1).title("변경").content("변경 변경").password("1111").build();
    assertEquals(false, boardService.update(board));
  }

  @Transactional
  @Test
  public void update성공Test() {
    Board board = Board.builder().bno(1).title("변경").content("변경 변경").password("1234").build();
    assertEquals(true, boardService.update(board));
  }

  @Transactional
//  @Test
  public void delete실패Test() {
    // 비밀번호 틀림
    assertEquals(false, boardService.delete(1, "1111"));
  }

  @Transactional
  @Test
  public void delete성공Test() {
    assertEquals(true, boardService.delete(1, "1234"));
  }
}
