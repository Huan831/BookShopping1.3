package dao;

import domain.UserDomain;
import org.apache.commons.mail.EmailException;

public interface RegDao {
    public boolean queryByName(String username);
    public boolean queryByEmail(String email);
    public int insertInfo(UserDomain user);
    public boolean emailSending(UserDomain userDomain) throws EmailException;
}
