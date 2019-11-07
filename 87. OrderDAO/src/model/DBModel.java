package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBModel implements IModel{

    private Connection connection;
    private PreparedStatement getAllSzemelyPstmt;
    private PreparedStatement getAllRendelesPstmt;
    private PreparedStatement updateSzemelyPstmt;
    private PreparedStatement deleteSzemelyPstmt;
    private PreparedStatement addSzemelyPstmt;

    public DBModel(Connection connection) throws SQLException{

        this.connection = connection;
        getAllSzemelyPstmt =
                connection.prepareStatement("SELECT * FROM szemely");
        updateSzemelyPstmt =
                connection.prepareStatement
                        ("UPDATE szemely SET nev = ?, email = ?, WHERE id = ?");
        deleteSzemelyPstmt =
                connection.prepareStatement("DELETE FROM szemely WHERE id = ?");
        addSzemelyPstmt =
                connection.prepareStatement
                        ("INSERT INTO szemely (nev, email) VALUES (?, ?)");

    }

    @Override
    public List<Rendeles> getAllRendeles() throws SQLException {
        return null;
    }

    @Override
    public int updateRendeles(Rendeles rendeles) throws SQLException {
        return 0;
    }

    @Override
    public int deleteRendeles(Rendeles rendeles) throws SQLException {
        return 0;
    }

    @Override
    public int addRendeles(Rendeles rendeles) throws SQLException {
        return 0;
    }

    @Override
    public List<Szemely> getAllSzemely() throws SQLException {

        ResultSet resultSet = getAllSzemelyPstmt.executeQuery();
        List<Szemely> szemelyek = new ArrayList<>();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String nev = resultSet.getString("nev");
            String email = resultSet.getString("email");

            Szemely szemely = new Szemely(id, nev, email);
            szemelyek.add(szemely);

        }

        resultSet.close();

        return szemelyek;

    }

    @Override
    public int updateSzemely(Szemely szemely) throws SQLException {

        updateSzemelyPstmt.setString(1, szemely.getNev());
        updateSzemelyPstmt.setString(2, szemely.getEmail());
        updateSzemelyPstmt.setInt(3, szemely.getId());

        return updateSzemelyPstmt.executeUpdate();

    }

    @Override
    public int deleteSzemely(Szemely szemely) throws SQLException {

        deleteSzemelyPstmt.setInt(1, szemely.getId());

        return deleteSzemelyPstmt.executeUpdate();

    }

    @Override
    public int addSzemely(Szemely szemely) throws SQLException {

        addSzemelyPstmt.setString(1, szemely.getNev());
        addSzemelyPstmt.setString(2, szemely.getEmail());

        return addSzemelyPstmt.executeUpdate();

    }

    @Override
    public Void close() throws SQLException {
        return null;
    }
}
