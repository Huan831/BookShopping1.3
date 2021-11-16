package service.Impl;

import dao.RegDao;
import dao.impl.ImplRegDao;
import domain.UserDomain;
import service.RegService;

public class ImplRegService implements RegService {
    RegDao reg=new ImplRegDao();
    @Override
    public boolean queryByName(String username){
        return reg.queryByName(username);
    }
    @Override
    public boolean queryByEmail(String email){
        return reg.queryByEmail(email);
    }
    @Override
    public int insertInfo(UserDomain user){
        return reg.insertInfo(user);
    }
}
