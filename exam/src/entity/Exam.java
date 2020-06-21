package entity;

import java.util.Date;

/**
 * 考试信息
 */
public class Exam {
    private  int id;
    /**
     * 总分
     */
    private  int count;

    /**
     * 题目数量
     */
    private  int content_count;

    /**
     * 开考试卷
     */
    private Date dateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getContent_count() {
        return content_count;
    }

    public void setContent_count(int content_count) {
        this.content_count = content_count;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
