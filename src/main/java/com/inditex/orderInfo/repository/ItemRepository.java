package com.inditex.orderInfo.repository;

import com.inditex.orderInfo.model.OrderInfoResponse;
import com.inditex.orderInfo.repository.entities.Prices;
import com.inditex.orderInfo.repository.entities.PricesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Prices, PricesPK>, ItemRepositoryCustom {

    /**
     * The find prices in ddbb.
     *
     * @param appDate   the application date
     * @param productId the product identification
     * @param brandId   the brand identification
     * @return the order info response list
     */
    List<OrderInfoResponse> findPrices(Timestamp appDate, Integer productId, Integer brandId);
}
