package com.example.ch01_RestController;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class CalculatorTest {
	@BeforeEach
	public void setUp() {
		System.out.println("start before each");
	}
	@Test
	void add() {
		Calculator calculator = new Calculator();
		int result = calculator.add(1, 2);
		assertEquals(3,result,"加法有問題");
		assertNotNull(result);
		assertTrue(result>0);
	}
}
