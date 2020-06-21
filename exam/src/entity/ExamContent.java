package entity;

/**
 * 考试内容（题目）
 */
public class ExamContent {
    private int id;
    /**
     * 题目内容
     */
    private String desc;
    /**
     * A选项
     */
    private String A;
    /**
     * B选项
     */
    private String B;
    /**
     * C选项
     */
    private String C;
    /**
     * D选项
     */
    private String D;
    /**
     * 答案
     */
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
