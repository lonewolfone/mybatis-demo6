package org.lanqiao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.dao.StudentMapper;
import org.lanqiao.pojo.Student;
import org.lanqiao.utils.mybatisUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class studentTest {
    /*
     StudentMapper studentMapper = new IStudentMapperImpl();
   * 删除了：dao层的实现类：IStudentDaoImpl
   * 但在Test方法中需要 studentMapper这个对象
   * 如何得到studentMapper这个对象
   * */
//    StudentMapper studentMapper = new IStudentMapperImpl();
    StudentMapper studentMapper;
    SqlSession sqlSession;
    @Before
    public void init(){
        //获取sqlSession对象
        sqlSession = mybatisUtils.getSqlSession("mybatis-config.xml");
        //为dao创建对象(通过动态代理生成实体类)
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }
    @Test
    public void addStudent(){
        Student student1= new Student("呜呜",29,"男");
        studentMapper.addStu(student1);
    }
    //查询所有
    @Test
    public void findAllStudent(){
        List<Student> allStudentList =studentMapper.findStu();
        for (Student student:allStudentList){
            System.out.println(student);
        }
    }
    //查询所有，返回一个Map集
    @Test
    public void findAllStuMap(){
        Map<String,String> studentMap= studentMapper.findStuMap();
        Set<String> stringSet = studentMap.keySet();
        for (String setstr : stringSet){
            String student3 =studentMap.get(setstr);
            System.out.println(student3);
        }
    }
    //查询一条数据
    @Test
    public void findOneStuMap(){
        Student student6 = studentMapper.findOneStuById(15);
        System.out.println(student6);
    }
    //模糊查询
    @Test
    public void findStuByName(){
        List<Student> studentList = studentMapper.findStuByName("三");
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
    //删除
    @Test
    public void deleteStuById(){
        studentMapper.deleteStuById(20);
    }
    //更新
    @Test
    public void updateStuById(){
        Student student2 = new Student(15,"艾小羊",24,"男");
        studentMapper.updateStuById(student2);
    }
    @Test
    //多条件查询：动态代理
    public void findStuByAllTest(){
        List<Student> studentList = studentMapper.findStuByAll(0,"沛",0,null);
        for (Student str:studentList){
            System.out.println(str);
        }
    }

    @Test
    //多条件查询：动态代理，自定义类型Student
    public void findStudentByInConditionTest(){
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setId(1);
        Student stu2 = new Student();
        stu2.setId(3);
        Student stu3 = new Student();
        stu3.setId(5);
        Student stu4 = new Student();
        stu4.setId(7);
        Student stu5 = new Student();
        stu5.setId(9);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
       List<Student> studentList = studentMapper.findStudentByInCondition(list);
        for (Student str:studentList){
            System.out.println(str);
        }
    }
}
