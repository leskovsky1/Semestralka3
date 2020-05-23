package MakerFile;

import Products.Mobile;
import Products.Product;
import Products.WashingMashine;

/**
 * Trieda slúži na prácu s retazcami
 */
public abstract class StringParser {
    /**
     * @param line jeden riadok zo súboru
     * @return inštancia typu produkt
     */
    public static Product parseProduct(String line) {
        Product prod = null;
        String splited[] = line.split(" ");
        int id = Integer.parseInt(splited[0]);
        double price = Double.parseDouble(splited[1]);
        double weight = Double.parseDouble(splited[2]);
        String color = splited[3];
        String producent = splited[4];
        String product = splited[5];

        if (product.equals("Mobile")) {
            double osVersion = Double.parseDouble(splited[6]);
            String res = splited[7];
            int ram = Integer.parseInt(splited[8]);
            int memory = Integer.parseInt(splited[9]);

            prod = new Mobile(id, price, weight, color, producent, osVersion, res, ram, memory);
        }
        if (product.equals("WashingMashine")) {

            int volume = Integer.parseInt(splited[6]);
            boolean dryer = Boolean.parseBoolean(splited[7]);
            int rotation = Integer.parseInt(splited[8]);
            prod = new WashingMashine(id, price, weight, color, producent, volume, dryer, rotation);
        }
        return prod;
    }
}
