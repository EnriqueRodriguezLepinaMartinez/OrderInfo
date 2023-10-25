package com.inditex.orderInfo.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class BrandsPK {

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The brand Id
     */
    @Column(name = "BRAND_ID", insertable = false, updatable = false)
    private Long brandId;

}
