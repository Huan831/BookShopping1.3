package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.UserDomain;
import service.Impl.ImplLoginService;
import service.LoginService;
import util.CodeUtil;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends BeanServlet {
    Map<String, Object> map = new HashMap<String, Object>();

    public void codeComfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag = CodeUtil.checkVerifyCode(request);
        System.out.println(flag);
        if (flag) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

    public void infoComfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDomain userDomain = new UserDomain();
        UserDomain user = new UserDomain();
        userDomain.setEmail(email);
        userDomain.setCustPwd(password);
        LoginService loginService = new ImplLoginService();
        user = loginService.loginCheck(userDomain);
        System.out.println(user.getCustNo());
        if (user != null) {
            map.put("result", true);
            request.getSession().setAttribute("user",user);
        } else {
            map.put("result", false);
        }
        PrintWriter out = response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

}
