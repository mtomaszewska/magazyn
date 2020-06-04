package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Client;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client toClient(){
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        return client;
    }

    public ClientDTO fromClient(Client client) {
        this.setId(client.getId());
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setAddress(client.getAddress());
        return this;
    }

}
