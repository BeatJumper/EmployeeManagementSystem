///
/// @file object.java
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
