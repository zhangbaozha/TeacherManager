package mapper;

import Entity.Admin;
import Entity.Teacher;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface AdminMapper {

    List<Admin> find(@Param("username") String username, @Param("password") String password);
}
