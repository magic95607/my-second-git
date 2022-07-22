package com.example.ch01_RestController;

import java.util.*;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.ch01_RestController.service.IStaffService;

import org.slf4j.*;

@RestController
public class StaffController {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private IStaffService staffService;

	@PostMapping("/staff")
	public ResponseEntity<String> create(@RequestBody Staff staff) {
		String sql = "insert into staff(id,name,account) values (:id,:name,:account)";
		Map<String, Object> map = new HashMap<>();
		map.put("id", staff.getId());
		map.put("name", staff.getName());
		map.put("account", staff.getAccount());
		namedParameterJdbcTemplate.update(sql, map);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		int id = keyHolder.getKey().intValue();

		return ResponseEntity.status(HttpStatus.OK).body("action create!" + id);
	}

//	@GetMapping("/staff/{id}")
//	public Staff getStaff(@PathVariable("id") Integer id) {
//		String sql = "select id,name,account from staff where id=:id";
//		MapSqlParameterSource map = new MapSqlParameterSource();
//		map.addValue("id", id);
//
//		List<Staff> result = namedParameterJdbcTemplate.query(sql, map, new BeanPropertyRowMapper(Staff.class));
//		if (result.size() > 0) {
//			return result.get(0);
//		} else {
//			return null;
//		}	
//
//	}

	@GetMapping("/staff/{id}")
	public Staff readOne(@PathVariable Integer id) {
		return staffService.findById(id);
	}
}
