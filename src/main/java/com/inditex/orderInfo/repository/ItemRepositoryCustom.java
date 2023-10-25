package com.inditex.orderInfo.repository;

import com.inditex.orderInfo.model.OrderInfoResponse;

import java.sql.Timestamp;
import java.util.List;

public interface ItemRepositoryCustom {

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
