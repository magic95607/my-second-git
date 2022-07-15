package com.example.ch01_RestController.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.ch01_RestController.Staff;
import com.example.ch01_RestController.dao.StaffDao;

@Service
public class StaffService implements IService {
	@Autowired
	private StaffDao dao;

	public Staff findById(Integer id) {
		return dao.findById(id);
	}
}