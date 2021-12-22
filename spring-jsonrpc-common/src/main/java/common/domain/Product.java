package common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Product {
    String  id;
    String name;
    BigDecimal price;
}
