package dao.impl;

import dao.RegDao;
import domain.UserDomain;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class ImplMail {
    @Test
    public void mailtest() throws EmailException {
        SimpleEmail email=new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("13697080526@163.com","JEGFHOWFZSSQENNY");
        email.addTo("850196893@qq.com","TangYu");
        email.setFrom("13697080526@163.com","TangYu");
        email.setSubject("test.mail");
        email.setMsg("This is a test simple email from 6714");
        email.send();
    }
    @Test
    public void daotest1() throws EmailException {
        RegDao dao=new ImplRegDao();
        UserDomain user=new UserDomain();
        user.setEmail("850196893@qq.com");
        user.setCustNo("tangyu831");
        dao.emailSending(user);
    }
}
