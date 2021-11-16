package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.BookService;
import service.Impl.ImplBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookCounterServlet", value = "/BookCounterServlet")
public class BookCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type= (String) request.getSession().getAttribute("type");
        BookService bookService=new ImplBookService();
        int bookCnt=0;
        int tmp=0;
        Map<String,Object> map=new HashMap<String, Object>();
        bookCnt=bookService.BookCounter(type);
        if(bookCnt%5!=0)
            tmp+=1;
        bookCnt/=5;
        bookCnt+=tmp;
        map.put("success",true);
        map.put("bookAmount",bookCnt);
        PrintWriter out=response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }
}
