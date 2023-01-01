package ntplug.ntplug.controller;

//STEP 1. Import required packages
        import java.sql.*;

public class db_select {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://192.168.1.8:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void main(String[] argv) throws SQLException {

        try {
            // Создание соединения с базой данных
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Создание оператора доступа к базе данных
            Statement statement  = connection.createStatement();

            // Выполнение запроса к базе данных, получение набора данных
            ResultSet resultSet = statement.executeQuery("SELECT * from users u LEFT JOIN emails e ON u.login = e.login");

            // Выводим название полей
            for (int j = 1; j <= resultSet.getMetaData().getColumnCount(); j++) {
                System.out.print(resultSet.getMetaData().getColumnName(j) + "\t\t");
            }
            System.out.println();

            // Выводим данные
            while (resultSet.next()) {
                for (int j = 1; j <= resultSet.getMetaData().getColumnCount(); j++) {
                    System.out.print(resultSet.getString(j) + "\t\t");
                }
                System.out.println();
            }


            System.out.println();
            while (resultSet.next()){
                System.out.println(resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error 1234");
        }


    }
}