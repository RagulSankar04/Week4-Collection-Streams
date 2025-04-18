import java.util.*;

// --- Category Marker Interfaces ---
interface ProductCategory {
    String getCategoryName();
}

class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadget";
    }
}

// --- Generic Product Class ---
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price -= (price * (percentage / 100));
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void display() {
        System.out.println("Product: " + name +
                ", Category: " + category.getCategoryName() +
                ", Price: $" + price);
    }
}

// --- Utility class with generic method ---
class DiscountUtils {
    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Applied " + percentage + "% discount on " + product.getName());
    }
}

// --- Main Class to Demo the Catalog ---
public class OnlineMarketPlace {
    public static void main(String[] args) {
        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("The Alchemist", 499.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1299.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 25999.0, new GadgetCategory());

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("---- Product Catalog ----");
        for (Product<? extends ProductCategory> item : catalog) {
            item.display();
        }

        System.out.println("\n---- Applying Discounts ----");
        DiscountUtils.applyDiscount(book, 10); // 10% off on book
        DiscountUtils.applyDiscount(shirt, 20); // 20% off on clothing
        DiscountUtils.applyDiscount(phone, 5); // 5% off on gadget

        System.out.println("\n---- Updated Catalog ----");
        for (Product<? extends ProductCategory> item : catalog) {
            item.display();
        }
    }
}
