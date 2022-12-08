package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {


    public AdminMenu() {
        setLayout(new GridLayout(8, 1, 5, 5));
        Container c = getContentPane();                                // 创建容器
        JButton b1 = new JButton();
        b1.setText("修改教师资料");
        JButton b2 = new JButton();
        b2.setText("按时间查询工资发放记录");
        JButton b3 = new JButton();
        b3.setText("发放工资");
        JButton b4 = new JButton();
        b4.setText("教师职位调度");
        JButton b5 = new JButton();
        b5.setText("查询所有教师信息");
        JButton b6 = new JButton();
        b6.setText("录入新教师信息");
        JButton b7 = new JButton();
        b7.setText("按名字查找教师信息");
        JButton b8 = new JButton();
        b8.setText("查询工资发放记录");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminChangeTeacherInfo();


            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminCheckSalaryByDate();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminPaySalary();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminChangeTeacherUnit();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminCheckAllTeacher();
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminAddTeacher();
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminCheckTeacherByName();
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminCheckAllSalary();
            }
        });

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        c.add(b7);
        c.add(b8);
        setVisible(true);
        setTitle("管理员菜单");
        setBounds(100, 100, 400, 200);
    }

}




