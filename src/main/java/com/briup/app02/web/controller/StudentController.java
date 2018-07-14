package com.briup.app02.web.controller;//控制器层，支持Post,Get,Put,Delete  请求方法

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")      
public class StudentController {
	//注入studentService的实例
	@Autowired
	private IStudentService studentService;
	
	//http://:127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent(){
		try{
		List<Student> list = studentService.findAll();
		return MsgResponse.success("查找成功！", list);
		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try{
			Student student = studentService.findById(id);
			return MsgResponse.success("查找成功！", student);
			
		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try{
			//调用service层代码删除学生信息
			studentService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功!", null);
		}catch(Exception e){
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	/*保存学生信息
	 * @author
	 * @param student
	 * @return String
	 * */
	@PostMapping("insertStudent")
	public MsgResponse insertStudent(Student student){
		try{
			studentService.insertStudent(student);
			return MsgResponse.success("插入成功！", student);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateStudent")
	public MsgResponse updateStudent(Student student){
		try{
			studentService.updateStudent(student);
			return MsgResponse.success("更新成功！", student);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
