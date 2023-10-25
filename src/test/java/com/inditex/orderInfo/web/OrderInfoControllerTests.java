package com.inditex.orderInfo.web;

import com.inditex.orderInfo.model.OrderInfoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
class OrderInfoControllerTests {

	@Autowired
	OrderInfoController orderInfoController;


	@Test
	void should_retrieve_one_response() {
		List<OrderInfoResponse> orderInfoResponseList = orderInfoController.getOrderInfo(Timestamp.valueOf("2020-06-14 10:00:00"), 35455, 1);
		OrderInfoResponse orderInfoResponse = orderInfoResponseList.stream().findFirst().get();

		Date date = orderInfoResponse.getAppDate();

		assertEquals(10, date.getHours());
		assertEquals(14, date.getDate());
		assertEquals(35455, orderInfoResponse.getProductId());
		assertEquals(1, orderInfoResponse.getBrandId());
		assertEquals("ZARA", orderInfoResponse.getBrandName());
	}

	@Test
	void should_retrieve_one_response_2() {
		List<OrderInfoResponse> orderInfoResponseList = orderInfoController.getOrderInfo(Timestamp.valueOf("2020-06-14 16:00:00"), 35455, 1);
		OrderInfoResponse orderInfoResponse = orderInfoResponseList.stream().findFirst().get();

		Date date = orderInfoResponse.getAppDate();

		assertEquals(16, date.getHours());
		assertEquals(14, date.getDate());
		assertEquals(35455, orderInfoResponse.getProductId());
		assertEquals(1, orderInfoResponse.getBrandId());
		assertEquals("ZARA", orderInfoResponse.getBrandName());
	}

	@Test
	void should_retrieve_one_response_3() {
		List<OrderInfoResponse> orderInfoResponseList = orderInfoController.getOrderInfo(Timestamp.valueOf("2020-06-14 21:00:00"), 35455, 1);
		OrderInfoResponse orderInfoResponse = orderInfoResponseList.stream().findFirst().get();

		Date date = orderInfoResponse.getAppDate();

		assertEquals(21, date.getHours());
		assertEquals(14, date.getDate());
		assertEquals(35455, orderInfoResponse.getProductId());
		assertEquals(1, orderInfoResponse.getBrandId());
		assertEquals("ZARA", orderInfoResponse.getBrandName());
	}

	@Test
	void should_retrieve_one_response_4() {
		List<OrderInfoResponse> orderInfoResponseList = orderInfoController.getOrderInfo(Timestamp.valueOf("2020-06-15 10:00:00"), 35455, 1);
		OrderInfoResponse orderInfoResponse = orderInfoResponseList.stream().findFirst().get();

		Date date = orderInfoResponse.getAppDate();

		assertEquals(10, date.getHours());
		assertEquals(15, date.getDate());
		assertEquals(35455, orderInfoResponse.getProductId());
		assertEquals(1, orderInfoResponse.getBrandId());
		assertEquals("ZARA", orderInfoResponse.getBrandName());
	}

	@Test
	void should_retrieve_one_response_5() {
		List<OrderInfoResponse> orderInfoResponseList = orderInfoController.getOrderInfo(Timestamp.valueOf("2020-06-16 21:00:00"), 35455, 1);
		OrderInfoResponse orderInfoResponse = orderInfoResponseList.stream().findFirst().get();

		Date date = orderInfoResponse.getAppDate();

		assertEquals(21, date.getHours());
		assertEquals(16, date.getDate());
		assertEquals(35455, orderInfoResponse.getProductId());
		assertEquals(1, orderInfoResponse.getBrandId());
		assertEquals("ZARA", orderInfoResponse.getBrandName());
	}

}
