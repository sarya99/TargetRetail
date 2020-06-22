package com.target.retailApp.Retail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
public class RetailController {

	@Autowired
    private ProductsRepository productRepository;

    //Get all products
    @GetMapping("/getAllProducts")
    public List< Product > getAllProduct() {
        return productRepository.findAll();
    }
    
    //GET request to fetch product based on ID
   @GetMapping("/products/{productId}")
   public Product findByID(@PathVariable(value = "productId") String  productId)
	   throws ResourceNotFoundException {
	 Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));
	        return product;
	}
	
   //Get product details using PUT and update product
   @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}")
   public String updateByID(@PathVariable String productId, @RequestBody Product in_product)  throws ResourceNotFoundException{
		JSONObject jsonString = new JSONObject();
		try {
			if (!in_product.getId().equals(productId)) { // If IDs don't match, kick back response
				jsonString.put("code", "409");
				jsonString.put("response", "ids did not match");
				return jsonString.toString();
			} else if (in_product.getPrice().getpriceValue() == null
					|| in_product.getPrice().getpriceValue().isEmpty()) { // If price is empty, kick back response

				jsonString.put("code", "406");
				jsonString.put("response", "price is null or empty");
				return jsonString.toString();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		 Product product = productRepository.findById(productId)
		            .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));
			product.setPrice(in_product.getPrice()); // Update price

		try {
			jsonString.put("code", "200");
			jsonString.put("response", "Price has been updated");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		productRepository.save(product);
		return jsonString.toString();
	}


}
