/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdatab.databDAO;
import DAOImplement.databimplement;
import model.*;
import view.MainView;
import javax.swing.*;

/**
 *
 * @author PC PRAKTIKUM
 */
public class databcontroller {
    MainView frame;
    databimplement impldatab;
    List<datab>dp;
    
    public databcontroller(MainView frame){
        this.frame = frame;
        impldatab =  new databDAO();
        dp = impldatab.getAll();
    }
    
    public void isitabel(){
        dp = impldatab.getAll();
        modeltabeldatab mp = new modeltabeldatab(dp);
        frame.getTabelDatab().setModel(mp);
    }
    
    public void insert(){
        String nama = frame.getJTxtNama().getText();
        String judul = frame.getJTxtJudul().getText();
        String jenis = frame.getJTxtJenis().getText();
        String nomor = frame.getJTxtNomor().getText();
        String durasi = frame.getJTxtDurasi().getText();
        
        if(nama.isEmpty() || judul.isEmpty() || jenis.isEmpty() || nomor.isEmpty() || durasi.isEmpty()){
            JOptionPane.showMessageDialog(frame, "Harap isi semua field","Peringatan",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            int Durasi = Integer.parseInt(durasi);
            datab dp = new datab();
            dp.setNama_penyewa(nama);
            dp.setJudul_buku(judul);
            dp.setJenis_buku(jenis);
            dp.setNomor_telepon(nomor);
            dp.setDurasi_sewa(Durasi);
            impldatab.insert(dp);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
            
            frame.getJTxtNama().setText("");
            frame.getJTxtJudul().setText("");
            frame.getJTxtJenis().setText("");
            frame.getJTxtNomor().setText("");
            frame.getJTxtDurasi().setText("");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void update(){
        String nama = frame.getJTxtNama().getText();
        String judul = frame.getJTxtJudul().getText();
        String jenis = frame.getJTxtJenis().getText();
        String nomor = frame.getJTxtNomor().getText();
        String durasi = frame.getJTxtDurasi().getText();
        
        if(nama.isEmpty() || judul.isEmpty() || jenis.isEmpty() || nomor.isEmpty() || durasi.isEmpty()){
            JOptionPane.showMessageDialog(frame, "Harap isi semua field","Peringatan",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            int Durasi = Integer.parseInt(durasi);
            datab dp = new datab();
            dp.setNama_penyewa(nama);
            dp.setJudul_buku(judul);
            dp.setJenis_buku(jenis);
            dp.setNomor_telepon(nomor);
            dp.setDurasi_sewa(Durasi);
            impldatab.update(dp);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
            
            frame.getJTxtNama().setText("");
            frame.getJTxtJudul().setText("");
            frame.getJTxtJenis().setText("");
            frame.getJTxtNomor().setText("");
            frame.getJTxtDurasi().setText("");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Durasi harus berupa angka","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(){
        String nama = frame.getJTxtNama().getText();
        impldatab.delete(nama);
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        frame.getJTxtNama().setText("");
            frame.getJTxtJudul().setText("");
            frame.getJTxtJenis().setText("");
            frame.getJTxtNomor().setText("");
            frame.getJTxtDurasi().setText("");
    }
}
