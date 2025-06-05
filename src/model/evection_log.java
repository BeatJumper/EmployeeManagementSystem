///
/// @file evection_log.java
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
