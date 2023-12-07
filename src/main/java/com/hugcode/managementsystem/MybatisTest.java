package com.hugcode.managementsystem;

import com.hugcode.managementsystem.mapper.StudentCourseMapper;
import com.hugcode.managementsystem.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test(){
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过class来获取sqlSession

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
            System.out.println(studentMapper.updatePassword("10","241"));
            sqlSession.commit();
        }

    }
}
