package models;

public class Product {
    private String name;
    private String price;
    private String quantity;
    private String color;

    public Product(String name, String price, String quantity, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
