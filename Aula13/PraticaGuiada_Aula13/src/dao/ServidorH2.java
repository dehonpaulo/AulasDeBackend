package dao;

import config.ConfigJDBC;
import model.Medicamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorH2 implements IDAO<Medicamento> {

    private ConfigJDBC config = new ConfigJDBC();

    @Override
    public Medicamento insert(Medicamento medicamento) {
        String query = String.format("INSERT INTO Medicamentos VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                medicamento.getId(), medicamento.getCodigoNumerico(), medicamento.getNome(), medicamento.getLaboratorio(),
                medicamento.getQuantidade(), medicamento.getPreco());

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return medicamento;
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("DELETE FROM Medicamentos WHERE id = %s", id);

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        String query = String.format("SELECT * FROM Medicamentos WHERE id = %s", id);

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while(resultado.next()) {
                System.out.println("________________________________");
                System.out.println(resultado.getInt(1));
                System.out.println(resultado.getString(2));
                System.out.println(resultado.getString(3));
                System.out.println(resultado.getString(4));
                System.out.println(resultado.getInt(5));
                System.out.println(resultado.getDouble(6));
                System.out.println("________________________________");
            }

            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        String query = "SELECT * FROM Medicamentos";

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while(resultado.next()) {
                System.out.println("________________________________");
                System.out.println(resultado.getInt(1));
                System.out.println(resultado.getString(2));
                System.out.println(resultado.getString(3));
                System.out.println(resultado.getString(4));
                System.out.println(resultado.getInt(5));
                System.out.println(resultado.getDouble(6));
                System.out.println("________________________________");
            }

            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByCodigoNumerico(Integer codigoNumerico) {
        String query = String.format("SELECT * FROM Medicamentos WHERE codigoNumerico = %s", codigoNumerico);

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while(resultado.next()) {
                System.out.println("________________________________");
                System.out.println(resultado.getInt(1));
                System.out.println(resultado.getString(2));
                System.out.println(resultado.getString(3));
                System.out.println(resultado.getString(4));
                System.out.println(resultado.getInt(5));
                System.out.println(resultado.getDouble(6));
                System.out.println("________________________________");
            }

            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
