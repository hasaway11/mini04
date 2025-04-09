package com.example.demo.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface BoardDao {
  // 글 저장. SelectKey로 생성한 글번호를 리턴
  @SelectKey(statement="select board_seq.nextval from dual", keyProperty="bno", resultType=Integer.class, before=true)
  @Insert("insert into board(bno,title,content,nickname,password) values(#{bno},#{title},#{content},#{nickname},#{password})")
  int save(Board board);

  @Select("select * from board")
  List<Board> findAll();

  @Select("select * from board where bno=#{bno} and rownum=1")
  Board findByBno(int bno);

  @Update("update board set read_cnt=read_cnt+1 where bno=#{bno} and rownum=1")
  int increaseReadCnt(int bno);

  @Update("update board set title=#{title}, content=#{content} where bno=#{bno} and rownum=1")
  int update(Board board);

  @Delete("delete from board where bno=#{bno} and rownum=1")
  int delete(int bno);
}
