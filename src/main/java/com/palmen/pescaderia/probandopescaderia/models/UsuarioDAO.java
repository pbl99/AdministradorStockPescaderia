package com.palmen.pescaderia.probandopescaderia.models;

import java.sql.*;

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

    //Método para verificar en el login si existe el usuario
    public boolean verificarCredenciales(String usuario, String clave) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si hay al menos un resultado, las credenciales son válidas
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de consulta
            return false;
        }
    }

    public static boolean existeUsuario(String correo) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT correo FROM usuarios WHERE correo = ?")) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Devuelve true si encuentra el correo en la base de datos
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar la existencia del usuario: " + e.getMessage());
            return false;
        }
    }
}
