package View;


import Entity.User;
import utils.NetUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AdminMenu extends JFrame {


    public AdminMenu() {
        setLayout(new GridLayout(6, 1, 5, 5));
        Container c = getContentPane();                                // 创建容器
        JButton b1 = new JButton();
        b1.setText("修改教师资料");
        JButton b2 = new JButton();
        b2.setText("查询工资发放记录");
        JButton b3 = new JButton();
        b3.setText("发放工资");
        JButton b4 = new JButton();
        b4.setText("教师职位调度");
        JButton b5 = new JButton();
        b5.setText("查询所有教师信息");
        JButton b6 = new JButton();
        b6.setText("录入新教师信息");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminChangeTeacherInfo();


            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminCheckSalary();
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

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        setVisible(true);
        setTitle("管理员菜单");
        setBounds(100, 100, 400, 200);
    }

}




