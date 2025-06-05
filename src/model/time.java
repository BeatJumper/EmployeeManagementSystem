///
/// @file time.java
/// @brief 仅供阅读 无引用
/// @author kangyk (1253@mail.nwpu.edu.cn)
/// @version 1.0
/// @date 2025-06-05
///
/// @copyright Copyright (c) 2025
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author  <th>Description
/// <tr><td>2025-05-20 <td>1.0     <td>kangyk  <td>新建仅供阅读
/// </table>
///
package model;

import java.util.Date;

public class time {
    public String T_ID;
    public Date start_time;
    public Date end_time;
    public String M_ID;

    public time(String t_ID, Date start_time, Date end_time, String m_ID) {
        T_ID = t_ID;
        this.start_time = start_time;
        this.end_time = end_time;
        M_ID = m_ID;
    }

    public String getT_ID() {
        return T_ID;
    }

    public void setT_ID(String t_ID) {
        T_ID = t_ID;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }
}
