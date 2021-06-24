/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;
/**
 *
 * @author brybarczyk
 */
public class JednostkaOrganizacyjna {
    private int id;
    private String nazwa;

    public JednostkaOrganizacyjna(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public JednostkaOrganizacyjna(String nazwa) {
        this.nazwa = nazwa;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa ;
    }


    @Override       // nadpisanie hashCode i equals umożliwia wyświetlenie w cbJednostkaOrganizacyjnaOE.setSelectedItem(pb1.getJo()); prawidłowego oddziału
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JednostkaOrganizacyjna other = (JednostkaOrganizacyjna) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}