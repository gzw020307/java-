package dao;

import entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExamMapper {
    /**
     * 修改
     * @param exam
     */
    @Update("update exam set count=#{exam.count},content_count=#{exam.contentCount},date_time=#{exam.dateTime}")
    public void  update(@Param("exam") Exam exam);

    /**
     * 查询本次考试信息
     * @return
     */
    @Select("select * from exam  limit 1")
    public Exam queryone();

}
