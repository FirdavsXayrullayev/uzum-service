package uz.uzumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.uzumservice.dto.CategoryDto;
import uz.uzumservice.dto.ResponseDto;
import uz.uzumservice.model.Category;
import uz.uzumservice.repository.CategoryRepository;
import uz.uzumservice.service.mapper.CategoryMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static uz.uzumservice.service.validator.AppStatusCodes.*;
import static uz.uzumservice.service.validator.AppStatusMessages.*;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public ResponseDto<CategoryDto> addCategory(CategoryDto categoryDto) {
        try {
            if (categoryDto.getParentId() == null)
                return ResponseDto.<CategoryDto>builder()
                        .data(categoryMapper.toDto(
                                categoryRepository.save(
                                        categoryMapper.toEntity(categoryDto)
                                )
                        ))
                        .message(OK)
                        .code(OK_CODE)
                        .success(true)
                        .build();
            Optional<Category> category = categoryRepository.findById(categoryDto.getParentId());
            if (category.isEmpty())
                return ResponseDto.<CategoryDto>builder()
                        .data(categoryDto)
                        .message(VALIDATION_ERROR)
                        .code(VALIDATION_ERROR_CODE)
                        .success(false)
                        .build();
            return ResponseDto.<CategoryDto>builder()
                    .data(categoryMapper.toDto(
                            categoryRepository.save(
                                    categoryMapper.toEntity(categoryDto)
                            )
                    ))
                    .message(OK)
                    .code(OK_CODE)
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<CategoryDto>builder()
                    .code(DATABASE_ERROR_CODE)
                    .message(DATABASE_ERROR + ": " + e.getMessage())
                    .data(categoryDto)
                    .build();
        }
    }
    public ResponseDto<List<CategoryDto>> findById(Integer id){
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        list.forEach(l->{
            if (l.getParentId() != null && l.getParentId().equals(id))
                categoryDtoList.add(categoryMapper.toDto(l));
        });
        return ResponseDto.<List<CategoryDto>>builder()
                .code(OK_CODE)
                .message(OK)
                .success(true)
                .data(categoryDtoList)
                .build();
    }
}