package market_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import market_project.repositories.ProductsDAO;


@Controller
public class SistemaController {
	@Autowired
	private ProductsDAO products;
	
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
		model.addAttribute("produtos", this.products.findAll());
		
		for(Products item : this.products.findAll()) {
			item.printOnConsole();
		}
		
		return "produtos";
	}
	
	@GetMapping("/form")
	public String produtosForm(Model model, 
			@RequestParam String category, 
			@RequestParam(name = "id", required = false) Integer contentId,
			@RequestParam(required = false) String method) {
		model.addAttribute("category", category);
		model.addAttribute("method", method);
	
		switch(category) {
			case "produtos":
				if(method.equals("update") && contentId != null) {
					Products product = this.products.getOne(contentId);
					
					model.addAttribute("product", product);
				} else {
					Products teste = new Products();
					model.addAttribute("product", teste);
				}
				
				return "produtos-form";
			default:
				return "pedidos-form";
		}
	}
	
	@PostMapping("/create/{category}")
	public String create(@PathVariable("category") String category, Products product) {
		switch(category) {
			case "produtos":
				this.products.save(product);
				break;
			default:
				// ...
		}
	
		return "redirect:/" + category;
	}
	
	
	@PostMapping("/update/{category}")
	public String update(@PathVariable("category") String category, Products product) {		
		switch(category) {
			case "produtos":
				this.products.save(product);
				break;
			default:
				// ...
		}
		
		return "redirect:/" + category;
	}
	
	@GetMapping("/delete/{category}")
	public String delete(@PathVariable("category") String category, 
			@RequestParam(name = "id") Integer contentId) {
		switch(category) {
			case "produtos":
				this.products.deleteById(contentId);
				break;
			default:
				// ...
		}
		
		return "redirect:/" + category;
	}
	
}
