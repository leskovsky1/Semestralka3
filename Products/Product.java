package Products;

/**
 * Trieda slúži na prácu s porduktom
 */
public class Product implements ProductInterface{
    private int id;
    private double price;
    private double weight;
    private String color;
    private String producent;

    /**
     * Konštruktor
     *
     * @param id        id produktu
     * @param price     cena produktu
     * @param weight    váha produktu
     * @param color     farba produktu
     * @param producent výrobca
     */
    public Product(int id, double price, double weight, String color, String producent) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.producent = producent;
    }

    /**
     * @return meno výrobcu
     */
    public String getProducent() {
        return producent;
    }

    /**
     * @return id produktu
     */
    public int getId() {
        return id;
    }

    /**
     * @return cenu produktu
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return reťazec určený pre výpis do konzoly
     */
    @Override
    public String toString() {
        return
                "id=" + id + "\n\t" +
                        "price=" + price + "\n\t" +
                        "weight=" + weight + "\n\t" +
                        "color=" + color + "\n\t" +
                        "producent= " + producent + "\n\t";
    }
    /**
     * @return reťazec určený pre zápis do súboru
     */
    public String toWrite() {
        return
                id +
                        " " + price +
                        " " + weight +
                        " " + color +
                        " " + producent + " ";
    }
}
