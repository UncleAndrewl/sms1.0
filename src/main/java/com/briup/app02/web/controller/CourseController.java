package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	//http://:127.0.0.1:8080/course/findAll
		@GetMapping("findAllCourse")
		public MsgResponse findAllCourse(){
			try{
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查找成功！", list);
			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Course course = courseService.findById(id);
				return MsgResponse.success("查找成功！", course);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@GetMapping("deleteById")
		public MsgResponse deleteById(long id){
			try {
				courseService.deleteById(id);
				return MsgResponse.success("删除成功!", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@GetMapping("updateCourse")
		public MsgResponse updateCourse(Course course){
			try {
				courseService.updateCourse(course);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@GetMapping("insertCourse")
		public MsgResponse insertCourse(Course course){
			try {
				courseService.insertCourse(course);
				return MsgResponse.success("插入成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
}


