package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	//http://:127.0.0.1:8080/course/findAll
		@GetMapping("findAllCourse")
		public List<Course> findAllCourse(){
			try{
			List<Course> list = courseService.findAll();
			return list;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}


