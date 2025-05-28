package DAO;

import DButils.util;
import model.rewards_log;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class rewardsDAO {
    public List<rewards_log> queryList(String M_ID){
        List<rewards_log> list = new ArrayList<rewards_log>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            List<Object> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select * from rewards_log");
            if(M_ID != null && !"".equals(M_ID)){
                sb.append("where M_ID = ?");
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
                rewards_log r = new rewards_log();
                r.setM_ID(rs.getString("M_ID"));
                r.setRewards_ID(rs.getString("rewards_ID"));
                r.setRewards_name(rs.getString("rewards_Name"));
                r.setRewards_type(rs.getString("rewards_type"));
                r.setRewards_time(rs.getDate("rewards_time"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(rewards_log rewardsLog){
        Connection con = null;
        String sql = "insert into rewards_log values(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, rewardsLog.getRewards_ID());
            pstmt.setString(2, rewardsLog.getRewards_name());
            pstmt.setString(3, rewardsLog.getRewards_type());
            Date date = new Date();
            pstmt.setTimestamp(4, new Timestamp(date.getTime()));
            pstmt.setString(5,rewardsLog.getM_ID());
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

    public boolean update(rewards_log rewardsLog){
        Connection con = null;
        String sql = "update rewards_log set rewards_name=?,rewards_type=?,rewards_time=? where rewards_ID=?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, rewardsLog.getRewards_name());
            pstmt.setString(2, rewardsLog.getRewards_type());
            Date date = new Date();
            pstmt.setTimestamp(3, new Timestamp(date.getTime()));
            pstmt.setString(4, rewardsLog.getRewards_ID());
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public boolean delete(String rewards_id){
        Connection con = null;
        String sql = "delete from rewards_log where rewards_ID=?";
        PreparedStatement pstmt = null;
        try {
            con = util.getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, rewards_id);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public rewards_log getById(int M_ID){
        rewards_log rewardsLog = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = util.getConn();
            String sql = "select * from rewards_log where M_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, M_ID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                rewardsLog = new rewards_log();
                rewardsLog.setM_ID(rs.getString("M_ID"));
                rewardsLog.setRewards_ID(rs.getString("rewards_ID"));
                rewardsLog.setRewards_name(rs.getString("rewards_name"));
                rewardsLog.setRewards_type(rs.getString("rewards_type"));
                rewardsLog.setRewards_time(rs.getDate("rewards_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewardsLog;
    }
}