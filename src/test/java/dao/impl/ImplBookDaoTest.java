package dao.impl;

import dao.BookDao;
import domain.BookDomain;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ImplBookDaoTest {
    @Test
    public void queryBookById(){
        BookDao bookDao=new ImplBookDao();
        List<BookDomain> list=bookDao.queryBookById(0,5,"");
        System.out.println(list);
    }

}