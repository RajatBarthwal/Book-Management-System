package com.api.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestbookApplicationTests {
	
	Calculator calculator = new Calculator();

	@Test
	@Disabled
	void contextLoads() {
	}
	
	@Test
	void testSum(){
		int expectedSum=6;
		assertThat(calculator.doSum(1, 2, 3)).isEqualTo(expectedSum);
	}
	
	@Test
	void testCompare() {
		boolean actualValue = calculator.compare(1, 1);
		assertThat(actualValue).isTrue();
	}

}
