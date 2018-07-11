package com.wqj.hbase;

import com.wqj.hbase.util.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: wqj
 * @Date: 2018/7/11 14:39
 * @Description:
 */
public class HbaseTest {

    private Connection conn = DataSource.getConnection();

    public static void main(String[] args) throws SQLException {
        HbaseTest hbaseTest = new HbaseTest();
//        hbaseTest.createTable();
        hbaseTest.updateTable();
      hbaseTest.getTable();
    }

    /**
     * 创建表
     */
    public void createTable() throws SQLException {

        String sql = "create table student('cf1'.'name' varchar null,'cf1'.'age' int null,'cf2'.'dept' varchar null)";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        statement.close();
    }

    /**
     * /**
     * 删除表
     */
    public void deleteTable() {

    }

    /**
     * 修改表
     */
    public void updateTable() throws SQLException {
        String str = "upsert into STUDENT(PK,'cf1'.'name','cf1'.'age','cf2'.'dept') values('111','zhansgan2','21','13')";
        Statement statement = conn.createStatement();
        statement.execute(str);
        conn.commit();
        statement.close();
    }

    /**
     * 查询表
     */
    public ResultSet getTable() throws SQLException {
        String sql = "select * from student";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        statement.close();
        return resultSet;
    }
}
