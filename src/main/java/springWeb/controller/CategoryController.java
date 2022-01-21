package springWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.OrderResponse;
import springWeb.service.CategoryService;
import springWeb.service.OrderService;

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
}
