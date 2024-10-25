package org.example.controller;

import org.example.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Menu> listMenu;

    public MenuService() {
        createMenu();
    }

    private void createMenu() {
        listMenu = new ArrayList<>();

        Menu item1 = new Menu();
        item1.setId("1");
        item1.setName("Burguer");
        item1.setDescription("Burguer and fries");
        item1.setPrice(20.00);
        item1.setTimePreparation(10);

        Menu item2 = new Menu();
        item2.setId("2");
        item2.setName("Pizza");
        item2.setDescription("Peperoni pizza");
        item2.setPrice(50.00);
        item2.setTimePreparation(25);

        Menu item3 = new Menu();
        item3.setId("3");
        item3.setName("Salad");
        item3.setDescription("Lettuce salad");
        item3.setPrice(8.00);
        item3.setTimePreparation(7);

        listMenu.add(item1);
        listMenu.add(item2);
        listMenu.add(item3);
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }
}
