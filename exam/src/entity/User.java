package entity;

/**
 * 用户
 */
public class User {
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private  String password;

    /**
     * 角色 1老师 0学生
     */
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
