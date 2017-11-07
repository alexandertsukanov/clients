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
        String sql = "SELECT id, firstname, lastname, email, TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) AS age, sex FROM clients";
        return jdbcTemplate.query(sql, new ClientMapper());
    }

    @Override
    @Transactional
    public void save(Client client) {
        String sql = "INSERT INTO clients(firstname, lastname, email, sex, birthdate) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, client.getFirstName(), client.getLastName(), client.getEmail(), client.getSex(), client.getBirthDate());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        jdbcTemplate.update(sql, id);
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
