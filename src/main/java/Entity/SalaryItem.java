package Entity;

import lombok.Data;

/**
 * @author zhw
 * Date:2022/12/1
 */
@Data
public class SalaryItem {
    private int id;
    private String cardid;
    private double salary;
    private double bonus;
    private double punish;
    private double tax;
    private double res;
    private String date;

}
