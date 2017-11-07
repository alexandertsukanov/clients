package clients.jdbc;

import clients.entity.Client;

import java.util.List;

public interface ClientJDBC {

    List<Client> getListClient();

    void deleteById(int id);

    void save(Client client);
}
