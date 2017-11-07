package clients.action;

import clients.entity.Client;
import clients.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientAction extends ActionSupport {

    @Autowired
    private ClientService clientService;
    private List<String>sexList = new ArrayList<>();
    private Client client;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String addClient(){

        return "success";
    }

    public String saveClient(){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        client.setBirthDate(sqlDate);
        clientService.save(client);
        return SUCCESS;
    }

    public List<String> getSexList() {
        return sexList;
    }

    @SkipValidation
    public String execute() throws Exception {
        sexList.add("M");
        sexList.add("F");
        return SUCCESS;
    }

}
