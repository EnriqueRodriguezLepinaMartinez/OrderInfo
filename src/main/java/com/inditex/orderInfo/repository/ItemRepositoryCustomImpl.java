package com.inditex.orderInfo.repository;

import com.inditex.orderInfo.model.OrderInfoResponse;
import com.inditex.orderInfo.repository.entities.Brands;
import com.inditex.orderInfo.repository.entities.Prices;
import com.inditex.orderInfo.utils.Constants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * The find prices in ddbb.
     *
     * @param appDate   the application date
     * @param productId the product identification
     * @param brandId   the brand identification
     * @return the order info response list
     */
    public List<OrderInfoResponse> findPrices(Timestamp appDate, Integer productId, Integer brandId){
        List<OrderInfoResponse> orderInfoResponse;
        List<Predicate> predicates = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderInfoResponse> queryCriteria = cb.createQuery(OrderInfoResponse.class);
        Root<Prices> root = queryCriteria.from(Prices.class);

        Join<Brands, Prices> join = root.join(Constants.BRANDS, JoinType.LEFT);
        join.on(cb.equal(join.get(Constants.ID).get(Constants.BRAND_ID), brandId));

        Predicate equalProductId = cb.equal(root.get(Constants.PRODUCT_ID), productId);
        Predicate startDate = cb.lessThanOrEqualTo(root.get(Constants.START_DATE), appDate);
        Predicate endDate = cb.greaterThanOrEqualTo(root.get(Constants.END_DATE), appDate);

        predicates.add(cb.and(equalProductId,startDate, endDate));

        try{
            queryCriteria.select(cb.construct(
                    OrderInfoResponse.class,
                    root.get(Constants.PRODUCT_ID).alias(Constants.PRODUCT_ID),
                    root.get(Constants.PRIORITY).alias(Constants.RATE),
                    root.get(Constants.PRICE).alias(Constants.FINAL_PRICE),
                    root.get(Constants.BRAND_ID).alias(Constants.BRAND_ID),
                    join.get(Constants.NAME).alias(Constants.BRAND_NAME)
            )).where(predicates.toArray(new Predicate[]{}));

            TypedQuery<OrderInfoResponse> query = entityManager.createQuery(queryCriteria);
            orderInfoResponse = query.getResultList();
        } catch (PersistenceException e) {
            throw e;
        }

        return orderInfoResponse.stream().collect(Collectors.maxBy(Comparator.comparing(OrderInfoResponse::getRate))).stream().toList();
    }
}
