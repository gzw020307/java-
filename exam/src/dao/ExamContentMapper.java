package dao;

import entity.ExamContent;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 考试题目
 */
public interface ExamContentMapper {
    /**
     * 保存
     * @param content
     */
    @Insert("insert into exam_content values(null,#{content.desc},#{content.A},#{content.B},#{content.C},#{content.D},#{content.answer})")
    public void  save(@Param("content") ExamContent content);



    /**
     * 删除
     * @param id
     */
    @Delete("delete from exam_content where id=#{id}")
    public void delete(@Param("id") Integer id);

    /**
     * 修改
     * @param content
     */
    @Update("update exam_content set `desc`=#{content.desc}, A=#{content.A} ,B=#{content.B},C=#{content.C},D=#{content.D},answer=#{content.answer} where id=#{content.id}")
    public void  update(@Param("content") ExamContent content);

    /**
     * 获取考试题目
     * @param count
     * @return
     */
    @Select("select * from exam_content limit #{count}")
    public List<ExamContent> list(@Param("count") int count);
}
