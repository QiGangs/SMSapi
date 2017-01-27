package com.yctu.sms.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC连接数据库封装类
 * 
 * @author Administrator
 * 
 */
public class JDBCutil {
   
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://***.***.***.***:3306/***";
    private static final String username = "******";
    private static final String password = "******";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    
    public static void close(Connection conn, Statement stmt,
            PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
}

