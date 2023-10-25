package com.inditex.orderInfo.web;

import com.inditex.orderInfo.model.OrderInfoResponse;
import com.inditex.orderInfo.service.OrderInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("orderInfo")
@Tag(name = "Greetings", description = "Greetings controllers")
public class OrderInfoController {

    @Autowired
    OrderInfoService service;

    /**
     * The get Order Info controller.
     *
     * @param appDate   the application date
     * @param productId the product identification
     * @param brandId   the brand identification
     * @return the order info response object
     */
    @Operation(summary = "Method test", description = "Method test")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = List.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderInfoResponse> getOrderInfo(
            @Parameter(description = "application date", example = "2020-06-14 00:00:00") @RequestParam(
                    name = "appDate") @NotNull Timestamp appDate,
            @Parameter(description = "product identification", example = "35455") @RequestParam(
                    name = "productId") @NotNull Integer productId,
            @Parameter(description = "brand identification", example = "1") @RequestParam(
                    name = "brandId") @NotNull Integer brandId
    ) {
        return service.getOrderInfo(appDate, productId, brandId);
    }
}
