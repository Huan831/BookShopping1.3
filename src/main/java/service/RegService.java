package service;

import domain.UserDomain;

public interface RegService {
    public boolean queryByName(String username);
    public boolean queryByEmail(String email);
    public int insertInfo(UserDomain user);
}
