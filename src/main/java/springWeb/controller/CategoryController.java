package springWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springWeb.DTO.request.CategoryRequest;
import springWeb.DTO.request.ProductRequest;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.OrderResponse;
import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Product;
import springWeb.service.CategoryService;
import springWeb.service.OrderService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<CategoryResponse> categoryAll = categoryService.findAll();
        return ResponseEntity.ok().body(categoryAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody CategoryRequest categoryRequest){
        Category categoryNew = categoryService.create(categoryRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryNew.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryNew);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody CategoryRequest categoryRequest){
        Category categoryNew = categoryService.update(id, categoryRequest);
        return ResponseEntity.ok().body(categoryNew);
    }
}
