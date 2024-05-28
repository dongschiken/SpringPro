package com.ssgssak.backend.shipping.repository;

import java.util.ArrayList;

import com.ssgssak.backend.shipping.domain.Criteria;
import com.ssgssak.backend.shipping.domain.ShippingPlaceInfoDTO;

public interface ShipPlaceInfoMapper {
	
	int shipPalceInfoInsert(ShippingPlaceInfoDTO dto);
	ArrayList<ShippingPlaceInfoDTO> shipPlaceInfoPageList(Criteria criteria, String memid);
	
}
