package mapper;

import Entity.Teacher;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface TeacherMapper {
    List<Teacher> selectAll();
    List<Teacher> find(@Param("cardid") String cardid,@Param("password") String password);
    Teacher findByCardid(@Param("cardid") String cardid);
    void update(Teacher t);
    void insert(Teacher t);
    List<Teacher> selectByName(@Param("username") String username);
}
