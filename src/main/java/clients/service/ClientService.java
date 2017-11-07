package clients.service;

import clients.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getListClient();

    void deleteById(int id);

    void save(Client client);
}
