package com.camp.service;

import java.util.List;

import com.camp.vo.Cart;

public interface CartService {

	int countCart(int productNo, String memberId);
	void insertCart(Cart cart);
	void updateCart(Cart cart);
	
	List<Cart> findCartListBymemberId(String memberId);
	int sumMoney(String memberId);
	void modifyCart(Cart cart);

	

}
