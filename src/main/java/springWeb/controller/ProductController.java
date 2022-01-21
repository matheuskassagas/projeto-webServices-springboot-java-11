package springWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.ProductResponse;
import springWeb.service.CategoryService;
import springWeb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<ProductResponse> productAll = productService.findAll();
        return ResponseEntity.ok().body(productAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
