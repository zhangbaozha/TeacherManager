package View;

import Entity.SalaryItem;
import Entity.Teacher;
import Entity.User;
import mapper.SalaryItemMapper;
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
public class AdminPaySalary {
    private JTextField text_cardid;
    private JTextField text_salary;
    private JTextField text_bonus;
    private JTextField text_punish;
    private JTextField text_tax;
    private JTextField text_year;
    private JTextField text_month;




    public AdminPaySalary(){


        SqlSession sqlSession = MybatisUtils.getSession();
        SalaryItemMapper mapper = sqlSession.getMapper(SalaryItemMapper.class);

        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("管理员发放工资");//设置窗体标题
        frame.setSize(420, 800);//设置窗体大小，只对顶层容器生效
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


        //实例化JLabel标签对象，该对象显示“密码”
        JLabel labpass = new JLabel("基本工资：");
        labpass.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(labpass);
        //实例化JPasswordField
        text_salary = new JTextField();
        //设置大小
        text_salary.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_salary);


        //实例化JLabel标签对象，该对象显示“密码”
        JLabel l1 = new JLabel("奖金：");
        l1.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(l1);
        //实例化JPasswordField
        text_bonus = new JTextField();
        //设置大小
        text_bonus.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_bonus);


        //实例化JLabel标签对象，该对象显示“密码”
        JLabel l2 = new JLabel("罚款：");
        l2.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(l2);
        //实例化JPasswordField
        text_punish = new JTextField();
        //设置大小
        text_punish.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_punish);


        //实例化JLabel标签对象，该对象显示“密码”
        JLabel l3 = new JLabel("扣税：");
        l3.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(l3);
        //实例化JPasswordField
        text_tax = new JTextField();
        //设置大小
        text_tax.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_tax);

        //实例化JLabel标签对象，该对象显示“密码”
        JLabel l4 = new JLabel("发放年：");
        l4.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(l4);
        //实例化JPasswordField
        text_year = new JTextField();
        //设置大小
        text_year.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_year);



        //实例化JLabel标签对象，该对象显示“密码”
        JLabel l5 = new JLabel("发放月：");
        l4.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labpass添加到窗体上
        frame.add(l5);
        //实例化JPasswordField
        text_month = new JTextField();

        //设置大小
        text_month.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_month);




        JButton button = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100, 30);
        button.setText("确认发放");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalaryItem salaryItem = new SalaryItem();
                salaryItem.setCardid(text_cardid.getText());
                salaryItem.setSalary(Double.parseDouble(text_salary.getText()));
                salaryItem.setBonus(Double.parseDouble(text_bonus.getText()));
                salaryItem.setPunish(Double.parseDouble(text_punish.getText()));
                salaryItem.setTax(Double.parseDouble(text_tax.getText()));
                salaryItem.setYear(text_year.getText());
                salaryItem.setMonth(text_month.getText());

                salaryItem.setRes(Double.parseDouble(text_salary.getText())+Double.parseDouble(text_bonus.getText())-Double.parseDouble(text_punish.getText())-Double.parseDouble(text_tax.getText()));


                System.out.println(salaryItem.getRes());
                mapper.insert(salaryItem);
                sqlSession.commit();

                JOptionPane.showMessageDialog(null, "添加成功");



            }
        });
        button.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置按键大小
        button.setSize(dim2);
        frame.add(button);


        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后



    }





}

