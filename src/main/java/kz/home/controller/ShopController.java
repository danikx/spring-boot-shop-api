package kz.home.controller;

import kz.home.domain.Shop;
import kz.home.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Shop controller
 * Created by daniyar.kalmurzin@gmail.com on 5/5/17.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Shop> getShops() {
        return shopService.getAllShops();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public @ResponseBody
    Shop getShopByNamePath(@PathVariable("name") String name, @RequestParam(value = "address", required = false) String address, @RequestParam(value = "phone", required = false) String phone) {
        return shopService.createShop(name, address, phone);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveShop(@RequestBody Shop shop) {
        logger.info("shop:" + shop.getName());
        if (shop.getName() == null) {
            throw new IllegalArgumentException("shop name can't be null");
        }
        logger.info("saving shop: {}, address: {}, phone: {}", shop.getName(), shop.getAddress(), shop.getPhone());
    }


    @SuppressWarnings("unused")
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /*@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }*/

}
