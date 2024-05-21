/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatab;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.databimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC PRAKTIKUM
 */
public class databDAO implements databimplement{
    Connection connection;
    
    final String select = "SELECT * FROM sewa_buku";
    final String insert = "INSERT INTO sewa_buku(nama_penyewa,judul_buku,jenis_buku,nomor_telepon,durasi_sewa,total_biaya) VALUES(?,?,?,?,?,?);";
    final String update = "UPDATE sewa_buku set judul_buku=?, jenis_buku=?, nomor_telepon=?, durasi_sewa=?, total_biaya=? where nama_penyewa=?;";
    final String delete= "DELETE from sewa_buku where id=?";
    
    public databDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datab b) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, b.getNama_penyewa());
            statement.setString(2, b.getJudul_buku());
            statement.setString(3, b.getJenis_buku());
            statement.setString(4, b.getNomor_telepon());
            statement.setInt(5, b.getDurasi_sewa());
            int biayaDasar = 10000;
            int tambahan = 5000;
            int total;
            
            if(b.getDurasi_sewa() <= 2){
                total = b.getDurasi_sewa() * biayaDasar;
                
            }else{
                int biayaAwal = 2*biayaDasar;
                int Tambahan = b.getDurasi_sewa() - 2;
                int biayaTambahan = Tambahan*(biayaDasar + tambahan);
                total = biayaAwal + biayaTambahan;
            }
            
            statement.setInt(6, total);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setNama_penyewa(rs.getString(1));
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datab b) {
         PreparedStatement statement = null;
         try{
            statement = connection.prepareStatement(update);
            
            
            statement.setString(1, b.getJudul_buku());
            statement.setString(2, b.getJenis_buku());
            statement.setString(3, b.getNomor_telepon());
            statement.setInt(4, b.getDurasi_sewa());
            int biayaDasar = 10000;
            int tambahan = 5000;
            int total;
            
            if(b.getDurasi_sewa() <= 2){
                total = b.getDurasi_sewa() * biayaDasar;
                
            }else{
                int biayaAwal = 2*biayaDasar;
                int Tambahan = b.getDurasi_sewa() - 2;
                int biayaTambahan = Tambahan*(biayaDasar + tambahan);
                total = biayaAwal + biayaTambahan;
            }
            
            statement.setInt(5, total);
            statement.setString(6, b.getNama_penyewa());
            statement.executeUpdate();
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String Nama) {
         PreparedStatement statement = null;
         try{
             statement = connection.prepareStatement(delete);
             statement.setString(1, Nama);
             statement.executeUpdate();
         }catch(SQLException ex){
         ex.printStackTrace();
         }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
         }
    }

    @Override
    public List<datab> getAll() {
        List<datab> dp =null;
        try{
            dp = new ArrayList<datab>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datab b = new datab();
                b.setNama_penyewa(rs.getString("nama_penyewa"));
                b.setJudul_buku(rs.getString("judul_buku"));
                b.setJenis_buku(rs.getString("jenis_buku"));
                b.setNomor_telepon(rs.getString("nomor_telepon"));
                b.setDurasi_sewa(rs.getInt("durasi_sewa"));
                b.setTotal_biaya(rs.getInt("total_biaya"));
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(databDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dp;
    }
}
