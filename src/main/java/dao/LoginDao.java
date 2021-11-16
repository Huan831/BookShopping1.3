package dao;

import domain.UserDomain;

public interface LoginDao {
    public UserDomain loginCheck(UserDomain userDomain);
}
