package lab;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class 插入诗词Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册Driver，获取Connection通过DriverManager
      /*  Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/tangshi?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url,"root","1002");*/
        //通过DataSource获取Connection
       // DataSource dataSource = new MysqlDataSource();
        //带有连接池
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);
        dataSource.setPassword("1002");
        dataSource.setUser("root");
        dataSource.setDatabaseName("tangshi");
        dataSource.setUseSSL(false);
        dataSource.setCharacterEncoding("utf8");
        try(Connection connection = dataSource.getConnection()){

        }
    }
}
