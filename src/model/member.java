///
/// @file member.java
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
