package database;

import java.sql.*;

public class DefaultDatabase {
    public void createDefaultDB() {
        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password);
             Statement statement = connection.createStatement()) {
            String createTablePlanes = "DROP TABLE IF EXISTS planes; CREATE TABLE planes (" +
                    "plane_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "model VARCHAR(30)," +
                    "serialnumber VARCHAR(30) UNIQUE," +
                    "seats INT)";
            statement.executeUpdate(createTablePlanes);

            String createTablePilots = "DROP TABLE IF EXISTS pilots; CREATE TABLE pilots (" +
                    "pilot_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(50) UNIQUE," +
                    "age INT," +
                    "models VARCHAR(255))";
            statement.executeUpdate(createTablePilots);

            String insertPlanes = "INSERT INTO planes (model, serialnumber, seats) VALUES " +
                    "('Boeing 747', 'B-FTL94', 467)," +
                    "('Airbus A320', 'TC-DMF7', 186)," +
                    "('Airbus A320', 'VP-BJX3', 186)," +
                    "('Airbus A320', 'HB-JCD9', 186)," +
                    "('Boeing 747', 'N345AN', 467)," +
                    "('Airbus A320', 'G-CIVU6', 186)," +
                    "('Airbus A320', 'VT-IVD8', 186)";
            statement.executeUpdate(insertPlanes);

            String insertPilots = "INSERT INTO pilots (NAME, age, models) VALUES " +
                    "('Bill', 40, 'Boeing 747, Airbus A320')," +
                    "('John', 35, 'Boeing 747')," +
                    "('Alex', 24, 'Airbus A320')," +
                    "('Victoria', 44, 'Airbus A320')," +
                    "('Roman', 41, 'Airbus A320')," +
                    "('Max', 26, 'Boeing 747, Airbus A320')," +
                    "('Barbara', 31, 'Airbus A320')," +
                    "('Steve', 36, 'Airbus A320')";
            statement.executeUpdate(insertPilots);

            System.out.println("Tables and data created successfully");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCapacity() {
        String query = "SELECT Seats FROM planes";

        try (Connection connection = DriverManager.getConnection(ConnectDatabase.url, ConnectDatabase.user, ConnectDatabase.password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int seatsSum = 0;
            while (resultSet.next()) {
                seatsSum = seatsSum + resultSet.getInt("Seats");
            }

            System.out.println("Максимальна кількість пасажирів: " + seatsSum);
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
