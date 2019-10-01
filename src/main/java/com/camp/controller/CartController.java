package com.camp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.camp.service.CartService;
import com.camp.vo.Cart;

@Controller
@RequestMapping(path = "/cart/")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(path = "/insertCart", method = RequestMethod.POST)
	public String insertcart(@ModelAttribute Cart cart) {

		
		int count = cartService.countCart(cart.getProductNo(), cart.getMemberId());
		if(count ==0) {
			cartService.insertCart(cart);
		} else {
			cartService.updateCart(cart);
		}
		
		return "redirect:/cart/ordercart?memberId="+cart.getMemberId();
	}
	
	@RequestMapping(path = "/ordercart", method = RequestMethod.GET)
	public ModelAndView orderList(String memberId, ModelAndView mav) {
		
		Map<String, Object> map = new HashMap<String, Object>();		
		List<Cart> carts = cartService.findCartListBymemberId(memberId);
		int sumMoney = cartService.sumMoney(memberId);
		int fee = sumMoney >= 100000 ? 0: 2500; 
		map.put("carts", carts);
		map.put("count", carts.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney+fee);
		mav.setViewName("cart/cartList");
		mav.addObject("map", map);
		
		return mav; // "/WEB-INF/views/" + upload/write + ".jsp"
	}
	
	@RequestMapping(path = "/updateCart", method = RequestMethod.GET)
	public String update(@RequestParam int amount, int cartNo, String memberId) {

		Cart cart = new Cart();
		cart.setCartNo(cartNo);
		cart.setAmount(amount);
		
		cartService.modifyCart(cart);


		return "redirect:/cart/ordercart?memberId="+memberId;
	}
	
}
