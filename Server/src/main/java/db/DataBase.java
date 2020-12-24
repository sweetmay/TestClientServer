package db;

import db.entity.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private Connection connection;
    private Statement statement;

    public void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sladkiymay\\Test\\main.db");
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void disconnect(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Contract> getContracts(){
        List<Contract> contractList = new ArrayList<>();
        try {
            ResultSet set = statement.executeQuery("SELECT id, date,last_updated FROM contracts");
            while (set.next()){
                contractList.add(
                        new Contract(set.getInt("id")
                        , set.getString("last_updated")
                        , set.getString("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }
}
