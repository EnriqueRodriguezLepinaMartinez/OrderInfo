package com.inditex.orderInfo.service;

import com.inditex.orderInfo.model.OrderInfoResponse;
import com.inditex.orderInfo.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    ItemRepository repository;

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
        List<OrderInfoResponse> orderInfoResponse = new ArrayList<>();

        try {
            orderInfoResponse = repository.findPrices(appDate, productId, brandId);

            orderInfoResponse.stream().forEach(r -> {
                r.setAppDate(appDate);
            });
        } catch (InvalidJpaQueryMethodException e) {
            log.error(e.getMessage());
        }

        return orderInfoResponse;
    }

}
