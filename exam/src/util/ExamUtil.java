package util;

import dao.ExamMapper;
import dao.MybatisUtil;
import entity.Exam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 考试工具类
 */
public class ExamUtil {
    static Scanner scanner=new Scanner(System.in);

    static ExamMapper dto= MybatisUtil.getMapper(ExamMapper.class);

    /**
     * 修改考试信息
     */
    public static void update(){
        System.out.println("请输入考试总分");
        Integer count=scanner.nextInt();
        System.out.println("请输入考试题目");
        Integer contentCount=scanner.nextInt();
        System.out.println("请输入考试开始时间");
        String time=scanner.next();
        DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date =dtf.parse(time);
        } catch (ParseException e) {
            System.out.println("输入的时间格式不正确");
            e.printStackTrace();
        }
        Exam exam=new Exam();
//        exam.setContentCount(contentCount);
        exam.setCount(count);
        exam.setDateTime(date);
        dto.update(exam);
    }

}
