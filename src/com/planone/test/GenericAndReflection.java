package com.planone.test;

import org.junit.Test;

import com.planone.dao.StudentDao;
import com.planone.entity.Student;

public class GenericAndReflection {

	@Test
	public void testGenericAndReflection(){
		StudentDao dao = new StudentDao();
		Student stu = dao.getEntity("1");
	}
}
