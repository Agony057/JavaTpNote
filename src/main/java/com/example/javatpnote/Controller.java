package com.example.javatpnote;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView tableau;

    @FXML
    private TableColumn col_recette;
    @FXML
    private TableColumn col_prix;
    @FXML
    private TableColumn col_nb_ingredient;

    @FXML
    private TextField text_recette;
    @FXML
    private TextField text_prix;
    @FXML
    private TextField text_nb_ingredient;

    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_vider;

    @FXML
    protected void onViderButtonClick() {
        tableau.getItems().clear();
        new PizzaDAO().supprimerToutePizza();
    }

    @FXML
    protected void onAjouterButtonClick() {
        String recette = text_recette.getText().trim();
        String prix = text_prix.getText().trim();
        String nb_ing = text_nb_ingredient.getText().trim();

        Pizza pizza = new Pizza(recette, isDouble(prix), isInt(nb_ing));

        ajouterPizzaDansTableau(pizza);

        text_recette.clear();
        text_prix.clear();
        text_nb_ingredient.clear();

    }

    public int isInt(String valeur){
//        trouvé sur internet
        int res = 0;
        if (valeur.matches("^\\p{Digit}+$")){
            res = Integer.parseInt(valeur);
        }
        return res;
    }

    public double isDouble(String valeur) {
//        trouvé sur internet
        double res = 0.0;
        if (valeur.matches("^\\d+(\\.\\d+)?$")) {
            res = Double.parseDouble(valeur);
        }
        return res;
    }


    @FXML
    public void ajouterPizzaDansTableau(Pizza pizza){
//        Pizza pizza = new Pizza(recette, prix, nb_ing);

        ObservableList<Pizza> pizzas = tableau.getItems();
        pizzas.add(pizza);
        tableau.setItems(pizzas);
        new PizzaDAO().ajouterPizza(pizza);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_recette.setCellValueFactory(new PropertyValueFactory<Pizza, String>("recette"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Pizza, String>("prix"));
        col_nb_ingredient.setCellValueFactory(new PropertyValueFactory<Pizza, String>("nb_ing"));

        List<Pizza> pizzas = new PizzaDAO().getPizzas();
        for (int i = 1; i < pizzas.size(); i++) {
            Pizza pizza = new Pizza();
            pizza.setRecette(pizzas.get(i).getRecette());
            pizza.setPrix(pizzas.get(i).getPrix());
            pizza.setNb_ing(pizzas.get(i).getNb_ing());

            tableau.getItems().add(pizza);
        }
        System.out.println(pizzas);
    }
}
