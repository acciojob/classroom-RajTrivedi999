package com.driver;

import com.driver.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class StudentRepository {
    HashMap<String, Student> studentMap=new HashMap<>();
    HashMap<String, Teacher> teacherMap=new HashMap<>();
    HashMap<String, ArrayList<String>> pairListMap=new HashMap<>();

    public void addInStudentMap(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addInTeacherMap(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addInPair(String student, String teacher){
        if(pairListMap.containsKey(teacher)){
            ArrayList<String>studentList = pairListMap.get(teacher);
            studentList.add(student);
            pairListMap.put(teacher,studentList);
        }else{
            ArrayList<String> studentList=new ArrayList<>();
            studentList.add(student);
            pairListMap.put(teacher,studentList);
        }
    }
    public Student detailOfStudent(String student){
        return studentMap.get(student);
    }
    public Teacher detailOfTeacher(String teacher){
        return teacherMap.get(teacher);
    }
    public ArrayList<String> listOfStudents(String teacher){
        return pairListMap.get(teacher);
    }
    public ArrayList<String> allStudents(){
        ArrayList<String> all=new ArrayList<>();
        for(String names : studentMap.keySet()){
            all.add(names);
        }
        return all;
    }
    public void deleteTeacher(String teacher){
        teacherMap.remove(teacher);
        ArrayList<String> removeList=pairListMap.get(teacher);
        for(String names : removeList) {
            studentMap.remove(names);
        }
        pairListMap.remove(teacher);
    }
    public void clearData(){
        for(String names : teacherMap.keySet()){
            ArrayList<String> removeList=pairListMap.get(names);
            for(String name : removeList) {
                studentMap.remove(name);
            }
        }
        teacherMap.clear();
        pairListMap.clear();
    }
}
