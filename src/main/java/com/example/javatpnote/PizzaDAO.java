package com.example.javatpnote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public static List<Pizza> getPizzas(){

        List<Pizza> pizzas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpNoteJava", "agozzino3u_appli", "32222926");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Pizza");

            while (rs.next()) {
                Pizza pizza = new Pizza(rs.getString(2), rs.getDouble(3), rs.getInt(4));
                pizza.setId(rs.getString(1));
                pizzas.add(pizza);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return pizzas;
    }

    public static void ajouterPizza(Pizza pizza) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpNoteJava", "agozzino3u_appli", "32222926");

            PreparedStatement statement = con.prepareStatement("INSERT INTO Pizza VALUES(?,?,?);");
            statement.setString(1, pizza.getRecette());
            statement.setDouble(2, pizza.getPrix());
            statement.setInt(3, pizza.getNb_ing());

            statement.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
