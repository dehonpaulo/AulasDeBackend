import java.sql.*;

public class Main {

    private static final String sqlCreate = "CREATE TABLE Animal (Id INT PRIMARY KEY, Nome VARCHAR(100) NOT NULL, Tipo VARCHAR(100) NOT NULL)";
    private static final String sqlDrop = "DROP TABLE IF EXISTS Animal";

    private static final String sqlInsert1 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES (1, 'Olaf', 'Cachorro')";
    private static final String sqlInsert2 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES (2, 'Harry', 'Gato')";


    private static final String sqlDelete = "DELETE FROM Animal WHERE Id=1";

    private static final String sqlSelect = "SELECT * FROM Animal";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);

            mostrarAnimais(connection);

            statement.execute(sqlDelete);

            mostrarAnimais(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarAnimais(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery(sqlSelect);

        while(resultado.next()) {
            System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " + resultado.getString(2));
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
