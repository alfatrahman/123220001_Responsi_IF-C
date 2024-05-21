/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author PC PRAKTIKUM
 */
public class modeltabeldatab extends AbstractTableModel {
    
    List<datab> dp;
    public modeltabeldatab(List<datab> dp){
        this.dp = dp;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Penyewa";
            case 1:
                return "Judul Buku";
            case 2:
                return "Jenis Buku";
            case 3:
                return "Nomor Telepon";
            case 4:
                return "Durasi Sewa";
            case 5:
                return "Total";
            default :
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
         switch(column){
            case 0:
                return dp.get(row).getNama_penyewa();
            case 1:
                return dp.get(row).getJudul_buku();
            case 2:
                return dp.get(row).getJenis_buku();
            case 3:
                return dp.get(row).getNomor_telepon();
            case 4:
                return dp.get(row).getDurasi_sewa();
            case 5:
                return dp.get(row).getTotal_biaya();
            default :
                return null;
        }
    }
}
