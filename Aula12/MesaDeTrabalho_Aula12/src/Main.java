import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private static final String sqlCreate = "CREATE TABLE Funcionarios (Id INT PRIMARY KEY, Nome VARCHAR(100) NOT NULL, Cpf VARCHAR(100) NOT NULL, Cargo VARCHAR(100) NOT NULL, Setor VARCHAR(100) NOT NULL)";
    private static final String sqlDrop = "DROP TABLE IF EXISTS Funcionarios";

    private static final String sqlInsert1 = "INSERT INTO Funcionarios (Id, Nome, Cpf, Cargo, Setor) VALUES (1, 'Paulo Dehon', '395.593.953-35', 'Desenvolvedor', 'TI')";
    private static final String sqlInsert2 = "INSERT INTO Funcionarios (Id, Nome, Cpf, Cargo, Setor) VALUES (2, 'João Alves', '975.759.597-75', 'Vendedor', 'Vendas')";
    private static final String sqlInsert3 = "INSERT INTO Funcionarios (Id, Nome, Cpf, Cargo, Setor) VALUES (2, 'Maria Silva', '549.945.459.95', 'Analista', 'RH')";

    private static final String sqlUpdate = "UPDATE Funcionarios SET Cargo = 'Gerente' WHERE Id=2";

    private static final String sqlDeleteById = "DELETE FROM Funcionarios WHERE Id=1";
    private static final String sqlDeleteByNome = "DELETE FROM Funcionarios WHERE Nome = 'João Alves'";

    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);


        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
