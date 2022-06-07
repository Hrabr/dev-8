package ua.goit.dev88.converter;

import ua.goit.dev88.model.dao.Producer;
import ua.goit.dev88.model.dto.ProducerDto;

import java.util.stream.Collectors;

public class ConvertProducer {
    public ProducerDto from(Producer producer) {
        ConverterProduct converterProduct = new ConverterProduct();
        return ProducerDto.builder()
                .id(producer.getId())
                .name(producer.getName())
                .productDto(producer.getProducts().stream().map(p -> converterProduct.from(p)).collect(Collectors.toList()))
                .build();
    }
}
