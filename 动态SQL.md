##动态SQL

### 1、概要

![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\83.png)

###2、实例

- if标签

  - StudentMapper类

    ```java
    //多条件查询:动态代理
        public List<Student> findStuByAll(int id,String sname ,int sage ,String ssex);
    ```

  - StudentMapper.xml

    ```xml
    <select id="findStuByAll" resultType="Student">
            select * from stu where 1 = 1
            <if test="arg0 != 0">
                AND id = #{arg0}
            </if>
            <if test="arg0 != null">
                AND sname like '%' #{arg1} '%'
            </if>
        </select>
    ```

  - studentTest类

    ```java
     @Test
        //多条件查询：动态代理
        public void findStuByAllTest(){
            List<Student> studentList = studentMapper.findStuByAll(0,"沛",0,null);
            for (Student str:studentList){
                System.out.println(str);
            }
        }
    ```

- where标签

  - StudentMapper类

  - StudentMapper.xml

    ```xml
    <!--：多条件查询:动态代理-->
        <select id="findStuByAll" resultType="Student">
            select * from stu
            <where>
                <if test="arg0 != 0">
                    AND id = #{arg0}
                </if>
                <if test="arg0 != null">
                    AND sname like '%' #{arg1} '%'
                </if>
            </where>
        </select>
    ```

  - studentTest类

- choose标签

  - StudentMapper类

  - StudentMapper.xml

    ```xml
    <!--：多条件查询:动态代理-->
        <select id="findStuByAll" resultType="Student">
            select * from stu
            <where>
                <choose>
                    <when test="arg0 != 0">
                        AND id = #{arg0}
                    </when>
                    <when test="arg0 != null">
                        AND sname like '%' #{arg1} '%'
                    </when>
                </choose>
            </where>
        </select>
    ```

  - studentTest类

- foreach标签

  ![](C:\Users\听音乐的酒\Desktop\笔记\学习笔记\imgs\84.png)

  - 遍历数组

    - StudentMapper类

      ```java
      //多条件查询：动态代理,数组
          public List<Student> findStudentByInCondition(int[] arr);
      ```

    - StudentMapper.xml

      ```xml
       <!--：多条件查询:动态代理，数组-->
          <select id="findStudentByInCondition" resultType="Student">
              select * from stu
              <where>
                  id in
                  <foreach collection="array" item="id" open="(" separator="," close=")">
                      #{id}
                  </foreach>
              </where>
          </select>
      ```

    - studentTest类

      ```java
      @Test
          //多条件查询：动态代理，数组
          public void findStudentByInConditionTest(){
             List<Student> studentList = studentMapper.findStudentByInCondition(new int[]{1,2,3,4,5});
              for (Student str:studentList){
                  System.out.println(str);
              }
          }
      ```

  - 遍历基本类型的List

    - StudentMapper类

      ```java
      //多条件查询：动态代理,list集合
          public List<Student> findStudentByInCondition(List<Integer> arr);
      ```

    - StudentMapper.xml

      ```xml
       <!--：多条件查询:动态代理，list-->
          <select id="findStudentByInCondition" resultType="Student">
              select * from stu
              <where>
                  id in
                  <foreach collection="list" item="id" open="(" separator="," close=")">
                      #{id}
                  </foreach>
              </where>
          </select>
      ```

    - studentTest类

      ```java
      @Test
          //多条件查询：动态代理，list
          public void findStudentByInConditionTest(){
              List<Integer> list = new ArrayList<>();
              list.add(1);
              list.add(3);
              list.add(5);
              list.add(7);
              list.add(9);
             List<Student> studentList = studentMapper.findStudentByInCondition(list);
              for (Student str:studentList){
                  System.out.println(str);
              }
          }
      ```

  - 遍历自定义类型的List

    - StudentMapper类

      ```java
      //多条件查询：动态代理,自定义类型地list
          public List<Student> findStudentByInCondition(List<Student> arr);
      ```

    - StudentMapper.xml

      ```xml
      <!--：多条件查询:动态代理，自定义类型-->
          <select id="findStudentByInCondition" resultType="Student">
              select * from stu
              <where>
                  id in
                  <foreach collection="list" item="student" open="(" separator="," close=")">
                      #{student.id}
                  </foreach>
              </where>
          </select>
      ```

    - studentTest类

      ```java
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
      ```

- <sql>和<include>

  ```xml
  <!--sql片段-->
      <sql id="baseSql">
          select * from stu
      </sql>
      <!--：多条件查询:动态代理，自定义类型-->
      <select id="findStudentByInCondition" resultType="Student">
          <!--包含sql片段-->
          <include refid="baseSql"></include>
          <where>
              id in
              <foreach collection="list" item="student" open="(" separator="," close=")">
                  #{student.id}
              </foreach>
          </where>
      </select>
  ```

- 当当

3、高级查询(多表查询)

- 关联查询：查询内容涉及具有多个关系的多个表时
  - 一对多
    - 多表链接查询
    - 多表单独查询
  - 多对一
    - 多表链接查询
    - 多表单独查询
  - 多对多
- 延迟加载
- 查询缓存
  - 一级缓存
  - 二级缓存
    - 验证增删改对二级缓存的影响
    - 二级缓存关闭
    - 级缓存的使用原则

4、当当