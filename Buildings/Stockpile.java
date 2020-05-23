package Buildings;

import Products.Product;

public class Stockpile extends Building {
    public Stockpile() {
        super();
    }

    public void create (Product prod){
        this.getList().add(prod);
    }
}
