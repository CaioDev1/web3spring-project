package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SistemaController {
	private ArrayList<Products> produtos = new ArrayList<Products>();
	
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
		model.addAttribute("produtos", this.produtos);
		
		return "produtos";
	}
	
	@GetMapping("/produtos/cadastrar")
	public String adicionar(Model model) {
		model.addAttribute("page", "cadastrar");
		return "cadastrar";
	}
	
	@PostMapping("/produtos/cadastrar")
	public String cadastrarProdutos(Model model, Products product) {
		model.addAttribute("page", "produtos");
		
		this.produtos.add(product);
	
		for(Products item : this.produtos) {
			item.printOnConsole();
		}
		
		model.addAttribute("produtos", this.produtos);
	
		return "produtos";
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
