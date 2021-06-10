package com.santander.apisantander.model.DTO;


import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 8, fraction = 2)
    private Double price;

    @NotNull

    private LocalDate date;

    @NotNull
    private Double variation;

}
