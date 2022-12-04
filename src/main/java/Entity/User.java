package Entity;/**
 * @author zhw
 * Date:2022/12/1
 */
public class User {

    //创建 SingleObject 的一个对象
    private static User instance = new User();
    private String cardid;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    //让构造函数为 private，这样该类就不会被实例化
    private User(){}

    //获取唯一可用的对象
    public static User getInstance(){
        return instance;
    }


}
