package com.learning.studentRecruitment;

import com.learning.studentRecruitment.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@SpringBootTest
class StudentRecruitmentApplicationTests {

	@Value("${studentApi.service.url}")
	private String url;
	@Test
	void testGetStudentById() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(url+"3", Student.class);
		assertNotNull(student);
		assertEquals("Marco Reynolds Sr.",student.getName());
		assertEquals(423,student.getTestScore());
	}
	@Test
	void testCreateStudent(){
		RestTemplate restTemplate = new RestTemplate();
		Student student = new Student();
		student.setName("tommyliew");
		student.setTestScore(100);
		Student newStudent = restTemplate.postForObject(url+"create",student,Student.class);
		assertNotNull(newStudent);
		assertEquals(newStudent.getName(),"tommyliew");
		assertEquals(newStudent.getTestScore(),100);
	}
	@Test
	void testUpdateStudent(){
		RestTemplate restTemplate = new RestTemplate();
		Student newStudent = restTemplate.getForObject(url+"7",Student.class);
		newStudent.setName("darren ter");
		newStudent.setTestScore(10);
		Student student = restTemplate.postForObject(url+"7",newStudent,Student.class);
		assertNotNull(newStudent);
		assertNotNull(student.getId());
		assertEquals(student.getName(),"darren ter");
		assertEquals(student.getTestScore(),10);
	}

}
