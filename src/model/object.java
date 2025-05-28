package model;

public class object {
    public String O_ID;
    public String O_Name;

    public object(String o_ID, String o_Name) {
        O_ID = o_ID;
        O_Name = o_Name;
    }

    public String getO_ID() {
        return O_ID;
    }

    public void setO_ID(String o_ID) {
        O_ID = o_ID;
    }

    public String getO_Name() {
        return O_Name;
    }

    public void setO_Name(String o_Name) {
        O_Name = o_Name;
    }
}
