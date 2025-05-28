package model;

public class member {
    public String M_ID;
    public String m_password;
    public String R_ID;

    public member(String m_ID, String m_password, String r_ID) {
        M_ID = m_ID;
        this.m_password = m_password;
        R_ID = r_ID;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }
}
