package service.Impl;

import dao.LoginDao;
import dao.impl.ImplLoginDao;
import domain.UserDomain;
import service.LoginService;

public class ImplLoginService implements LoginService {
    LoginDao loginDao=new ImplLoginDao();
    @Override
    public UserDomain loginCheck(UserDomain userDomain){
        return loginDao.loginCheck(userDomain);
    }
}
