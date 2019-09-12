package com.example.restaurant.util;

import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 14:15
 **/
public class DataSourceUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceUtil.class);

    /**
     *获取数据库连接
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConnection(String url,String username,String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }

    /**
     * 关闭statement
     * @param statement
     */
    public static void closeStatement(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("close statement failure", e);
            }
        }
    }


}
