package ua.goit.dev88.model.dao;

import lombok.*;
import ua.goit.dev88.model.dao.Producer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue

    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_producer")
    private Producer producer;


}
