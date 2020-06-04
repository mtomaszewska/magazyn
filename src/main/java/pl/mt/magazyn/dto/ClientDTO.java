package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Client;

public class ClientDTO {
    private String firstName;
    private String lastName;
    private String address;

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
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        return client;
    }
}
