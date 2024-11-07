package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class ProductShopWithMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String,Double>> shops = new TreeMap<>();

        while (!input.equals("Revision")){
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> productAndPrice = shops.get(shop);
            productAndPrice.put(product, price);

            shops.put(shop, productAndPrice);

            input = scanner.nextLine();
        }

        for (String shop : shops.keySet()){
            System.out.println(shop + "->");
            Map<String, Double> productAndPrice = shops.get(shop);

            for (String product : productAndPrice.keySet()){
                System.out.printf("Product: %s, Price: %.1f%n", product, productAndPrice.get(product));
            }
        }
    }
}
