package View;


import Entity.User;
import utils.LoginUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherLogin implements ActionListener {

    private JPasswordField text_password;
    private JTextField text_username;

    //在类中定义主函数


    //在类中定义初始化界面的方法
    public TeacherLogin() {
        //在initUI中实例化JFrame类的对象
        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("普通用户登录");//设置窗体标题
        frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
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
        text_username = new JTextField();
        Dimension dim1 = new Dimension(300, 30);
        text_username.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
        //将textName标签添加到窗体上
        frame.add(text_username);

        //实例化JLabel标签对象，该对象显示“密码”
        JLabel labpass = new JLabel("密码：");
        labpass.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(labpass);

        //实例化JPasswordField
        text_password = new JPasswordField();
        //设置大小
        text_password.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_password);

        //实例化JButton组件
        JButton button = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100, 30);
        button.setText("登录");
        button.setActionCommand("Login");
        button.addActionListener(this);
        button.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        button.setSize(dim2);
        frame.add(button);

        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Login")) {
            //获取用户名密码
            String cardid = text_username.getText();
            String password = text_password.getText();

            Dimension dim3 = new Dimension(300, 30);

            //生成新界面
            JFrame login2 = new JFrame();
            login2.setSize(400, 200);
            login2.setLocationRelativeTo(null);
            login2.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
            //创建组件
            JPanel jp1 = new JPanel();
            JPanel jp2 = new JPanel();
            if (LoginUtil.userlogin(cardid, password)) {
                JLabel message = new JLabel("登陆成功！");
                User object = User.getInstance();
                object.setCardid(cardid);
                message.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
                message.setPreferredSize(dim3);
                jp1.add(message);
                login2.add(jp1, BorderLayout.CENTER);
                login2.setVisible(true);
                new TeacherMenu();
            } else {
                JLabel message = new JLabel("登录失败");
                message.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
                message.setPreferredSize(dim3);
                //将textName标签添加到窗体上
                jp1.add(message);
                login2.add(jp1, BorderLayout.CENTER);

                JButton close = new JButton("确定");
                close.setFont(new Font("宋体", Font.PLAIN, 14));
                //设置按键大小
                close.setSize(dim3);
                jp2.add(close);
                login2.add(jp2, BorderLayout.SOUTH);
                login2.setVisible(true);
            }

        }
    }
}

