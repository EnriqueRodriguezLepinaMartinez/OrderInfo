package com.inditex.orderInfo.repository.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BRANDS")
public class Brands {

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The brand Id
     */
    @EmbeddedId
    private BrandsPK id;

    /**
     * The name
     */
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "brands")
    private Set<Prices> prices;

}
