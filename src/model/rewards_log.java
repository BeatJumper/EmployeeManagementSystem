///
/// @file rewards_log.java
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

public class rewards_log {
    public String rewards_ID;
    public String rewards_name;
    public String rewards_type;
    public Date rewards_time;
    public String M_ID;
    public String getRewards_ID() {
        return rewards_ID;
    }

    public void setRewards_ID(String rewards_ID) {
        this.rewards_ID = rewards_ID;
    }

    public String getRewards_name() {
        return rewards_name;
    }

    public void setRewards_name(String rewards_name) {
        this.rewards_name = rewards_name;
    }

    public String getRewards_type() {
        return rewards_type;
    }

    public void setRewards_type(String rewards_type) {
        this.rewards_type = rewards_type;
    }

    public Date getRewards_time() {
        return rewards_time;
    }

    public void setRewards_time(Date rewards_time) {
        this.rewards_time = rewards_time;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }
}
