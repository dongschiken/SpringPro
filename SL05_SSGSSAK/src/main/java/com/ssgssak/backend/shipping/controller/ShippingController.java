package com.ssgssak.backend.shipping.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssgssak.backend.shipping.domain.Criteria;
import com.ssgssak.backend.shipping.domain.ShippingPlaceInfoDTO;
import com.ssgssak.backend.shipping.service.ShipPlaceInfoService;

import lombok.AllArgsConstructor;

@RequestMapping("/shippingPlace")
@Component
@Controller
@AllArgsConstructor
public class ShippingController {
	
	@Autowired
	private ShipPlaceInfoService infoService = null;
	
	@GetMapping("/shipPlace/insert")
	public String shipPlaceInfoInsert(@RequestBody ShippingPlaceInfoDTO dto) {
		infoService.shipPlaceInfoInsert(dto);
		
		return "/shippingPlace/list";
	}
	
	@GetMapping("list")
	public String shippingPlaceInfoList(int currentPage, String memid) {
		Criteria criteria = new Criteria();
		criteria.setPageNum(currentPage);
		criteria.setAmount(10);
		// 여기서 페이징 처리 + 배송지 리스트 뿌리기
		
		
		return "list";
	}

 }
