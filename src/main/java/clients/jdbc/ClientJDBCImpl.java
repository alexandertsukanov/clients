package clients.jdbc;


import clients.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientJDBCImpl implements ClientJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> getListClient() {
        return jdbcTemplate.query("SELECT id, firstname, lastname, email, TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) AS age, sex FROM clients", new ClientMapper());
    }

    @Override
    @Transactional
    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO clients(firstname, lastname, email, sex, birthdate) VALUES (?,?,?,?,?)", client.getFirstName(), client.getLastName(), client.getEmail(), client.getSex(), client.getBirthDate());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM clients WHERE id = ?", id);
    }

    private static class ClientMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNo) throws SQLException {
            Client client = new Client();
            client.setId(rs.getLong("id"));
            client.setFirstName(rs.getString("firstname"));
            client.setLastName(rs.getString("lastname"));
            client.setEmail(rs.getString("email"));
            client.setAge(rs.getInt("age"));
            client.setSex(rs.getString("sex"));
            return client;
        }
    }
}
