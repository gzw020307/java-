package util;

import dao.ExamContentMapper;
import dao.MybatisUtil;
import entity.ExamContent;

import java.util.Scanner;

/**
 * 考试题目管理操作类
 */
public class ExamContentUtil {
    static Scanner scanner=new Scanner(System.in);
    static ExamContentMapper dto= MybatisUtil.getMapper(ExamContentMapper.class);

    /**
     * 添加
     */
    public static void add(){
        System.out.println("请输入题目类容");
        String desc=scanner.next();
        System.out.println("a:");
        String A=scanner.next();
        System.out.println("b:");
        String B=scanner.next();
        System.out.println("c:");
        String C=scanner.next();
        System.out.println("d:");
        String D=scanner.next();
        System.out.println("答案:");
        String answer=scanner.next();
        ExamContent content=new ExamContent();
        content.setDesc(desc);
        content.setA(A);
        content.setB(B);
        content.setC(C);
        content.setD(D);
        content.setAnswer(answer);
        dto.save(content);
    }


    /**
     * 删除
     */
    public static void  delete(){
        System.out.println("请输入你想要删除的题目ID");
        Integer id=scanner.nextInt();
        dto.delete(id);
    }

    /**
     * 修改
     */
    public static void  update(){
        System.out.println("请输入你想要修改的题目ID");
        Integer id=scanner.nextInt();
        System.out.println("请输入题目类容");
        String desc=scanner.next();
        System.out.println("a:");
        String A=scanner.next();
        System.out.println("b:");
        String B=scanner.next();
        System.out.println("c:");
        String C=scanner.next();
        System.out.println("d:");
        String D=scanner.next();
        System.out.println("答案:");
        String answer=scanner.next();
        ExamContent content=new ExamContent();
        content.setId(id);
        content.setDesc(desc);
        content.setA(A);
        content.setB(B);
        content.setC(C);
        content.setD(D);
        content.setAnswer(answer);
        dto.update(content);
    }

}
