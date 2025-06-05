///
/// @file util.java
/// @brief 数据库连接模块
/// @author 四维数组
/// @version 1.1
/// @date 2025-05-29
///
/// @copyright Copyright (c) 2025
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author       <th>Description
/// <tr><td>2025-05-20 <td>1.0     <td>siweishuzu   <td>新建
/// <tr><td>2025-05-29 <td>1.1     <td>siweishuzu   <td>注释增加
/// </table>
///
package DButils;

import java.sql.*;

public class util {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true";
    private static final String USERNAME="root";
    private static final String PASSWORD="123123";
    public static Connection getConn(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void closeAll(Connection conn, Statement st, ResultSet rs){
        //先开的后关
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(getConn());
    }
}



