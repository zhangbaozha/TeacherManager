package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhw
 * Date:2022/12/1
 */
public class Login extends JFrame {
    public Login(){
        setLayout(new GridLayout(2, 1, 5, 5));
        Container c = getContentPane();								// 创建容器
        JButton btn[] = new JButton[2];								// 创建按钮数组
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();									// 实例化数组中的对象
            c.add(btn[i]);											// 将按钮添加到容器中
        }
        btn[0].setText("教师登录");
        btn[0].setFont(new Font("宋体", Font.PLAIN, 50));


        btn[1].setText("管理员登录");
        btn[1].setFont(new Font("宋体", Font.PLAIN, 50));


        setVisible(true);
        setTitle("登录");
        setBounds(100, 100, 800, 400);

        btn[0].addActionListener(new ActionListener() {				// 为按钮添加监听事件
            public void actionPerformed(ActionEvent e) {
                new TeacherLogin();
            }
        });
        btn[1].addActionListener(new ActionListener() {				// 为按钮添加监听事件
            public void actionPerformed(ActionEvent e) {
                new AdminLogin();
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
