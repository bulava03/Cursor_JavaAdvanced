package database.planeUse;

import java.sql.*;
import model.Plane;
import database.ConnectDatabase;

public class PlaneImplementation {
    public void addPlane(Plane plane) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String insertPlane = "INSERT INTO planes (model, serialnumber, seats) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertPlane);
            preparedStatement.setString(1, plane.getModel());
            preparedStatement.setString(2, plane.getSerialNumber());
            preparedStatement.setInt(3, plane.getSeats());
            preparedStatement.executeUpdate();
            System.out.println("Літак додано успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getPlanes() {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String selectAllPlanes = "SELECT * FROM planes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllPlanes);
            while (resultSet.next()) {
                int planeId = resultSet.getInt("plane_id");
                String model = resultSet.getString("model");
                String serialNumber = resultSet.getString("serialnumber");
                int seats = resultSet.getInt("seats");
                System.out.printf("Plane ID: %d, Model: %s, Serial Number: %s, Seats: %d\n", planeId, model, serialNumber, seats);
            }
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePlane(Plane plane) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String updatePlane = "UPDATE planes SET seats = ? WHERE model = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updatePlane);
            preparedStatement.setInt(1, plane.getSeats());
            preparedStatement.setString(2, plane.getModel());
            preparedStatement.executeUpdate();
            System.out.println("Інформацію про літак змінено успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePlane(String serialNumber) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String deletePlane = "DELETE FROM planes WHERE serialnumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deletePlane);
            preparedStatement.setString(1, serialNumber);
            preparedStatement.executeUpdate();
            System.out.println("Літак видалено успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
