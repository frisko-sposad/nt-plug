package ntplug.ntplug;

import ntplug.ntplug.controller.DBWorker;
import ntplug.ntplug.controller.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class NtPlugApplication {

	public static void main(String[] args) {

		SpringApplication.run(NtPlugApplication.class, args);
//		DBWorker worker = new DBWorker();
//
//		String query = "SELECT * from users";
//		try {
//			Statement statement = worker.getConnection().createStatement();
//			ResultSet resultSet = statement.executeQuery(query);
//
//			while (resultSet.next()){
//				User user = new User("user3", "3");
//				user.setLogin(resultSet.getString(1));
//				user.setPassword(resultSet.getString(2));
//
//				System.out.println(user);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
