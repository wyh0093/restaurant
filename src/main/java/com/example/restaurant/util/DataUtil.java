package com.example.restaurant.util;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 14:12
 **/
public class DataUtil {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    public static Map<Integer,String> dishs = new HashMap<>();

    public Map<Integer,String> dish(){
        Map<Integer,String> dishs = new HashMap<>();
        Connection conn = DataSourceUtil.getConnection(dataSourceUrl,dataSourceUsername,dataSourcePassword);
        String sql = "select * from dtype ";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            if(conn!=null){
                statement = conn.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    dishs.put(resultSet.getInt("id"),resultSet.getString("d_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeStatement(statement);
            DataSourceUtil.closeConnection(conn);
        }
        return dishs;
    }
}
