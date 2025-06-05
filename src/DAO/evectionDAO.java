///
/// @file rewardsDAO.java
/// @brief DAO层evection
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
import model.evection_log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class evectionDAO {
    public List<evection_log> queryList(String T_ID){
        List<evection_log> list = new ArrayList<evection_log>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            List<Object> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select * from evection_log ");
            if(T_ID != null && !"".equals(T_ID)){
                sb.append("where T_ID = ? ");
                params.add(T_ID);
            }
            try {
                pstmt = con.prepareStatement(sb.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(params.size()>0){
                for(int i=0; i<params.size(); i++){
                    pstmt.setObject(i, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                evection_log r = new evection_log();
                r.setT_ID(rs.getString("T_ID"));
                r.setdestination(rs.getString("destination"));
                r.setobjective(rs.getString("objective"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(evection_log evectionLog){
        Connection con = null;
        String sql = "insert into evection_log values(?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, evectionLog.getdestination());
            pstmt.setString(2, evectionLog.getobjective());
            pstmt.setString(3, evectionLog.getT_ID());
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(evection_log evectionLog){
        Connection con = null;
        String sql = "update evection_log set destination=?,objective=?,T_ID=? where T_ID=?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, evectionLog.getdestination());
            pstmt.setString(2, evectionLog.getobjective());
            pstmt.setString(3, evectionLog.getT_ID());
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String T_ID){
        Connection con = null;
        String sql = "delete from evection_log where T_ID=?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, T_ID);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public evection_log getById(int T_ID){
        evection_log evectionLog = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            String sql = "select * from evection_log where T_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, T_ID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                evectionLog = new evection_log();
                evectionLog.setT_ID(rs.getString("T_ID"));
                evectionLog.setdestination(rs.getString("destination"));
                evectionLog.setobjective(rs.getString("objective"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evectionLog;
    }
}
