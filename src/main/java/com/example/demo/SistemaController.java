package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

class Products {
	private String title;
	private double price;
	private int stock;
	private String store;
	
	public Products(String title, double price, int stock, String store) {
		this.title = title;
		this.price = price;
		this.stock = stock;
		this.store = store;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
}

@Controller
public class SistemaController {
	ArrayList<Products> produtos = new ArrayList<Products>();
	
	@GetMapping("/")
	public String clientes(Model model) {
		model.addAttribute("page", "clientes");
		return "clientes";
	}
	
	@GetMapping("/lojas")
	public String lojas(Model model) {
		model.addAttribute("page", "lojas");
		return "lojas";
	}
	
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		model.addAttribute("page", "pedidos");
		return "pedidos";
	}
	
	@GetMapping("/produtos")
	public String produtos(Model model) {
		model.addAttribute("page", "produtos");
		return "produtos";
	}
	
	@GetMapping("/cadastrar")
	public String adicionar(Model model) {
		model.addAttribute("page", "cadastrar");
		return "cadastrar";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Model model, String title, double price, int stock, String store) {
		model.addAttribute("page", "cadastrar");
		
		this.produtos.add(new Products(title, price, stock, store));
		
		for(Products item : this.produtos) {
			System.out.println(item.getTitle());
			System.out.println(item.getPrice());
			System.out.println(item.getStock());
			System.out.println(item.getStore());
		}
	
		return "cadastrar";
	}

	public SistemaController(ArrayList<Products> produtos) {
		super();
		this.produtos = produtos;
	}
	
	/* @GetMapping("/atualizar")
	public String atualizar() {
		return "atualizar";
	}
	
	@GetMapping("/consultar")
	public String consultar() {
		return "consultar";
	}
	
	@GetMapping("/deletar")
	public String deletar() {
		return "deletar";
	}
	
	@GetMapping("/filtrar")
	public String filtrar() {
		return "filtrar";
	}
	
	@GetMapping("/quantidade")
	public String quantidade() {
		return "quantidade";
	} */
}
