package com.example.demo.comment;

import org.apache.ibatis.annotations.*;

import java.util.*;

//@Mapper
public interface CommentDao {
  @Insert("insert into comments(cno,content,nickname,password) values(comments_seq.nextval, #{content}, #{nickname}, #{password})")
  public int save(Comment comment);

  @Select("select * from boards where bno=#{bno}")
  public List<Comment> findByBno(int bno);

  @Delete("delete from comments where bno=#{bno}")
  public int deleteByBno(int bno);

  @Delete("delete from comments where cno=#{cno} and rownum=1")
  public int deleteByCno(int cno);
}
