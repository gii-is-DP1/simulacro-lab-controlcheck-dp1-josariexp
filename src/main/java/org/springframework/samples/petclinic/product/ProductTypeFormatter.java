package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	
	private final ProductService productService;
	
	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.productService = productService;
	}

    @Override
    public String print(ProductType product, Locale locale) {
        // TODO Auto-generated method stub
        return product.getName();
    }

    @Override
    public ProductType parse(String name, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
    	if(productService.getProductType(name) != null) {
    		return productService.getProductType(name);
    	}
		throw new ParseException("type not found:", 0);
    }
    
}
