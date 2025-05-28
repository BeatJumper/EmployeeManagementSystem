package model;

public class permission {
    public String P_ID;
    public String P_Name;
    public String O_ID;
    public String A_ID;

    public permission(String p_ID, String p_Name, String o_ID, String a_ID) {
        P_ID = p_ID;
        P_Name = p_Name;
        O_ID = o_ID;
        A_ID = a_ID;
    }

    public String getP_ID() {
        return P_ID;
    }

    public void setP_ID(String p_ID) {
        P_ID = p_ID;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public String getO_ID() {
        return O_ID;
    }

    public void setO_ID(String o_ID) {
        O_ID = o_ID;
    }

    public String getA_ID() {
        return A_ID;
    }

    public void setA_ID(String a_ID) {
        A_ID = a_ID;
    }
}
