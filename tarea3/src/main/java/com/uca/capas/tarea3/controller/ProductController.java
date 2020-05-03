package com.uca.capas.tarea3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea3.domain.Product;

@Controller
public class ProductController {

	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"Harry Potter",20));
		productos.add(new Product(1,"The Witchesr",90));
		productos.add(new Product(2,"Los mitos de Cthulhu",50));
		productos.add(new Product(3,"El camino de los reyes",70));
		productos.add(new Product(4,"Nacidos de la bruma",10));
		productos.add(new Product(5,"La torre oscura",30));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("productos", productos);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(product.getCantidad()<=productos.get(product.getId()).getCantidad()) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		
		mav.addObject("nombre",productos.get(product.getId()).getNombre());
		return mav;
	}
}
