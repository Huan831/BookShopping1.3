package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BeanServlet", value = "/BeanServlet")
public class BeanServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        Class clazz = this.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null) {
                String desPath = (String) method.invoke(this, request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

