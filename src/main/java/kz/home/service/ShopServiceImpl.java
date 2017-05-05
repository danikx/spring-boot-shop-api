package kz.home.service;

import kz.home.domain.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Shop service
 * Created by daniyar.kalmurzin@gmail.com on 5/5/17.
 */
@Service
public class ShopServiceImpl implements ShopService {
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);


    public List<Shop> getAllShops() {
        List<Shop> result = new ArrayList<>();

        result.add(Shop.create("test", "address", "phone"));
        result.add(Shop.create("test2", "address2", "phone2"));

        logger.info("get all shops");
        return result;
    }
}
