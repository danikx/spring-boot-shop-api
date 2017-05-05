package kz.home.domain;

/**
 * Shop
 * Created by daniyar.kalmurzin@gmail.com on 5/5/17.
 */
public class Shop {
    private String name;
    private String address;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Shop create(String name, String address, String phone) {
        Shop shop = new Shop();
        shop.name = name;
        shop.address = address;
        shop.phone = phone;
        return shop;
    }
}
