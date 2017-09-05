package com.imooc.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类:
 * 1）建立连接
 * 2）获取资源
 */
public class JDBCUtil {
    /**
     * 建立连接
     * @return jdbc connection
     */
    public static Connection getConnection() throws Exception{
//        String url="jdbc:mysql://192.168.37.164:3306/spring_data";
//        String user="root";
//        String password="root";
//        String driverClass="com.mysql.jdbc.Driver";
        InputStream inputStream=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(inputStream);

        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");
        String driverClass=properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }

    /**
     * 释放DB相关资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if(null!=resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=statement){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
