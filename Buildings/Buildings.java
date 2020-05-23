package Buildings;

import Products.Mobile;
import Products.Product;
import Products.WashingMashine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Trieda slúži na spravovanie prevádzok
 */
public class Buildings {
    private Shop shop;
    private Stockpile stockPile;

    /**
     * Konštruktor
     */
    public Buildings() {
        shop = new Shop();
        stockPile = new Stockpile();
    }

    /**
     * @return inštanciu typu Shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @return inštanciu typu Stockpile
     */
    public Stockpile getStockPile() {
        return stockPile;
    }

    /**
     * @return id pre nový produkt
     */
    private int getNewID() {
        int res = 0;
        for (int i = 0; i < stockPile.getList().size(); i++) {
            if (stockPile.getList().get(i).getId() > res) {
                res = stockPile.getList().get(i).getId();
            }
        }
        res++;
        return res;
    }


    /**
     * Funkcia slúži na presun produktov medzi prevádzkami
     */
    public void move() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadaj odkadial kam chete prenasat produkty");
        System.out.println("\t 1 ... obchod -> sklad");
        System.out.println("\t 2 ... sklad -> obchod");
        System.out.println("\t 0 ... spat");

        int val = scanner.nextInt();
        if (val == 0) {
            System.out.println("Vraciam sa spat do menu");
            return;
        }
        System.out.print("Zadaj ID produktu : ");
        int id = scanner.nextInt();
        Product prod;
        if (val == 1) {
            prod = shop.remove(id);
            if (prod == null) {
                System.out.println("Predmet sa nenasiel .... prenos neuspesny");
            } else {
                stockPile.add(prod);

            }
        }
        if (val == 2) {
            prod = stockPile.remove(id);
            if (prod == null) {
                System.out.println("Predmet sa nenasiel .... prenos neuspesny");
            } else {
                shop.add(prod);
                System.out.println("Predmet sa nasiel .... prenos uspesny");
            }
        }
    }

    /**
     * Funkcia slúži na vytváranie nových produktov
     */
    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcete vyrobit");
        System.out.println("\t 1 ....... mobil");
        System.out.println("\t 2 ....... pracka");
        System.out.println("\t 0 ....... spat");
        int value = scanner.nextInt();

        if (value == 1) {
            int id = getNewID();
            System.out.print("Zadaj cenu: ");
            double price = scanner.nextDouble();
            System.out.print("Zadaj vahu: ");
            double weight = scanner.nextDouble();
            System.out.print("Zadaj farbu: ");
            String color = scanner.next();
            System.out.print("Zadaj vyrobcu: ");
            String producent = scanner.next();
            System.out.print("Zadaj verziu OS: ");
            double os = scanner.nextDouble();
            System.out.print("Zadaj rozlisenie displeja: ");
            String resolution = scanner.next();
            System.out.print("Zadaj mnozstvo ram: ");
            int ram = scanner.nextInt();
            System.out.print("Zadaj vnutornu velkost pamate: ");
            int memory = scanner.nextInt();
            stockPile.create(new Mobile(id, price, weight, color, producent, os, resolution, ram, memory));
            return;
        }

        if (value == 2) {
            int id = getNewID();
            System.out.print("Zadaj cenu: ");
            double price = scanner.nextDouble();
            System.out.print("Zadaj vahu: ");
            double weight = scanner.nextDouble();
            System.out.print("Zadaj farbu: ");
            String color = scanner.next();
            System.out.print("Zadaj vyrobcu: ");
            String producent = scanner.next();
            System.out.print("Zadaj objem: ");
            int volume = scanner.nextInt();
            System.out.print("Zadaj ci obsahuje aj susicku - true/false: ");
            boolean dryer = scanner.nextBoolean();
            System.out.print("Zadaj maximalne otacky: ");
            int rotation = scanner.nextInt();

            stockPile.create(new WashingMashine(id, price, weight, color, producent, volume, dryer, rotation));
            return;
        }

        if (value == 0) {
            return;
        }
    }

    /**
     * Funkcia slúži na predaj produktu v obchode
     */
    public void sell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj id predmetu ktory chces predat: ");
        int val = scanner.nextInt();
        shop.sell(val);
    }

    /**
     * Funkcia slúži na vyhladanie produktu podľa zadaného parametra
     */
    public void find() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj id hladaneho produktu");
        int id = scanner.nextInt();
        Product prod = shop.getProd(id);
        if (prod != null) {
            System.out.println("Predmet bol najdeny v obchode");
            System.out.println(prod.toString());
            return;
        }
        prod = stockPile.getProd(id);
        if (prod != null) {
            System.out.println("Predmet bol najdeny v sklade");
            System.out.println(prod.toString());
            return;
        }
        if (prod == null) {
            System.out.println("Predmet sa nenasiel");
        }
    }

    /**
     * Funkcia slúži na vyfiltrovanie produktov podľa zadaného parametra
     */
    public void filter() {
        Scanner scanner = new Scanner(System.in);
        List<Product> res = new ArrayList<Product>();
        System.out.println("Zadaj podla coho filtrovat");
        System.out.println("\t 1... vyrobca");
        System.out.println("\t 2... cena");
        System.out.println("\t 0... spat");
        int val = scanner.nextInt();

        if (val == 0) {
            System.out.println("Vraciam sa do menu");
            return;
        }

        if (val == 1) {
            System.out.print("Zadaj nazov hladaneho vyrobcu :");
            String producent = scanner.next();
            res = shop.filerByProducent(producent);
            System.out.println("Produkty najdene v obchode");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i).toString());
            }
            res = stockPile.filerByProducent(producent);
            System.out.println("Produkty najdene v sklade");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i).toString());
            }
        }

        if (val == 2) {
            System.out.print("Zadaj dolnu hranicu :");
            double min = scanner.nextDouble();
            System.out.print("Zadaj hornu hranicu :");
            double max = scanner.nextDouble();
            res = shop.filerByPrice(min, max);
            System.out.println("Produkty najdene v obchode");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i).toString());
            }
            res = stockPile.filerByPrice(min, max);
            System.out.println("Produkty najdene v sklade");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i).toString());
            }
        }
    }

    /**
     * Funkcia slúži na vypísanie produktov v obchode
     */
    public void printShopToConsole() {
        for (int i = 0; i < shop.getList().size(); i++) {
            System.out.println(shop.getList().get(i).toString());
        }
    }
    /**
     * Funkcia slúži na vypísanie produktov v sklade
     */
    public void printStockpileToConsole() {
        for (int i = 0; i < stockPile.getList().size(); i++) {
            System.out.println(stockPile.getList().get(i).toString());
        }
    }
}
