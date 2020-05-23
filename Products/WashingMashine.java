package Products;

/**
 * Trieda slúži na prácu s porduktom WashingMachine
 */
public class WashingMashine extends Product implements ProductInterface {
    int volume;
    boolean dryer;
    int maxRotation;

    /**
     * Konštruktor
     *
     * @param id          id produktu
     * @param price       cena produktu
     * @param weight      váha produktu
     * @param color       farba produktu
     * @param producent   výrobca
     * @param volume      objem práčky
     * @param dryer       informácia či práčka obsahuje aj sušičku
     * @param maxRotation maximálne otáčky práčky
     */
    public WashingMashine(int id, double price, double weight, String color, String producent, int volume, boolean dryer, int maxRotation) {
        super(id, price, weight, color, producent);
        this.volume = volume;
        this.dryer = dryer;
        this.maxRotation = maxRotation;
    }

    /**
     * @return reťazec určený pre výpis do konzoly
     */
    @Override
    public String toString() {
        return super.toString() + "WashingMashine " + "\n\t" +
                "volume=" + volume + "\n\t" +
                "dryer=" + dryer + "\n\t" +
                "maxRotation=" + maxRotation + "\n\t"
                ;
    }

    /**
     * @return reťazec určený pre zápis do súboru
     */
    public String toWrite() {
        return super.toWrite() + "WashingMashine" +
                " " + volume +
                " " + dryer +
                " " + maxRotation;

    }

}
