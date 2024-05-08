package com.market.service;

import com.market.model.Product;
import jakarta.inject.Singleton;

import java.util.*;

@Singleton
public class MarketService {

    public static final UUID ACCOUNT_ID = UUID.fromString("ca9b5e76-518e-457e-995d-7891364c16a9");
    private final Map<UUID,List<Product>> productStore = new HashMap<>();

    public  MarketService()
    {
       InitializeProductStore();
    }

    void InitializeProductStore()
    {
        List<Product> products = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            products.add( new Product(i));
        }
        productStore.put(ACCOUNT_ID,products);
    }
    public List<Product> GetProductByAccount(UUID accountID)
    {
        return productStore.getOrDefault(accountID,new ArrayList<>());
    }

    public List<Product> AddProductInAccount(UUID accountID, List<Product> products)
    {
        List<Product> alreadyPresentProducts = productStore.get(accountID);
        if( alreadyPresentProducts!=null)
        {
            alreadyPresentProducts.addAll(products);
            productStore.put(accountID,alreadyPresentProducts);
        }
        else
        {
            productStore.put(ACCOUNT_ID,products);
        }

        return GetProductByAccount(accountID);
    }

    public void DeleteProduct()
    {
        if(productStore.containsKey(ACCOUNT_ID))
            productStore.remove(ACCOUNT_ID);

    }

    public List<Product> UpdateProductInAccount(UUID accountID, List<Product> products)
    {
        productStore.put(accountID,products);
        return GetProductByAccount(accountID);
    }
}
