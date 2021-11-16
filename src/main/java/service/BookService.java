package service;

import domain.BookDomain;

import java.util.List;

public interface BookService {
    public List<BookDomain> queryBookById(int startIndex, int amount,String type);
    public Integer BookCounter(String type);
}
