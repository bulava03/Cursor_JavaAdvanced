package database.pilotUse;

import java.sql.*;
import model.Pilot;
import database.ConnectDatabase;

public class PilotImplementation {
    public void addPilot(Pilot pilot) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String insertPilot = "INSERT INTO pilots (name, age, models) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertPilot);
            preparedStatement.setString(1, pilot.getName());
            preparedStatement.setInt(2, pilot.getAge());
            preparedStatement.setString(3, pilot.getModels());
            preparedStatement.executeUpdate();
            System.out.println("Пілота додано успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getPilots() {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String selectAllPilots = "SELECT * FROM pilots";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllPilots);
            while (resultSet.next()) {
                int pilotId = resultSet.getInt("pilot_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String models = resultSet.getString("models");
                System.out.printf("Pilot ID: %d, Name: %s, Age: %d, Models: %s\n", pilotId, name, age, models);
            }
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePilot(Pilot pilot) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String updatePilot = "UPDATE pilots SET models = ? WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updatePilot);
            preparedStatement.setString(1, pilot.getModels());
            preparedStatement.setString(2, pilot.getName());
            preparedStatement.executeUpdate();
            System.out.println("Інформацію змінено успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePilot(String name) {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password)) {
            String deletePilot = "DELETE FROM pilots WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deletePilot);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Пілота видалено успішно");
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
