package com.example.ch01_RestController;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComponyController {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostMapping("/company")
	public ResponseEntity<String> create(@RequestBody Company company){
	    String sql = "insert into company(id,name) values (:id,:name)";
	    Map<String, Object> map=new HashMap<>();
	    map.put("id", company.getId());
	    map.put("name", company.getName());
	    namedParameterJdbcTemplate.update(sql,map);
	    return ResponseEntity.status(HttpStatus.OK).body("action create!");
	}
	
	@DeleteMapping("/company/{id}")
	public String delete(@PathVariable Integer id){
	    String sql = "delete from company where id = :id";
	    Map<String, Object> map=new HashMap<>();
	    map.put("id", id);
	    namedParameterJdbcTemplate.update(sql,map);
	    return "action delete!";
	}
}
