package dao;

import entity.ExamRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ExamRecordMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from exam_record r left join user u on u.id=r.uid")
    public List<ExamRecord> list();

    @Insert("insert into exam_record values (null,#{record.uid},#{record.result})")
    public void save(@Param("record") ExamRecord record);
}
