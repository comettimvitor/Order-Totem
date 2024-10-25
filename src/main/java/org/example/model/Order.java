package org.example.model;

import java.util.List;
import java.util.Set;

public class Order {
    private Set<Integer> id;
    private List<Menu> itens;
    private String status;
    private Client client;


    public Order(Set<Integer> id, List<Menu> itens, Client client) {
        this.itens = itens;
        this.status = "Pendente";
        this.id = id;
        this.client = client;
    }

    public Set<Integer> getId() {
        return id;
    }

    public void setId(Set<Integer> id) {
        this.id = id;
    }

    public List<Menu> getItens() {
        return itens;
    }

    public void setItens(List<Menu> itens) {
        this.itens = itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
