package clients.action;

import clients.entity.Client;
import clients.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainAction extends ActionSupport {

    @Autowired
    private ClientService clientService;
    private List<Client> clientList;
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String displayClients() {
        clientList = clientService.getListClient();
        return "listClients";
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public String deleteClient(){
        clientService.deleteById(Integer.valueOf(id));
        return SUCCESS;
    }
}
