package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMenu extends JFrame {


    public TeacherMenu() {
        setLayout(new GridLayout(3, 1, 5, 5));
        Container c = getContentPane();                                // 创建容器
        JButton b1 = new JButton();
        b1.setText("编辑资料");
        JButton b2 = new JButton();
        b2.setText("修改密码");
        JButton b3 = new JButton();
        b3.setText("工资查询");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new TeacherChangeInfo();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new TeacherChangePassword();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new TeacherCheckSalary();
            }
        });

        c.add(b1);
        c.add(b2);
        c.add(b3);
        setVisible(true);
        setTitle("创建不同样式的按钮");
        setBounds(100, 100, 400, 200);
    }



}




