package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		modelMap.addAttribute("product", new Product());
		modelMap.addAttribute("productType", productService.findAllProductTypes());
		return view;
	}
	
	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap ) {
		String view = "welcome";
		if(result.hasErrors()) {
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("productType", productService.findAllProductTypes());
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
			productService.save(product);
			modelMap.addAttribute("message", "Product saved succesfully!");
		}
		return view;
	}
}
	

