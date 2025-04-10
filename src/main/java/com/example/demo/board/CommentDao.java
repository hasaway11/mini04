package com.example.demo.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface CommentDao {
  @Insert("insert into comments(cno, content, nickname, password, write_time, bno) values(comments_seq.nextval, #{content}, #{nickname}, #{password}, sysdate, #{bno})")
  int save(Comment comment);

  @Select("select * from comments where bno=#{bno} order by cno desc")
  List<Comment> findByBno(int bno);

  @Delete("delete from comments where bno=#{bno}")
  int deleteByBno(int bno);
}
