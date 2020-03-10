package dao;

import com.alibaba.fastjson.JSONArray;
import common.Tang_PoetryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoetryDao {
    public static void insert(Poetry poetry){
        Connection connection = DBUtil.getConnection();
        String sql = "insert into tangshi values(null,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,poetry.getSha256());
            statement.setString(2,poetry.getDynasty());
            statement.setString(3,poetry.getTitle());
            statement.setString(4,poetry.getAuthor());
            statement.setString(5,poetry.getContent());
            statement.setString(6,poetry.getWords());

            int row = statement.executeUpdate();
            if(row != 1){
                throw new Tang_PoetryException("插入失败");
            }
        } catch (SQLException | Tang_PoetryException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    public static JSONArray selectCount(String condition){
        Connection connection = DBUtil.getConnection();
        if(condition == null){
            condition = "5";
        }
        JSONArray jsonArray = new JSONArray();
        String sql = "select author,count(*) as cnt  from tangshi group by author having cnt >= ? order by cnt desc";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,condition);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                String author = resultSet.getString("author");
                int count = resultSet.getInt("cnt");
                JSONArray item = new JSONArray();
                item.add(author);
                item.add(count);
                jsonArray.add(item);
            }
            return jsonArray;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return jsonArray;
    }
}
