package com.market.controller;


import com.market.model.Product;
import com.market.service.MarketService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller("/market")
public class MarketController {

    private final MarketService marketService;
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @Get(
            produces = MediaType.APPLICATION_JSON
    )
    public List<Product> GetProductByAccount()
    {
        return marketService.GetProductByAccount(MarketService.ACCOUNT_ID);
    }

    @Post(
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON
    )
    public List<Product> AddProductInAccount(@Body List<Product> products)
    {
        return  marketService.AddProductInAccount(MarketService.ACCOUNT_ID, products);
    }

    @Put(
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON
    )
    public  List<Product> UpdateProductInAccount(@Body List<Product> products)
    {
        return  marketService.UpdateProductInAccount(MarketService.ACCOUNT_ID,products);
    }
    @Delete
    public HttpResponse<Void> DeleteProductList()
    {
        marketService.DeleteProduct();
        return HttpResponse.noContent();
    }
}
