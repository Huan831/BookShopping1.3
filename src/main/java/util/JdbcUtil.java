package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class JdbcUtil {
    public static DataSource source=new ComboPooledDataSource();
    public static DataSource getDataSource(){return source;}
}
