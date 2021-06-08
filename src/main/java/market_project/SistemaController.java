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
	
	@GetMapping("/cadastrar")
	public String produtosForm(Model model, @RequestParam String page, @RequestParam(name = "id") Integer contentId) {
		/* class ResponsePageConfig {
			String category;
			String method;
			
			public ResponsePageConfig(String category, String method) {
				this.category = category;
				this.method = method;
			}
		}
		
		ResponsePageConfig config = new ResponsePageConfig(page, "cadastro");
		
		model.addAttribute("config", config); */
		
		model.addAttribute("category", page);
		model.addAttribute("method", "create");
		
		System.out.println(contentId);
		
		switch(page) {
			case "produtos":
				if(contentId != null) {
					Products product = this.products.getOne(contentId);
					
					model.addAttribute("product", product);
				} else {
					model.addAttribute("product", new Products());
				}
				
				return "produtos-form";
			default:
				return "pedidos-form";
		}
	}
	
	@PostMapping("/cadastrar/{category}")
	public String create(@PathVariable("category") String category, Products product) {
		product.printOnConsole();
		
		switch(category) {
			case "produtos":
				this.products.save(product);
				break;
			default:
				return "redirect:/" + category;
		}
	
		return "redirect:/" + category;
	}
	
	
	/* @GetMapping("/editar")
	public String updatePage(@PathVariable("category") String category, Products product) {
		product.printOnConsole();
		
		
	} */
	
}
