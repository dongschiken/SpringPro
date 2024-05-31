package com.ssgssak.backend.shipping.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssgssak.backend.shipping.domain.Criteria;
import com.ssgssak.backend.shipping.domain.ShippingPlaceInfoDTO;
import com.ssgssak.backend.shipping.repository.ShipPlaceInfoMapper;

@Component
@Service
public class ShipPlaceInfoService {
	
	@Autowired
	private ShipPlaceInfoMapper shipPlaceInfoMapper;
	
	public int shipPlaceInfoInsert(ShippingPlaceInfoDTO dto) {
		int rowCount = 0;
		rowCount = shipPlaceInfoMapper.ShipPalceInfoInsert(dto);
		
		if( rowCount == 0 ) {
			System.out.println("shipPlaceInfoInsert처리가 이루어지지 않았습니다.");
			//throw 여기서 예외처리
		}
		return rowCount;
	}
	
	public ArrayList<ShippingPlaceInfoDTO> shipPlacePageList(Criteria criteria, String memid) {
		
		
		return null;
	}
	

}
