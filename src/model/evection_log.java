package model;

public class evection_log {
    public String T_ID;
    public String destination;
    public String objective;

    public String getT_ID() {
        return T_ID;
    }

    public void setT_ID(String t_ID) {
        T_ID = t_ID;
    }

    public String getdestination() {
        return destination;
    }

    public void setdestination(String destination) {
        this.destination = destination;
    }

    public String getobjective() {
        return objective;
    }

    public void setobjective(String objective) {
        this.objective = objective;
    }

    public evection_log(String t_ID, String destination, String objective) {
        T_ID = t_ID;
        this.destination = destination;
        this.objective = objective;
    }
    public evection_log() {

    }
}
