package com.briup.app02.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService {
	//自动注入
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<Student> findAll()throws Exception{
		//调用studentMapper查询所有学生信息
		List<Student> list = studentMapper.findAll();
		return list;
	}
	@Override
	public Student findById(long id) throws Exception {
		//1. 通过id查找
		Student student = studentMapper.findById(id);
		//2. 如果该学生存在，执行查询操作，如果该学生不存在，抛出异常
		if(student!=null){
			return student;
		}else{
			throw new Exception("该学生不存在！");
		}		
	}
	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		Student student = studentMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(student!=null){
		 studentMapper.deleteById(id);
		}else{
			throw new Exception("该学生不存在！");
		}		
	}
	@Override
	public void insertStudent(Student student) throws Exception {
		//1. 通过id查找
		Student stu = studentMapper.findById(student.getId());
		//2. 如果该学生存在，抛出异常，如果该学生不存在，执行插入操作
		if(stu!=null){
			throw new Exception("该学生已存在！");
		}else{
			studentMapper.insertStudent(student);
			}		
	}
	@Override
	public void updateStudent(Student student) throws Exception {
		//1. 通过id查找
		Student stu = studentMapper.findById(student.getId());
		//2. 如果该学生存在，执行更新操作，如果该学生不存在，抛出异常
		if(stu!=null){
			studentMapper.updateStudent(student);
		}else{
			throw new Exception("该学生不存在！");
			}		
	}
}
