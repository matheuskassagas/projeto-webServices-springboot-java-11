package springWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springWeb.DTO.request.ProductRequest;
import springWeb.DTO.request.UserRequest;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.ProductResponse;
import springWeb.repositoryJPA.entity.Product;
import springWeb.repositoryJPA.entity.User;
import springWeb.service.CategoryService;
import springWeb.service.ProductService;

import java.net.URI;
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

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody ProductRequest productRequest){
        Product productNew = productService.create(productRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productNew.getId()).toUri();
        return ResponseEntity.created(uri).body(productNew);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody ProductRequest productRequest){
        Product productNew = productService.update(id, productRequest);
        return ResponseEntity.ok().body(productNew);
    }
}
