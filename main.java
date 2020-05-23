import Buildings.Buildings;
import MakerFile.FileReader;
import Products.Mobile;
import Products.WashingMashine;

import java.util.Scanner;

/**
 * Hlavná trieda
 */
public class main {
    /**
     * hlavná funkcia programu
     * @param args používa sa bez parametrov
     */
    public static void main(String[] args) {
        Buildings buildings = new Buildings();
        FileReader fr = new FileReader();
        buildings.getShop().setList(fr.readFileShop());
        buildings.getStockPile().setList(fr.readFileStockpile());
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1 ... vypis obchod");
            System.out.println("2 ... vypis sklad");
            System.out.println("3 ... predaj");
            System.out.println("4 ... vyrob");
            System.out.println("5 ... premiestni");
            System.out.println("6 ... hladaj");
            System.out.println("7 ... filtruj");
            System.out.println("0 ... koniec");

            int pom = scanner.nextInt();

            switch (pom) {
                case 0: {

                    fr.writeToFile(buildings.getShop().getList(), buildings.getStockPile().getList());
                    System.exit(1);
                    break;
                }
                case 1: {
                    buildings.printShopToConsole();
                    break;
                }
                case 2: {
                    buildings.printStockpileToConsole();
                    break;
                }
                case 3: {
                    buildings.sell();
                    break;
                }
                case 4: {
                    buildings.create();
                    break;
                }
                case 5: {
                    buildings.move();
                    break;
                }
                case 6: {
                    buildings.find();
                    break;
                }
                case 7: {
                    buildings.filter();
                    break;
                }
                case 8: {
                    WashingMashine was1 = new WashingMashine(1, 100.2, 150.9, "Biela", "Samsung", 150, true, 1500);
                    WashingMashine was2 = new WashingMashine(2, 110.5, 350.4, "Cierna", "Nokia", 200, true, 1500);
                    WashingMashine was3 = new WashingMashine(3, 250.5, 480.5, "Oranzova", "LG", 250, false, 1000);

                    Mobile mob1 = new Mobile(4, 258.3, 10.3, "Ruzova", "LG", 10.2, "158x193", 10, 150);
                    Mobile mob2 = new Mobile(5, 250.5, 10.7, "Fialova", "Xiaomi", 11.2, "158x193", 150, 250);

                    buildings.getShop().add(was1);
                    buildings.getShop().add(mob1);
                    buildings.getShop().add(was2);

                    buildings.getStockPile().add(was3);
                    buildings.getStockPile().add(mob2);
                    break;
                }
            }
        }
    }
}
