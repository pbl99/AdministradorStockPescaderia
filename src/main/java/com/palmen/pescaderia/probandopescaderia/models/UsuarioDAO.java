package com.palmen.pescaderia.probandopescaderia.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/app_pescaderia";
    private static final String USUARIO = "palmenendez";
    private static final String CLAVE = "root";

    // Método para obtener la conexión a la base de datos
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    // Método para insertar un nuevo usuario
    public static void crearUsuario(String correo, String usuario, String clave) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios (correo, usuario, clave) VALUES (?, ?, ?)")) {
            stmt.setString(1, correo);
            stmt.setString(2, usuario);
            stmt.setString(3, clave);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("No se ha podido crear el usuario");
        }
    }

}
