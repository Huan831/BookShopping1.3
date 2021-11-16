package domain;

public class BookDomain {
    private long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookImage;
    private String bookIsbn;
    private String publishingName;
    private String bookTypeName;

    private BookDomain bookDomain;
    private float price;
    private float discount;
    private String bookPublishName;
    private String bookIntroduction;

    private PublishDomain publishDomain;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public BookDomain getBookDomain() {
        return bookDomain;
    }

    public void setBookDomain(BookDomain bookDomain) {
        this.bookDomain = bookDomain;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getBookPublishName() {
        return bookPublishName;
    }

    public void setBookPublishName(String bookPublishName) {
        this.bookPublishName = bookPublishName;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public PublishDomain getPublishDomain() {
        return publishDomain;
    }

    public void setPublishDomain(PublishDomain publishDomain) {
        this.publishDomain = publishDomain;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    @Override
    public String toString() {
        return "BookDomain{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", publishingName='" + publishingName + '\'' +
                ", bookTypeName='" + bookTypeName + '\'' +
                ", bookDomain=" + bookDomain +
                ", price=" + price +
                ", discount=" + discount +
                ", bookPublishName='" + bookPublishName + '\'' +
                ", bookIntroduction='" + bookIntroduction + '\'' +
                ", publishDomain=" + publishDomain +
                '}';
    }
}
