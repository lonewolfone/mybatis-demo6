package org.lanqiao.dao;

import org.lanqiao.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    public void addStu(Student student);
    //查询所有数据
    public List<Student> findStu();
    //查询所有数据，返回一个Map<>集
    public Map<String,String> findStuMap();
    //查询一条数据
    public  Student findOneStuById(int id);
    //查询 姓名，进行模糊查询
    public List<Student> findStuByName(String sname);
    //删除一条数据
    public void deleteStuById(int id);
    //更新数据
    public void updateStuById(Student student);
    //多条件查询:动态代理
    public List<Student> findStuByAll(int id,String sname ,int sage ,String ssex);
    //多条件查询：动态代理,数组
    //public List<Student> findStudentByInCondition(int[] arr);
    //多条件查询：动态代理,list集合
    //public List<Student> findStudentByInCondition(List<Integer> arr);
    //多条件查询：动态代理,自定义类型地list
    public List<Student> findStudentByInCondition(List<Student> arr);


}
