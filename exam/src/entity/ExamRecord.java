package entity;

/**
 * 考试记录
 */
public class ExamRecord {
    private  int id;
    /**
     * 用户编号
     */
    private int uid;
    /**
     * 考试成绩
     */
    private  int result;

    /**
     * 用户名称
     */
    private String username;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
