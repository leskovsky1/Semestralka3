package Buildings;

/**
 * Trieda slúži na spravovanie produktov s obchode
 */
public class Shop extends Building {
    /**
     * Konštruktor
     */
    public Shop() {
        super();
    }

    /**
     * @param id id predmetu ktorý má byť predaný
     */
    public void sell(int id){
        boolean res =  super.getList().remove(super.getProd(id));
        if(res == true){
            System.out.println("Produkt bol predany");
        }else {
            System.out.println("Produkt nebol najdeny");
        }
    }
}
