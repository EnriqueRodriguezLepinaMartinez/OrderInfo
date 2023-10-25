package com.inditex.orderInfo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoResponse {

    /**
     * The product identification
     */
    @Schema(example = "", description = "")
    public Integer productId;
    /**
     * The brand identification
     */
    @Schema(example = "", description = "")
    public Integer brandId;
    /**
     * The brand name
     */
    @Schema(example = "", description = "")
    public String brandName;
    /**
     * The rate to apply
     */
    @Schema(example = "", description = "")
    public Integer rate;
    /**
     * The application date
     */
    @Schema(example = "", description = "")
    public Timestamp appDate;
    /**
     * The final price to apply
     */
    @Schema(example = "", description = "")
    public BigDecimal finalPrice;
}
