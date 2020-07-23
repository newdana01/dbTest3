package com.servlet;

import com.servlet.DAO.BookDAO;
import com.servlet.DTO.BookDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String Bname = request.getParameter("Bname");
        String Bloc = request.getParameter( "Bloc");
        BookDAO bookDAO = new BookDAO();
        bookDAO.insert(Bname, Bloc);
        ArrayList<BookDTO> list = bookDAO.selectAll();
        int count = list.size();

        for(int i=0; i<count; i++){
            BookDTO bookDTO = list.get(i);
            int bookId = bookDTO.getBookId();
            String bookName = bookDTO.getBookName();
            String bookLoc = bookDTO.getBookLoc();

            out.printf("bookID: "+bookId+", ");
            out.printf("bookName: "+bookName+", ");
            out.printf("bookLoc: "+bookLoc+"<br>");
        }
    }
}
