///
/// @file memberinfo.java
/// @brief 仅供阅读 无引用
/// @author kangyk (1253@mail.nwpu.edu.cn)
/// @version 1.1
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

public class memberinfo {
    public String M_ID;
    public String M_Name;
    public Date entryTime;
    public String position;
    public String phone;
    public String status;

    public memberinfo(String m_ID, String m_Name, Date entryTime, String position, String phone, String status) {
        M_ID = m_ID;
        M_Name = m_Name;
        this.entryTime = entryTime;
        this.position = position;
        this.phone = phone;
        this.status = status;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public String getM_Name() {
        return M_Name;
    }

    public void setM_Name(String m_Name) {
        M_Name = m_Name;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
