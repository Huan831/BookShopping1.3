package service.Impl;

import dao.BookDao;
import dao.impl.ImplBookDao;
import domain.BookDomain;
import service.BookService;

import java.util.List;

public class ImplBookService implements BookService {
    private BookDao bookDao=new ImplBookDao();
    @Override
    public List<BookDomain> queryBookById(int startIndex, int amount,String type){
        return bookDao.queryBookById(startIndex,amount,type);
    }
    @Override
    public Integer BookCounter(String type){
        return bookDao.BookCounter(type);
    }
}
