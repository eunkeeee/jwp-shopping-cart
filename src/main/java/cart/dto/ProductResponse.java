package cart.dto;

import cart.entity.product.Product;

public class ProductResponse {
    private final long id;
    private final String name;
    private final String imgUrl;
    private final int price;

    private ProductResponse(long id, String name, String imgUrl, int price) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getImgUrl(),
                product.getPrice()
        );
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getPrice() {
        return price;
    }
}
