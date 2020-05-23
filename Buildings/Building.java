package Buildings;
import Products.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Trieda určená na ukladanie informácií o prevádzkach
 */
public class Building {
    private List<Product> list;

    /**
     * Konštuktor
     */
    public Building() {
        this.list = new ArrayList<>();
    }

    public void add(Product prod) {
        list.add(prod);
    }

    /**
     * Funkcia slúži na odstránenie produktu z listu produktov podla parametrov
     * @param id id produktu ktorý má byť odstránený
     * @return odstránený produkt
     */
    public Product remove(int id) {
        Product product = getProd(id);
        list.remove(product);
        return product;
    }

    /**
     * funkcia slúži na vyhľadanie produktu podľa zadaného id
     * @param id id hľadaného produktu
     * @return nájdená inštancia typu Produkt
     */
    public Product getProd(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * funkcia vyhľadá všetky produkty ktoré majú cenu medzi zadanými parametrami
     * @param min dolná hranica vyhladávania
     * @param max horná hranica vuyhôadávania
     * @return list nájdených produktov
     */
    public List<Product> filerByPrice(double min, double max) {
        List<Product> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > min && list.get(i).getPrice() < max) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    /**
     * funkcia vyhľadá všetky produkty podľa názvu výrobcu
     * @param producent meno hladaného výrobcu
     * @return najdená inštancia typu produkt
     */
    public List<Product> filerByProducent(String producent) {
        List<Product> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProducent().equals(producent)) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    /**
     * @return list produktov
     */
    public List<Product> getList() {
        return list;
    }

    /**
     * @param list list typu Product ktorý má byt nastavený
     */
    public void setList(List<Product> list) {
        this.list = list;
    }
}


