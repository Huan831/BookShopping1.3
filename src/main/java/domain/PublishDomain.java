package domain;

public class PublishDomain {
    private  long publishingId;
    private String publishingName;

    @Override
    public String toString() {
        return "PublishDomain{" +
                "publishingId=" + publishingId +
                ", publishingName='" + publishingName + '\'' +
                '}';
    }

    public long getPublishingId() {
        return publishingId;
    }

    public void setPublishingId(long publishingId) {
        this.publishingId = publishingId;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }
}
