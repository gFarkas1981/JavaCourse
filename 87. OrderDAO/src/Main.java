import model.DBModel;
import model.IModel;
import model.Szemely;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String userName = "root";
        String password = "1234";
        String db_url = "jdbc:mysql://localhost:3306/megrendelesek";

        try {

            Connection connection = DriverManager.getConnection(db_url, userName, password);
            IModel model = new DBModel(connection);

            Szemely szemely = new Szemely("Béla", "bela@gmail.com");
            model.addSzemely(szemely);
            List<Szemely> megrendelok = model.getAllSzemely();

            connection.close();

            for (Szemely sz : megrendelok) {

                System.out.println(sz);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
