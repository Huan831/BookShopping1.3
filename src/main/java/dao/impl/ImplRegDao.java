package dao.impl;

import dao.RegDao;
import domain.PlatformDomain;
import domain.UserDomain;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImplRegDao implements RegDao {
    JdbcTemplate jdbc=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public boolean queryByName(String username){
        String sql="select * from customer_table where cust_no= ? ";
        List<UserDomain> list=null;
        list=jdbc.query(sql,new BeanPropertyRowMapper<UserDomain>(UserDomain.class),username);
        System.out.println(list);
        if(!list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean queryByEmail(String email){
        String sql="select * from customer_table where email=?";
        List<UserDomain> list=null;
        list=jdbc.query(sql,new BeanPropertyRowMapper<UserDomain>(UserDomain.class),email);
        if(!list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int insertInfo(UserDomain user){
        String sql="insert into customer_table(cust_no,cust_pwd,email,last_login) value(?,?,?,?)";
        int cnt=0;
        Date current_date= new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.format(current_date.getTime());
        return jdbc.update(sql,user.getCustNo(),user.getCustPwd(),user.getEmail(),simpleDateFormat.format(current_date.getTime()));
    }

    @Override
    public boolean emailSending(UserDomain userDomain) throws EmailException {
        SimpleEmail email=new SimpleEmail();
        PlatformDomain platformDomain=new PlatformDomain();
        email.setHostName("smtp.163.com");
        email.setAuthentication(platformDomain.getEmailUserName(),platformDomain.getEmailKey());
        email.addTo(userDomain.getEmail(),userDomain.getCustNo());
        email.setFrom(platformDomain.getEmailUserName(),platformDomain.getPlatformName());
        email.setSubject("ZhiFou|帐号绑定新邮箱确认");
        email.setMsg("ZhiFou 帐号绑定新邮箱确认 \n" +
                "Hi, "+userDomain.getCustNo()+"\n" +
                "你正在进行 ZhiFou 帐号邮箱绑定操作，如非本人操作，请忽略。\n" +
                "ZhiFou 帐号： "+userDomain.getCustNo()+"\n" +
                "即将绑定邮箱地址： "+userDomain.getEmail()+"");
        email.send();
        return true;
    }

}
