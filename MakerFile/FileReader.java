package MakerFile;

import Products.Mobile;
import Products.Product;
import Products.WashingMashine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Trieda slúži na spracovanie informácií pre zápis a čítanie zo súboru
 */
public class FileReader {

    /**
     * funkcia slúži na zápis do súboru
     *
     * @param shopList      list produktov z obchodu
     * @param stockpileList list produktov zo skladu
     */
    public void writeToFile(List<Product> shopList, List<Product> stockpileList) {
        try {
            FileWriter shopWriter = new FileWriter("dataShop.txt");
            FileWriter stockpileWriter = new FileWriter("dataStockpile.txt");
            for (int i = 0; i < shopList.size(); i++) {
                shopWriter.write(shopList.get(i).toWrite() + "\n");
            }
            for (int i = 0; i < stockpileList.size(); i++) {
                stockpileWriter.write(stockpileList.get(i).toWrite() + "\n");
            }
            shopWriter.close();
            stockpileWriter.close();
            System.out.println("Zapisane do suboru uspesne");

        } catch (IOException e) {
            System.out.println("Nastala nejaka chyba");
            e.printStackTrace();
        }
    }

    /**
     * Funkcia slúži na čítanie zo súboru pre obchod
     *
     * @return list produktov zo súboru
     */
    public List<Product> readFileShop() {
        List<Product> shopList = new ArrayList<Product>();
        File file = new File("dataShop.txt");
        try {
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                shopList.add(StringParser.parseProduct(line));
            }
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Subor nebol najdeny");
            return null;
        }
        return shopList;

    }

    /**
     * Funkcia slúži na čítanie zo súboru pre sklad
     *
     * @return list produktov zo súboru
     */
    public List<Product> readFileStockpile() {
        List<Product> stockList = new ArrayList<Product>();
        File file = new File("dataStockpile.txt");
        try {
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                stockList.add(StringParser.parseProduct(line));
            }
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Subor nebol najdeny");
            return null;
        }
        return stockList;
    }
}
