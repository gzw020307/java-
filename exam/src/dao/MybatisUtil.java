package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    static SqlSession sqlSession=null;
    static {
        //1. 读取配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3. 使用工厂生产SqlSession对象
        sqlSession = factory.openSession(true);
    }


    /**
     * 获取 mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public static<T>  T  getMapper(Class<T> clazz){
        return sqlSession.getMapper(clazz);
    }




}
