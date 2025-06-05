///
/// @file rewardsDAO.java
/// @brief DAO层train
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

package DAO;

import DButils.util;
import model.train_log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class trainDAO {

    // 查询方法
    public List<train_log> queryList(String T_ID) {
        List<train_log> list = new ArrayList<train_log>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            List<Object> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("SELECT * FROM train_log ");
            if (T_ID != null && !"".equals(T_ID)) {
                sb.append("WHERE T_ID = ? ");
                params.add(T_ID);
            }
            pstmt = con.prepareStatement(sb.toString());
            if (params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i)); // 设置参数为字符串类型
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                train_log r = new train_log();
                r.setT_ID(rs.getString("T_ID"));
                r.settrain_content(rs.getString("train_content"));
                r.settrain_achieve(rs.getString("train_achieve")); // 假设有这个字段
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // 保存方法
    public boolean save(train_log trainLog) {
        Connection con = null;
        String sql = "INSERT INTO train_log (train_content, train_achieve, T_ID) VALUES (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, trainLog.gettrain_content());
            pstmt.setString(2, trainLog.gettrain_achieve());
            pstmt.setString(3, trainLog.getT_ID()); // 设置T_ID为字符串类型
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 更新方法
    public boolean update(train_log trainLog) {
        Connection con = null;
        String sql = "UPDATE train_log SET train_content = ?, train_achieve = ?, T_ID = ? WHERE T_ID = ?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, trainLog.gettrain_content());
            pstmt.setString(2, trainLog.gettrain_achieve());
            pstmt.setString(3, trainLog.getT_ID()); // 设置T_ID为字符串类型
            pstmt.setString(4, trainLog.getT_ID()); // 用 T_ID 作为条件
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 删除方法
    public boolean delete(String T_ID) {
        Connection con = null;
        String sql = "DELETE FROM train_log WHERE T_ID = ?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, T_ID); // 设置T_ID为字符串类型
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 根据ID查询
    public train_log getById(String T_ID) {
        train_log trainLog = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            String sql = "SELECT * FROM train_log WHERE T_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, T_ID); // 设置T_ID为字符串类型
            rs = pstmt.executeQuery();
            while (rs.next()) {
                trainLog = new train_log();
                trainLog.setT_ID(rs.getString("T_ID"));
                trainLog.settrain_content(rs.getString("train_content"));
                trainLog.settrain_achieve(rs.getString("train_achieve"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainLog;
    }
}
