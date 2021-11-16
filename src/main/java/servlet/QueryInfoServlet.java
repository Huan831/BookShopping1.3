package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.UserDomain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "QueryInfoServlet", value = "/QueryInfoServlet")
public class QueryInfoServlet extends BeanServlet {
    Map<String ,Object> map=new HashMap<String, Object>();
    public void queryUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        UserDomain userDomain=new UserDomain();
        userDomain=(UserDomain)request.getSession().getAttribute("user");
        if(userDomain!=null){
            map.put("result",true);
            map.put("user",userDomain);
        }else{
            map.put("result",false);
        }
        PrintWriter out=response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

    public void resetSession(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        map.put("result",true);
        PrintWriter out=response.getWriter();
        out.println(new ObjectMapper().writeValueAsString(map));
    }

}
