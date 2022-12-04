package utils;

import Entity.Admin;
import Entity.Teacher;

import mapper.AdminMapper;
import mapper.TeacherMapper;

import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class LoginUtil {
    public static boolean userlogin(String cardid,String password){
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper userMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> users = userMapper.find(cardid,password);
        if(users.isEmpty()){
            return false;
        }
        else return true;
    }




    public static boolean adminlogin(String username,String password){
        SqlSession sqlSession = MybatisUtils.getSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> admins = adminMapper.find(username,password);
        if(admins.isEmpty()){
            return false;
        }
        else return true;
    }
}
