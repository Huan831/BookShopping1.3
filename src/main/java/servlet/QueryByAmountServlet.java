package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BookDomain;
import service.BookService;
import service.Impl.ImplBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QueryByAmountServlet", value = "/QueryByAmountServlet")
public class QueryByAmountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = (String) request.getSession().getAttribute("type");
        BookService bookService = new ImplBookService();
        Map<String, Object> map = new HashMap<String, Object>();
        int index;
        int amount;
        String pageindex=request.getParameter("currentPage");
        String pageAmount=request.getParameter("pageSize");
        index=Integer.parseInt(pageindex);
        amount=Integer.parseInt(pageAmount);
        int relIndex=(index-1)*amount;
        List<BookDomain> list = bookService.queryBookById(relIndex, amount,type);
        map.put("BookList", list);
        map.put("success", true);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.println(objectMapper.writeValueAsString(map));
    }
}
