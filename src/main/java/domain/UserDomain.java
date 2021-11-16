package domain;

public class UserDomain {
    private String custNo;
    private String custPwd;
    private String email;
    private String lastLogin;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustPwd() {
        return custPwd;
    }

    public void setCustPwd(String custPwd) {
        this.custPwd = custPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "custNo='" + custNo + '\'' +
                ", custPwd='" + custPwd + '\'' +
                ", email='" + email + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                '}';
    }
}
