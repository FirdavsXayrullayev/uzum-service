package uz.uzumservice.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uz.uzumservice.dto.ProductDto;
import uz.uzumservice.model.Product;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements CommonMapper<ProductDto, Product>{
    @Autowired
    protected CategoryMapper categoryMapper;
    @Mapping(target = "category", expression = "java(categoryMapper.toDto(product.getCategory()))")
    public abstract ProductDto toDto(Product product);

}
