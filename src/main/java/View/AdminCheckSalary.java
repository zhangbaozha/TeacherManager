package View;

import Entity.SalaryItem;
import Entity.Teacher;
import Entity.User;
import mapper.SalaryItemMapper;
import mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author zhw
 * Date:2022/12/2
 */
public class AdminCheckSalary {

    public AdminCheckSalary(){

        SqlSession sqlSession = MybatisUtils.getSession();
        SalaryItemMapper salaryItemMapperMapper = sqlSession.getMapper(SalaryItemMapper.class);
        List<SalaryItem> salaryItems = salaryItemMapperMapper.selectAll();

        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("工资发放记录");//设置窗体标题
        frame.setSize(600, 800);//设置窗体大小，只对顶层容器生效
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(true);//禁止调整窗体大小
        frame.setFont(new Font("宋体", Font.PLAIN, 14));//设置字体，显示格式正常，大小

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐组件之间的间隔为10个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        //实例化流式布局类的对象
        frame.setLayout(fl);



        JTable table = null;
        JFrame checkAllFrame = new JFrame("\"TableDemo\"");
        String[][] datas = {};
        String[] titles = {"工号", "基本工资", "奖金" ,"罚款","扣税","实发工资","日期"};
        DefaultTableModel model = null;
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        double sum = 0;
        for (SalaryItem item : salaryItems) {
            model.addRow(new String[] {item.getCardid(),item.getSalary()+"",item.getBonus()+"",item.getPunish()+"",item.getTax()+"",item.getRes()+"",item.getDate()});
            sum+=item.getRes();
        }

        JLabel labname = new JLabel("总计：" + sum);
        labname.setFont(new Font("宋体", Font.PLAIN, 14));
        //将labname标签添加到窗体上
        frame.add(labname);

        frame.add(new JScrollPane(table));
        System.out.println(salaryItems);
        frame.setVisible(true);

    }
}
