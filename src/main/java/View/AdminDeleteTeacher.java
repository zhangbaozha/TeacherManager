package View;

import Entity.Teacher;
import Entity.User;
import mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author zhw
 * Date:2022/12/1
 */
public class AdminDeleteTeacher {
    private JTextField text_cardid;


    public AdminDeleteTeacher(){


        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper userMapper = sqlSession.getMapper(TeacherMapper.class);

        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("管理员开除老师");//设置窗体标题
        frame.setSize(400, 800);//设置窗体大小，只对顶层容器生效
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(true);//禁止调整窗体大小
        frame.setFont(new Font("宋体", Font.PLAIN, 14));//设置字体，显示格式正常，大小

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐组件之间的间隔为10个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        //实例化流式布局类的对象
        frame.setLayout(fl);

        //实例化JLabel标签对象，该对象显示“账号”
        JLabel labname = new JLabel("工号：");
        labname.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labname标签添加到窗体上
        frame.add(labname);
        //实例化JTextField标签对象化
        text_cardid = new JTextField();
        Dimension dim1 = new Dimension(300, 30);
        text_cardid.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
        //将textName标签添加到窗体上
        frame.add(text_cardid);




        JButton button = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100, 30);
        button.setText("确认修改");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cardid= text_cardid.getText();
                userMapper.deleteTeacher(cardid);
                sqlSession.commit();

                JOptionPane.showMessageDialog(null, "开除成功");



            }
        });
        button.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        button.setSize(dim2);
        frame.add(button);


        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后



    }






}

