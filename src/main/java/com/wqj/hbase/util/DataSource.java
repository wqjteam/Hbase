package com.wqj.hbase.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Auther: wqj
 * @Date: 2018/7/11 16:32
 * @Description:
 */
public class DataSource {
    public static Connection getConnection(){
        Connection cc = null;
        String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
        String url = "jdbc:phoenix:hadoop1:2181";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (cc == null) {
            try {
                cc = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cc;
    }
}
