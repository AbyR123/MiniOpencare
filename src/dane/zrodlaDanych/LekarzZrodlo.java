package dane.zrodlaDanych;

import dane.Lekarz;
import java.util.ArrayList;

/**
 *
 * @author brybarczyk
 */
public class LekarzZrodlo {
    
        
    private BazaDanych bd;
    
    public LekarzZrodlo() {
                bd = new BazaDanych();
    }
    
    public ArrayList<Lekarz> pobierzListeLekarzy(){
        
        Lekarz l1 = new Lekarz();
        l1.setId(1);
        l1.setImie("Jan");
        l1.setNazwisko("Kowalski");
        
        Lekarz l2 = new Lekarz();
        l2.setId(1);
        l2.setImie("Adam");
        l2.setNazwisko("Nowak");
        
        Lekarz l3 = new Lekarz();
        l3.setId(1);
        l3.setImie("Krystyna");
        l3.setNazwisko("Goździkowa");
        
        
        ArrayList<Lekarz> listaLekarzy = new ArrayList();
        listaLekarzy.add(l1);
        listaLekarzy.add(l2);
        listaLekarzy.add(l3);
        
        return listaLekarzy;
    }
    

}
