package Products;

/**
 * Trieda slúži na prácu s porduktom mobile
 */
public class Mobile extends Product implements ProductInterface {
    double osVersion;
    String displayResolution;
    int ramMemory;
    int storageMemory;

    /**
     * Konštruktor
     *
     * @param id id produktu
     * @param price cena produktu
     * @param weight váha produktu
     * @param color farba produktu
     * @param producent výrobca
     * @param osVersion verzia operačného systému
     * @param displayResolution rozlíženie displeja
     * @param ramMemory velkosť pamäte RAM
     * @param storageMemory velkosť vnútorného úložiska
     */
    public Mobile(int id, double price, double weight, String color,String producent, double osVersion, String displayResolution, int ramMemory, int storageMemory) {
        super(id, price, weight, color,producent);
        this.osVersion = osVersion;
        this.displayResolution = displayResolution;
        this.ramMemory = ramMemory;
        this.storageMemory = storageMemory;
    }

    /**
     * @return reťazec určený pre výpis do konzoly
     */
    @Override
    public String toString() {
        return super.toString() + "Mobile " + "\n\t"+
                "osVersion=" + osVersion +"\n\t"+
                "displayResolution=" + displayResolution +"\n\t"+
                "ramMemory=" + ramMemory +"\n\t"+
                "storageMemory=" + storageMemory+"\n\t";
    }

    /**
     * @return reťazec určený pre zápis do súboru
     */
    public String toWrite(){
        return super.toWrite() + "Mobile" +
                " " + osVersion +
                " " + displayResolution +
                " " + ramMemory +
                " " + storageMemory;
    }

}
