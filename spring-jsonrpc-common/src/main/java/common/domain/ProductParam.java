package common.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class ProductParam {
    List<String> ids;
    BigDecimal price;
}
