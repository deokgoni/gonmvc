package org.gon.model;
//JDBC -> MyBatis, JPA

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    //데이터 베이스 연결객체
    public void getConnect(){
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        //Mysql 드라이버 Loading
        try {
            //전적로딩 -> compile시점... 아래는 동적로딩..
            //동적로딩 방법 _> 실행시점에 메모리에 올림
            //만약 new로 생성 -> 컴파일 시점에 존재할경우 실행됨
            //만약 oracle로 변경하면 new 부분과 변수를 모두 수정해줘야한다.
//            Driver driver = new Driver();
            //동적로딩은 실행시에 패키지를 찾아가기에 따로 변수명과 선언을 바꿀 필요가 없다...
            //동적으로 올리면 DriverManager(내부적)으로 연결된다...
            try {
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("드라이버 검색 성공");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 검색 실패");
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(URL,user,password);
//            System.out.println("접속 성공");
        } catch (SQLException e) {
                System.out.println("접속 연결 실패");
            e.printStackTrace();
        }
    }

    //회원저장 동작
    public int memberInsert(MemberVO vo){
        //? : 파라미터
        String SQL = "insert into member2(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
        getConnect();
        int cnt = -1;

        //sql 전송 객체
        try {
            ps = conn.prepareStatement(SQL); // 미리 컴파일 시킨다.. sql에 미리 전달해서 에러가 있는지 확인..
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPass());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());

            cnt = ps.executeUpdate();//실행 -> 1과 0으로 성공 실패 / 성공한 row의 수

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

    //회원 전체 리스트 가져오기
    public ArrayList<MemberVO> memberList(){
        String SQL = "select * from member2";
        getConnect();
        ArrayList<MemberVO> list = new ArrayList<>();
        try{
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
           while(rs.next()){
               int num = rs.getInt("num");
               String id = rs.getString("id");
               String pass = rs.getString("pass");
               String name = rs.getString("name");
               int age = rs.getInt("age");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               MemberVO memberVO = new MemberVO(num,id,pass,name,age,email,phone);
               list.add(memberVO);
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return list;
    }

    public int memberDelete(int num){
        String SQL = "delete from member2 where num=?";
        int cnt = -1;
        getConnect();
        try{
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);

            cnt = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

    //상세보기
    public MemberVO memberContent(int num){
        String SQL = "select * from member2 where num=?";
        getConnect();
        MemberVO vo = null;
        try{
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if(rs.next()){
                num = rs.getInt("num");
                String id = rs.getString("id");
                String pass = rs.getString("pass");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                vo = new MemberVO(num,id,pass,name,age,email,phone);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return vo;
    }

    public int memberUpdate(MemberVO vo){
        String SQL = "update member2 set age=?, email=?, phone=? where num = ?";
        getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, vo.getAge());
            ps.setString(2, vo.getEmail());
            ps.setString(3, vo.getPhone());
            ps.setInt(4, vo.getNum());
            cnt = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }


    //데이터베이스 연결 끊기
    public void dbClose(){
        try {
            if(rs!=null)rs.close();
            if(ps!=null)ps.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
