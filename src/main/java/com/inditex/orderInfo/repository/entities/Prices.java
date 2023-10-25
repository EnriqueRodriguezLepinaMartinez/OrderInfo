package com.inditex.orderInfo.repository.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Prices {

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The brand Id
     */
    @EmbeddedId
    private PricesPK id;

    /**
     * The brand Id
     */
    @Column(name = "BRAND_ID")
    private Integer brandId;

    /**
     * The start date
     */
    @Column(name = "START_DATE")
    private Timestamp startDate;

    /**
     * The end date
     */
    @Column(name = "END_DATE")
    private Timestamp endDate;

    /**
     * The price list
     */
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    /**
     * The product Id
     */
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    /**
     * The priority
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * The price
     */
    @Column(name = "PRICE")
    private BigDecimal price;

    /**
     * The curr
     */
    @Column(name = "CURR")
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
    private Brands brands;

}
