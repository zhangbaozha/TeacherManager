package Entity;

import lombok.Data;

/**
 * @author zhw
 * Date:2022/12/1
 */
@Data
public class Teacher {

    private String username;   //姓名
    private String password;   //密码
    private String cardid;
    private String gender;
    private String age;
    private String jobrank;
    private String birthplace;
    private String degree;
    private String telnum;
    private String unit;
}
