package com.example.ch01_RestController.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.ch01_RestController.Staff;
import com.example.ch01_RestController.dao.IStaffDao;

@Service
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao dao;

	public Staff findById(Integer id) {
		return dao.findById(id);
	}
}