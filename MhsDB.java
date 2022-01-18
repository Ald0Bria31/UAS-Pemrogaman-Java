/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALDO
 */
public class MhsDB {
   Connection con;
   PreparedStatement pst;
   ResultSet rs;
   Statement st;
    
    public MhsDB(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudmhs","root" ,"");
            System.out.println("Koneksi Berhasil");
             } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(MhsDB.class.getName()).log(Level.SEVERE, null, ex);
             }
        
         }
    public void insertDB(String nim, String nama, String alamat){
       try {
           String sql = "insert into dbmhs values (?,?,?)";
           pst = con.prepareStatement(sql);
           pst.setString(1, nim);
           pst.setString(2, nama);
           pst.setString(3, alamat);
           pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(MhsDB.class.getName()).log(Level.SEVERE, null, ex);
       }
        

       }
    public ResultSet selectDB (){
       try {
           String sql="select * from dbmhs";
           st = con.createStatement();
           rs = st.executeQuery(sql);
       } catch (SQLException ex) {
           Logger.getLogger(MhsDB.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rs;
    }
   
    public void deleteDB(String nim){
       try {
           String sql = "delete from dbmhs where nim =?";
           pst = con.prepareStatement(sql);
           pst.setString(1,nim);
           pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(MhsDB.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        public void updateDB(String nim, String nama, String alamat){
       try {
           String sql = "update dbmhs set Nama =?, Alamat=? where NIM=?";
           pst = con.prepareStatement(sql);
           pst.setString(3, nim);
           pst.setString(1, nama);
           pst.setString(2, alamat);
           pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(MhsDB.class.getName()).log(Level.SEVERE, null, ex);
       }
        

       }
}
    



    
    


    
    

