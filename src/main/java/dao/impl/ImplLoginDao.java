package dao.impl;

import dao.LoginDao;
import domain.UserDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;

import java.util.List;

public class ImplLoginDao implements LoginDao {
    JdbcTemplate jdbc=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public UserDomain loginCheck(UserDomain userDomain){
        String email=userDomain.getEmail();
        String password=userDomain.getCustPwd();
        String sql="select * from customer_table where email=? and cust_pwd=?";
        List<UserDomain> list=null;
        list=jdbc.query(sql,new BeanPropertyRowMapper<UserDomain>(UserDomain.class),email,password);
        if(list.isEmpty()){
            return null;
        }else {
            return list.get(0);
        }
    }
}
