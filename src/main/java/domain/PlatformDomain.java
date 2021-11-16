package domain;

public class PlatformDomain {
    private String emailHost="smtp.163.com";
    private String emailUserName="13697080526@163.com";
    private String emailKey="JEGFHOWFZSSQENNY";
    private String platformName="TangYu";

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    public String getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(String emailKey) {
        this.emailKey = emailKey;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "PlatformDomain{" +
                "emailHost='" + emailHost + '\'' +
                ", emailUserName='" + emailUserName + '\'' +
                ", emailKey='" + emailKey + '\'' +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
