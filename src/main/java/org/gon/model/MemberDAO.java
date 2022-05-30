package org.gon.model;
//JDBC -> MyBatis, JPA

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private static SqlSessionFactory sqlSessionFactory;

    //초기화 블럭(static block) - 프로그램 실행시 딱 한번만 실행되는 코드영역
    static {
        try {
            String resource = "org/gon/mybatis/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //회원정보 리스트 보기
    public List<MemberVO> memberList(){
        //Connection + Statement => SqlSession
        SqlSession session = sqlSessionFactory.openSession();
        List<MemberVO> list = session.selectList("memberList");
        session.close();
        return list;
    }

    public int memberInsert(MemberVO vo){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("memberInsert", vo);
        session.commit();
        session.close();
        return cnt;
    }

    //회원삭제
    public int memberDelete(int num){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.delete("memberDelete", num);
        session.commit();
        session.close();
        return cnt;
    }

    public MemberVO memberContent(int num){
        SqlSession session = sqlSessionFactory.openSession();
        MemberVO vo = session.selectOne("memberContent", num);
        session.commit();
        session.close();
        return vo;
    }

    public int memberUpdate(MemberVO vo){
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.update("memberUpdate", vo);
        session.commit();
        session.close();
        return cnt;
    }

}
