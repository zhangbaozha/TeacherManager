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

/**
 * @author zhw
 * Date:2022/12/1
 */
public class TeacherChangeInfo {
    private JTextField text_cardid;
    private JTextField text_username;
    private JTextField text_gender;
    private JTextField text_age;
    private JTextField text_jobrank;
    private JTextField text_birthplace;
    private JTextField text_degree;
    private JTextField text_telnum;


public TeacherChangeInfo(){

    User u = User.getInstance();
    SqlSession sqlSession = MybatisUtils.getSession();
    TeacherMapper userMapper = sqlSession.getMapper(TeacherMapper.class);
    Teacher t = userMapper.findByCardid(u.getCardid());
    JFrame frame = new JFrame();
    //设置窗体对象的属性值
    frame.setTitle("编辑资料");//设置窗体标题
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
    text_cardid.setText(u.getCardid());
    text_cardid.setEditable(false);
    Dimension dim1 = new Dimension(300, 30);
    text_cardid.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
    //将textName标签添加到窗体上
    frame.add(text_cardid);


    //实例化JLabel标签对象，该对象显示“密码”
    JLabel labpass = new JLabel("用户名：");
    labpass.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(labpass);
    //实例化JPasswordField
    text_username = new JTextField();
    text_username.setText(t.getUsername());
    //设置大小
    text_username.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_username);


    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l1 = new JLabel("性别：");
    l1.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l1);
    //实例化JPasswordField
    text_gender = new JTextField();
    text_gender.setText(t.getGender());
    //设置大小
    text_gender.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_gender);


    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l2 = new JLabel("年龄：");
    l2.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l2);
    //实例化JPasswordField
    text_age = new JTextField();
    text_age.setText(t.getAge()+"");
    //设置大小
    text_age.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_age);

    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l3 = new JLabel("职称：");
    l3.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l3);
    //实例化JPasswordField
    text_jobrank = new JTextField();
    text_jobrank.setText(t.getJobrank());
    //设置大小
    text_jobrank.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_jobrank);

    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l4 = new JLabel("籍贯：");
    l4.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l4);
    //实例化JPasswordField
    text_birthplace = new JTextField();
    text_birthplace.setText(t.getBirthplace());
    //设置大小
    text_birthplace.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_birthplace);


    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l5 = new JLabel("学历：");
    l5.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l5);
    //实例化JPasswordField
    text_degree = new JTextField();
    text_degree.setText(t.getDegree());
    //设置大小
    text_degree.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_degree);

    //实例化JLabel标签对象，该对象显示“密码”
    JLabel l6 = new JLabel("电话：");
    l6.setFont(new Font("宋体", Font.PLAIN, 14));
    //将labpass添加到窗体上
    frame.add(l6);
    //实例化JPasswordField
    text_telnum = new JTextField();
    text_telnum.setText(t.getTelnum());
    //设置大小
    text_telnum.setPreferredSize(dim1);
    //添加到窗体
    frame.add(text_telnum);

    JButton button = new JButton();
    //设置按键的显示内容
    Dimension dim2 = new Dimension(100, 30);
    button.setText("确认修改");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Teacher teacher = new Teacher();
            teacher.setCardid(t.getCardid());
            teacher.setUsername(text_username.getText());
            teacher.setGender(text_gender.getText());
            teacher.setAge(text_age.getText());
            teacher.setJobrank(text_jobrank.getText());
            teacher.setBirthplace(text_birthplace.getText());
            teacher.setDegree(text_degree.getText());
            teacher.setTelnum(text_telnum.getText());

            teacher.setPassword(t.getPassword());
            teacher.setUnit(t.getUnit());
            userMapper.update(teacher);
            sqlSession.commit();

            JOptionPane.showMessageDialog(null, "修改成功");



        }
    });
    button.setFont(new Font("宋体", Font.PLAIN, 14));
    //设置按键大小
    button.setSize(dim2);
    frame.add(button);


    frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后



}





}

