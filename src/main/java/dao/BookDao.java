package dao;

import domain.BookDomain;

import java.util.List;

public interface BookDao {
    //倒序选择五本书
    public List<BookDomain> queryBookById(int startIndex, int amount,String type);
    //获取图书总数
    public Integer BookCounter(String type);
}
