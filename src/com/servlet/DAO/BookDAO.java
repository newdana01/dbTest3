package com.servlet.DAO;

import com.servlet.DTO.BookDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306";
    String user = "root";
    String pass = "1234";

    public BookDAO(){
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<BookDTO> selectAll(){
        ArrayList<BookDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try{
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement("use book");
            pstmt.execute();
            pstmt.clearParameters();
            String sql = "SELECT * FROM book";
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();

            while(res.next()){
                int bookId = res.getInt("book_id");
                String bookName = res.getString("book_name");
                String bookLoc = res.getString("book_loc");

                BookDTO bookDTO = new BookDTO(bookId, bookName, bookLoc);
                list.add(bookDTO);
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                if(res!=null) res.close();
                if(pstmt!=null) pstmt.close();
                if(con!=null) con.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return list;
    }

    public void insert(String bookName, String bookLoc){
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement("use book");
            pstmt.execute();
            pstmt.clearParameters();
            String sql = "INSERT INTO book (book_name, book_loc) VALUES (?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookName);
            pstmt.setString(2, bookLoc);
            int res = pstmt.executeUpdate();
            System.out.println(res);

            if(res>0){
                System.out.println("insert() is completed successfully.");
            }else {
                System.out.println("insert() failed. Please try again.");
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                if(pstmt!=null) pstmt.close();
                if(con!=null) con.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int delete(int BId) {
        int s=0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            pstmt = con.prepareStatement("use book");
            pstmt.execute();
            pstmt.clearParameters();
            String sql = "DELETE FROM book WHERE (book_id = ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, BId);
            int res = pstmt.executeUpdate();

            if (res == 1) {
                s=1;
                System.out.println("delete() is completed successfully.");
            } else {
                System.out.println("delete() failed. Please try again.");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }finally {
            try{
                if(pstmt!=null) pstmt.close();
                if(con!=null) con.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return s;
    }
}
