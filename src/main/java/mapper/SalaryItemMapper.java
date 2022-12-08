package mapper;

import Entity.SalaryItem;
import Entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhw
 * Date:2022/12/2
 */
public interface SalaryItemMapper {
    List<SalaryItem> selectAll();
    List<SalaryItem> find(@Param("cardid") String cardid);
    List<SalaryItem> findByDate(@Param("cardid") String cardid,@Param("year") String year,@Param("month") String month);
    void insert(SalaryItem s);
}
