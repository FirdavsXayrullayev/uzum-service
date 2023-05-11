package uz.uzumservice.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.uzumservice.dto.CategoryDto;
import uz.uzumservice.dto.ResponseDto;
import uz.uzumservice.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryResources {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseDto<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
    @GetMapping("/{id}")
    public ResponseDto<List<CategoryDto>> getById(@PathVariable Integer id){
        return categoryService.findById(id);
    }
}
