package dao.impl;

import dao.BookDao;
import domain.BookDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;
import java.util.List;

public class ImplBookDao implements BookDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate((JdbcUtil.getDataSource()));

    @Override
    public List<BookDomain> queryBookById(int startIndex, int amount ,String type){
        List<BookDomain> list=null;
        String sql;
        if(type!=null && !type.equals("")){
            sql="select * from bookinfoview where book_type_name = ?\n" +
                    "order by book_id desc\n" +
                    "limit ?,?";
            list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<BookDomain>(BookDomain.class),type,startIndex,amount);
        }
        else{
            sql="select * from bookinfoview\n" +
                    "order by book_id desc\n" +
                    "limit ?,?";
            list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<BookDomain>(BookDomain.class),startIndex,amount);
        }
        return list;
    }
    @Override
    public Integer BookCounter(String type){
        Integer cnt=0;
        if(type==null){
            String sql="select count(*) from bookinfoview ";
            cnt=jdbcTemplate.queryForObject(sql,Integer.class);
        }else{
            String sql="select count(*) from bookinfoview where book_type_name=?";
            cnt=jdbcTemplate.queryForObject(sql,Integer.class,type);
        }
        return cnt;
    }

}
