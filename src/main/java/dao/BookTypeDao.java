package dao;

import domain.BookDomain;

import java.util.List;

public interface BookTypeDao {
    public List<BookDomain> queryByBookType(String type);
}
