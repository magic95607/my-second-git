package com.example.ch01_RestController.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.*;

import com.example.ch01_RestController.Staff;

@Component
public class StaffDao implements IDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Staff findById(Integer id) {
		String sql = "select id,name,account " + " from staff where id = :id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		List<Staff> list = namedParameterJdbcTemplate.query(sql, map, new BeanPropertyRowMapper<>(Staff.class));
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}