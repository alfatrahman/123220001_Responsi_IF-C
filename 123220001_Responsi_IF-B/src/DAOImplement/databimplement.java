/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author PC PRAKTIKUM
 */
public interface databimplement {
    public void insert(datab b);
    public void update(datab b);
    public void delete(String Nama);
    
    public List<datab> getAll();
}
