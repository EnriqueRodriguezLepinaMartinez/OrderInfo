package com.inditex.orderInfo.service;


import com.inditex.orderInfo.model.OrderInfoResponse;

import java.sql.Timestamp;
import java.util.List;

public interface OrderInfoService {

    /**
     * The get Order Info service.
     *
     * @param appDate   the application date
     * @param productId the product identification
     * @param brandId   the brand identification
     * @return the order info response object
     */
    List<OrderInfoResponse> getOrderInfo(Timestamp appDate, Integer productId, Integer brandId);
}
