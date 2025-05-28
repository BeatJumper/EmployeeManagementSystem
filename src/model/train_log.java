package model;

public class train_log {
    public String T_ID;
    public String train_content;
    public String train_achieve;

    public train_log(String t_ID, String train_content, String train_achieve) {
        T_ID = t_ID;
        this.train_content = train_content;
        this.train_achieve = train_achieve;
    }

    public String getT_ID() {
        return T_ID;
    }

    public void setT_ID(String t_ID) {
        T_ID = t_ID;
    }

    public String gettrain_content() {
        return train_content;
    }

    public void settrain_content(String train_content) {
        this.train_content = train_content;
    }

    public String gettrain_achieve() {
        return train_achieve;
    }

    public void settrain_achieve(String train_achieve) {
        this.train_achieve = train_achieve;
    }

    public train_log(){

    }
}
