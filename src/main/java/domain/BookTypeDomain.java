package domain;

public class BookTypeDomain {
    private  int bookTypeId;
    private  String bookTypeName;
    private  int bookTypeSaleNum;

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public int getBookTypeSaleNum() {
        return bookTypeSaleNum;
    }

    public void setBookTypeSaleNum(int bookTypeSaleNum) {
        this.bookTypeSaleNum = bookTypeSaleNum;
    }

    @Override
    public String toString() {
        return "BookTypeDomain{" +
                "bookTypeId=" + bookTypeId +
                ", bookTypeName='" + bookTypeName + '\'' +
                ", bookTypeSaleNum=" + bookTypeSaleNum +
                '}';
    }
}
