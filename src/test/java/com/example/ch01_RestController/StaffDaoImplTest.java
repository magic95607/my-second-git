package com.example.ch01_RestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ch01_RestController.dao.IStaffDao;

@SpringBootTest
public class StaffDaoImplTest {
	@Autowired
	private IStaffDao staffDao;

//	@Test
//	public void findById() {
//		assertNotNull(staffDao);
//		System.out.println("start findById");
//		Staff result = staffDao.findById(3);
//		assertEquals("John", result.getName());
//	}
	
	@Test
	public void Insert() {
	}
	
}
