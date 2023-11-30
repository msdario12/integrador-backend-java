package ar.com.integradorbackend.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ar.com.integradorbackend.orador.Orador;

/**
 * MySQLOradorRepository
 */
public class MySQLOradorRepository implements OradorRepository {

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Orador> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Orador getById(Long id) {
        String sql = "SELECT id_orador, nombre, apellido, mail, tema, fecha_alta FROM oradores WHERE id_orador = ?";
        Orador foundedOrador = null;
        try (Connection conn = ConnectionsManager.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Cargamos los datos en la sentencia
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();

            if (res.next()) {
                // Obtengo los datos
                Long _id = res.getLong(1);
                String nombre = res.getString(2);
                String apellido = res.getString(3);
                String mail = res.getString(4);
                String tema = res.getString(5);
                Date fechaAlta = res.getDate(6);

                foundedOrador = new Orador(_id, nombre, apellido, mail, tema, fechaAlta.toLocalDate());
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("No se encontro el orador", e);
        }

        return foundedOrador;
    }

    @Override
    public void save(Orador orador) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO oradores (nombre, apellido, mail, tema, fecha_alta) VALUES (?,?,?,?,?)";

        try (Connection conn = ConnectionsManager.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Cargamos los datos en la sentencia
            statement.setString(1, orador.getName());
            statement.setString(2, orador.getLastName());
            statement.setString(3, orador.getEmail());
            statement.setString(4, orador.getTheme());
            statement.setDate(5, Date.valueOf(orador.getStartDate()));

            statement.executeUpdate();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo crear el orador", e);
        }

    }

    @Override
    public void update(Orador orador) {
        // TODO Auto-generated method stub

    }

}