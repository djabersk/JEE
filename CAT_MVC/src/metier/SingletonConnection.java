package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jdk.nashorn.internal.ir.ForNode;

public class SingletonConnection {
private static Connection connection;
//ce bloc static se charge une fois la classe chargé en mémoire
static{
try {
	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:Mysql://localhost:3306/cat_prod", "root", "");
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}
public static Connection getConnection() {
	return connection;
}

}
