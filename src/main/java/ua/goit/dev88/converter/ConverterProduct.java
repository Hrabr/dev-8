package ua.goit.dev88.converter;

import ua.goit.dev88.model.dao.Product;
import ua.goit.dev88.model.dto.ProductDto;

public class ConverterProduct {
public ProductDto from(Product product){
    return ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice()).build();
}
}
