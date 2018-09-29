package org.lanqiao.pojo;

import java.util.Objects;

public class Student {
    private int id;
    private String sname;
    private int   sage;
    private String ssex;
    public Student(){

    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String sname, int sage, String ssex) {
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
    }

    public Student(int id, String sname, int sage, String ssex) {
        this.id = id;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                sage == student.sage &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(ssex, student.ssex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sname, sage, ssex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                '}';
    }
}
