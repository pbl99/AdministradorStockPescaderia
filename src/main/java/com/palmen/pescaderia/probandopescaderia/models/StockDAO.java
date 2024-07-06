package com.palmen.pescaderia.probandopescaderia.models;

import java.sql.*;

public class StockDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/app_pescaderia";
    private static final String USUARIO = "palmenendez";
    private static final String CLAVE = "root";

    // Método para obtener la conexión a la base de datos
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    public static void actualizarStock(String nombre, Integer stock) {
        String sql = "UPDATE pescados SET stock = stock + ? WHERE nombre = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stock);
            stmt.setString(2, nombre);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La cantidad ha sido actualizada exitosamente.");
            } else {
                System.out.println("No se ha encontrado un pescado con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            System.err.println("No se ha podido actualizar la cantidad: " + e.getMessage());
        }
    }

    public static int obtenerStockActual(String nombre) {
        String sql = "SELECT STOCK FROM PESCADOS WHERE nombre = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("STOCK");
                } else {
                    System.out.println("No se encontró el pescado con nombre: " + nombre);
                    return 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el stock actual del pescado: " + e.getMessage());
            return 0;
        }
    }
}
