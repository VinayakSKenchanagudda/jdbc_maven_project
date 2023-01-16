package preparedstatement_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCurd {
	// method for establish connection
	public Connection getConnetion() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
	}

	// method for inserting data
	public void savePerson(int id, String name, Long phone) throws Exception {

		Connection connection = getConnetion();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into person values(?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	// method fot updating data
	public void updatePerson(int id, String name) throws Exception {

		Connection connection = getConnetion();
		PreparedStatement preparedStatement = connection.prepareStatement("update person set name=? where id=?");
		preparedStatement.setInt(2, id);
		preparedStatement.setString(1, name);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	// method for deleting data
	public void deletePerson(int id) throws Exception {
		Connection connection = getConnetion();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from person where id=?");
		preparedStatement.setInt(1, id);

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Deleted");
		} else {
			System.out.println("id not found");
		}
		preparedStatement.close();
		connection.close();
	}

	public void getAllPerson() throws Exception {
		Connection connection = getConnetion();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from person");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));

		}

	}

}
