package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Mascota;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//ACCESO AL CRUD
public class MascotaDAO {

    private Connect connect;

    public MascotaDAO(Connect connect) {
        this.connect = connect;
    }

    public boolean agregarMascota(String nombre, int edad) {
        PreparedStatement ps;
        String sql = "INSERT INTO T_mascota(nombre,edad) VALUES (?,?)";

        try {
            connect.openConnectDB();
            ps = connect.getConnection().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            int cont = ps.executeUpdate(); // devuelve un entero (-1 si no lo hace) o (1 si lo hace)
            if (cont > 0) {
                connect.closeConnectDB();
                return true;
            } else {
                connect.closeConnectDB();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Mascota buscarMascota(String nombre) {
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM T_mascota WHERE nombre = '" + nombre + "';";
        Mascota encontrada = null;

        try {
            connect.openConnectDB();
            ps = connect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nombre");
                int edad = Integer.parseInt(rs.getString("edad"));
                encontrada = new Mascota(nom, edad);
            }
            connect.closeConnectDB();
        } catch (Exception e) {
            e.printStackTrace();
            encontrada = null;
        }
        return encontrada;
    }


    public boolean eliminarMascota(String nombre) {
        PreparedStatement ps;
        String sql = "DELETE FROM T_mascota WHERE nombre = ?";
        try {
            connect.openConnectDB();
            ps = connect.getConnection().prepareStatement(sql);
            ps.setString(1, nombre);
            int flag = ps.executeUpdate();
            if(flag > 0) {
                connect.closeConnectDB();
                return true;
            } else {
                connect.closeConnectDB();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean modificarMascota(String nombre,int edad) {
        PreparedStatement ps;
        String sql = "UPDATE T_mascota SET edad = '" + edad + "' WHERE nombre = '" + nombre + "';";

        try {
            connect.openConnectDB();
            ps = connect.getConnection().prepareStatement(sql);
            ps.execute();
            connect.closeConnectDB();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String mostrarListado() {
        ArrayList<Mascota> veterinaria = new ArrayList<Mascota>();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "SELECT * FROM T_mascota";
        String listado = "";
        try {
            connect.openConnectDB();
            ps = connect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String nombre = rs.getString(1);
                int edad = Integer.parseInt(rs.getString(2));
                Mascota aux = new Mascota(nombre, edad);
                veterinaria.add(aux);

            }
            for (Mascota mascota : veterinaria) {
                listado = listado.concat(mascota.toString() + "\n");
            }
            connect.closeConnectDB();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listado;
    }

}
