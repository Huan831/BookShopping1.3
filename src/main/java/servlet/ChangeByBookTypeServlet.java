package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.ImplBookTypeDao;
import domain.BookDomain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "changeByBookTypeServlet", value = "/changeByBookTypeServlet")
public class ChangeByBookTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        request.getSession().setAttribute("type",type);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.println(objectMapper.writeValueAsString(map));
    }
}
