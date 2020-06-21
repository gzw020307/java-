import dao.*;
import entity.Exam;
import entity.ExamContent;
import entity.ExamRecord;
import entity.User;
import util.ExamContentUtil;
import util.ExamUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ExamTest {
    static Scanner scanner=new Scanner(System.in);

    UserMapper userDto= MybatisUtil.getMapper(UserMapper.class);

    ExamRecordMapper examRecorddto=MybatisUtil.getMapper(ExamRecordMapper.class);

    ExamContentMapper examContentDto=MybatisUtil.getMapper(ExamContentMapper.class);

    ExamMapper examDto=MybatisUtil.getMapper(ExamMapper.class);

    public static void main(String[] args) {
        ExamTest exam=new ExamTest();
        exam.exam();
    }



    /**
     * 开始考试
     */
    public void  exam(){
        welcome();
        User loginUser=login();
        if (loginUser==null){
           System.out.println("登录失败 退出");
           return;
        }
        System.out.println("登录成功 欢迎你 "+loginUser.getUsername());
        if (loginUser.getRole()==1){
            //教师登录 展示管理
            admin();
        }else{
            //学生登录 考试
            studentExam(loginUser.getId());
        }
    }

    /**
     * 欢迎语
     */
    public void  welcome(){
        System.out.println("欢迎进入考试系统,");
    }

    /**
     * 登录
     */
    public User  login(){
        System.out.println("请输入用户名");
        String username=scanner.next();
        System.out.println("请输入密码");
        String password=scanner.next();
        return userDto.login(username,password);
    }

    /**
     * 老师登录 管理平台
     */
    public void  admin(){
        System.out.println("1:题库管理");
        System.out.println("2:考试管理");
        System.out.println("3:成绩管理");
        System.out.println("4:成绩统计");
        System.out.println("5:退出");
        int choose=0;
        while (choose!=5){
            System.out.println("请选择（1-5）");
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    examContentManage() ;
                    break;
                case 2:
                    examManage();
                    break;
                case 3:
                    queryRecord();
                    break;
                case 4:
                    recordStatistics();
                    break;
                default:
                    System.out.println("请输入1-5的选项");
                    break;
            }
        }
    }

    /**
     * 题库管理
     */
    public void  examContentManage(){
        System.out.println("1:增加题目");
        System.out.println("2:删除题目");
        System.out.println("3:修改题目");
        System.out.println("4:退出");
        int choose=0;
        while (choose!=4){
            System.out.println("请选择（1-4）");
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    ExamContentUtil.add();
                    break;
                case 2:
                    ExamContentUtil.delete();
                    break;
                case 3:
                    ExamContentUtil.update();
                    break;
                default:
                    System.out.println("请输入1-4的选项");
                    break;
            }
        }
    }

    /**
     * 考试管理
     */
    public void  examManage(){
        System.out.println("1:修改考试信息");
        System.out.println("2:退出");
        int choose=0;
        while (choose!=2){
            System.out.println("请选择（1）");
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    ExamUtil.update();
                    break;
                default:
                    System.out.println("请输入1-2的选项");
                    break;
            }
        }
    }

    /**
     * 查询考试成绩
     */
    public void  queryRecord(){
        List<ExamRecord> list=examRecorddto.list();
        for (ExamRecord exam:list){
            System.out.println("姓名+"+exam.getUsername()+"成绩:"+exam.getResult());
        }
    }

    /**
     * 统计成绩
     */
    public void  recordStatistics(){
        List<ExamRecord> list=examRecorddto.list();
        //总人数
        int count=list.size();
        //最高分
        int max=list.get(0).getResult();
        //最低分
        int min=list.get(0).getResult();
        //总分
        int sum=0;
        //通过人数
        int pass=0;
        //未及格人数
        int nopass=0;
        //优秀人数
        int excellent=0;
        for (ExamRecord exam:list){
            if (exam.getResult()>max){
                max=exam.getResult();
            }
            if (exam.getResult()<min){
                min=exam.getResult();
            }
            sum+=exam.getResult();
            if (exam.getResult()>=80){
                excellent++;
            }else if (exam.getResult()>=60){
                pass++;
            }else {
                nopass++;
            }
        }
        System.out.printf("最高分 %d %n",max);
        System.out.printf("最低分 %d %n",min);
        System.out.println("平均分"+except(sum,count));
        System.out.println("优良率"+except(excellent,count)+"及格率"+except(pass,count)+" 不及格率 "+except(nopass,count));
    }

    /**
     * 除运算 (保留两位小数)
     * @param a
     * @param b
     * @return
     */
    public double except(double a,double b){
        BigDecimal bigDecimal=new BigDecimal(a/b);
        bigDecimal.setScale(2,BigDecimal.ROUND_DOWN);
        return bigDecimal.doubleValue();
    }

    /**
     * 学生参加考试
     */
    public void  studentExam(int uid){
        Exam exam= examDto.queryone();
        //每题分数
        int avg=exam.getCount()/exam.getContent_count();
        //总分
        int sum=0;
        System.out.println("考试马上开始 请答题");
        List<ExamContent> list=examContentDto.list(exam.getCount());
        for (int i=0;i<list.size(); i++){
            System.out.println(i+1+":"+list.get(i).getDesc());
            System.out.println("A:"+list.get(i).getA());
            System.out.println("B:"+list.get(i).getB());
            System.out.println("C:"+list.get(i).getC());
            System.out.println("D:"+list.get(i).getD());
            System.out.println("请输入你的答案");
            String answer= scanner.next();
            if(list.get(i).getAnswer().equals(answer)){
                sum+=avg;
            }
        }
        //结束后 讲本次考试记录数据库
        System.out.println("答题结束："+sum+"分");
        ExamRecord record=new ExamRecord();
        record.setUid(uid);
        record.setResult(sum);
        examRecorddto.save(record);
    }

}
