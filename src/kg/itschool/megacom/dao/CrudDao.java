package kg.itschool.megacom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDao<Model> {
    Optional<Model> save(Model model);
    Optional<Model> findById(Long id);
    List<Model> findAll();
    List<Model> saveAll(List<Model> models);

    default Connection getConnection() throws SQLException {
        final String URL = "jdbc:postgresql://localhost:1234/postgres";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    default void close(AutoCloseable closeable) {
        try {
            Log.info(this.getClass().getSimpleName(), closeable.getClass().getSimpleName(), "Closing connection");
            closeable.close();
        } catch (Exception e) {
            Log.error(this.getClass().getSimpleName(), e.getStackTrace()[0].getClass().getSimpleName(), e.getMessage());
            e.printStackTrace();
        }
    }
}

