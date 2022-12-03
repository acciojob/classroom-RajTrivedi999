package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.addInStudentMap(student);
    }
    public void saveTeacher(Teacher teacher){
        studentRepository.addInTeacherMap(teacher);
    }
    public void savePair(String student,String teacher){
        studentRepository.addInPair(student,teacher);
    }
    public Student getStudentList(String student){
        return studentRepository.detailOfStudent(student);
    }
    public Teacher getTeacherList(String teacher){
        return studentRepository.detailOfTeacher(teacher);
    }
    public ArrayList<String> listOfStudentForTeacher(String teacher){
        return studentRepository.listOfStudents(teacher);
    }
    public ArrayList<String> allStudentsList(){
        return studentRepository.allStudents();
    }
    public void removeStudentsForTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }
    public void clearAllData(){
        studentRepository.clearData();
    }
}
