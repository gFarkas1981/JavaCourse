package model;

import java.sql.SQLException;
import java.util.List;

public interface IModel {

    List<Rendeles> getAllRendeles() throws SQLException;
    int updateRendeles(Rendeles rendeles) throws SQLException;
    int deleteRendeles(Rendeles rendeles) throws SQLException;
    int addRendeles(Rendeles rendeles) throws SQLException;

    List<Szemely> getAllSzemely() throws SQLException;
    int updateSzemely(Szemely szemely) throws SQLException;
    int deleteSzemely(Szemely szemely) throws SQLException;
    int addSzemely(Szemely szemely) throws SQLException;

    Void close() throws SQLException;

}
