package com.briup.app02.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;
@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Course> list = courseMapper.findAll();
		return list;
	}

	@Override
	public Course findById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course!=null)
		{
			return course;
		}else{
			throw new Exception("该课程不存在！");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course!=null)
		{
			courseMapper.deleteById(id);
		}else{
			throw new Exception("该课程不存在！");
		}
	}

	@Override
	public void updateCourse(Course course) throws Exception {
		Course cou = courseMapper.findById(course.getId());
		if(cou!=null)
		{
			courseMapper.updateCourse(course);
		}else{
			throw new Exception("该课程不存在！");
		}	
	}

	@Override
	public void insertCourse(Course course) throws Exception {
		Course cou = courseMapper.findById(course.getId());
		if(cou!=null)
		{
			throw new Exception("该课程已存在！");
		}else{
			courseMapper.insertCourse(course);
		}
	}
}
