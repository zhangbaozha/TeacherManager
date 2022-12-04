package View;

import Entity.SalaryItem;
import Entity.Teacher;
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
public class AdminCheckAllTeacher {
    public AdminCheckAllTeacher(){
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectAll();
        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("教师信息详情");//设置窗体标题
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
        String[] titles = { "工号", "姓名" ,"性别","年龄","职称","籍贯","学历","电话","所在单位"};
        DefaultTableModel model = null;
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        double sum = 0;
        for (Teacher item : teachers) {
            model.addRow(new String[] {item.getCardid()+"",item.getUsername()+"",item.getGender()+"",item.getAge()+"",item.getJobrank()+"",item.getBirthplace(),item.getDegree(),item.getTelnum(),item.getUnit()});

        }


        frame.add(new JScrollPane(table));

        frame.setVisible(true);
    }


}
