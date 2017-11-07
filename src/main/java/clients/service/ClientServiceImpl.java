package clients.service;

import clients.entity.Client;
import clients.jdbc.ClientJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientJDBC clientJDBC;

    @Override
    public List<Client> getListClient() {
        return clientJDBC.getListClient();
    }

    @Override
    public void deleteById(int id) {
        clientJDBC.deleteById(id);
    }

    @Override
    public void save(Client client) {
        clientJDBC.save(client);
    }
}
