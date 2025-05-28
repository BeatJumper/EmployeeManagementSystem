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
