package com.inditex.orderInfo.service;

import com.inditex.orderInfo.model.OrderInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    /**
     * The get Order Info service.
     *
     * @param appDate   the application date
     * @param productId the product identification
     * @param brandId   the brand identification
     * @return the order info response object
     */
    @Override
    public List<OrderInfoResponse> getOrderInfo(Timestamp appDate, Integer productId, Integer brandId) {
        return null;
    }

}
