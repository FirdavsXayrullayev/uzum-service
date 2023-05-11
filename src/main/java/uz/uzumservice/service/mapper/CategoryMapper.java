package uz.uzumservice.service.mapper;

import org.mapstruct.Mapper;
import uz.uzumservice.dto.CategoryDto;
import uz.uzumservice.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonMapper<CategoryDto, Category> {

}
