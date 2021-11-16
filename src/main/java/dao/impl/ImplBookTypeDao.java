package dao.impl;

import dao.BookTypeDao;
import domain.BookDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;

import java.util.List;

public class ImplBookTypeDao implements BookTypeDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public List<BookDomain> queryByBookType(String type){
        String sql="select * from bookinfoview\n" +
                "where book_type_name=?";
        List<BookDomain> list=null;
        list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<BookDomain>(BookDomain.class),type);
        return list;
    }
}
