package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.RegDao;
import dao.impl.ImplRegDao;
import domain.UserDomain;
import service.Impl.ImplRegService;
import service.RegService;
import util.CodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends BeanServlet {
    RegService reg = new ImplRegService();
    Map<String, Object> map = new HashMap<String, Object>();

    public void nameConfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        boolean flag = reg.queryByName(username);
        if (flag) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

    public void emailConfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        boolean flag = reg.queryByEmail(email);
        if (flag) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

    public void codeComfirm(HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean flag=CodeUtil.checkVerifyCode(request);
        System.out.println(flag);
        if(flag){
            map.put("result",true);
        }else{
            map.put("result",false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

    public void insertInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Insert started.....");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String email = request.getParameter("email");
        UserDomain userDomain = new UserDomain();
        userDomain.setCustNo(name);
        userDomain.setCustPwd(pwd);
        userDomain.setEmail(email);
        int flag = reg.insertInfo(userDomain);
        System.out.println("flag:"+flag);
        if(flag>=0){
            map.put("result",true);
        }else{
            map.put("result",false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }


}
