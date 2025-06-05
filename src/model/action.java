///
/// @file action.java
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

public class action {

    public String A_ID;
    public String A_Name;
    public action(String a_ID, String a_Name) {
        A_ID = a_ID;
        A_Name = a_Name;
    }

    public String getA_ID() {
        return A_ID;
    }

    public void setA_ID(String a_ID) {
        A_ID = a_ID;
    }

    public String getA_Name() {
        return A_Name;
    }

    public void setA_Name(String a_Name) {
        A_Name = a_Name;
    }

}
