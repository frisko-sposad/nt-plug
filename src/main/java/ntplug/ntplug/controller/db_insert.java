package ntplug.ntplug.controller;

//STEP 1. Import required packages
        import java.sql.*;
        import java.util.Date;
        import java.util.Scanner;

public class db_insert {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://192.168.1.8:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void main(String[] argv) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Login= " + login + ", Password= " + password);

// Создание соединения с базой данных, оператора доступа к базе данных,выполнение запроса к базе данных, получение набора данных
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO public.users (login, password) VALUES(?,?)"
             );
                ) {
            preparedStatement.setString(1, login );
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            System.out.println("Данные добавлены");
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }
}