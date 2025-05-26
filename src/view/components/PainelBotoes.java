package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PainelBotoes extends HBox {

    public PainelBotoes() {
        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/mais.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/atualizar.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete.png"));

        //Parametros para definir como a imagem será visualizada
        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20); //Definição da altura
        ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);
        ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);

        //Criar um botão com instrução/texto e imagem:
        Button btnCad = new Button("Cadastrar", viewImgBtnCad);
        btnCad.setStyle("-fx-background-color: transparent;");
        Button btnUp = new Button("Atualizar", viewImgBtnUp);
        btnUp.setStyle("-fx-background-color: transparent");
        Button btnDel = new Button("Excluir", viewImgBtnDel);
        btnDel.setStyle("-fx-background-color: transparent");

        btnCad.setGraphic(viewImgBtnCad);
        btnUp.setGraphic(viewImgBtnUp);
        btnDel.setGraphic(viewImgBtnDel);

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-aligment:center;" +
                "-fx-cursor: hand;";

        btnCad.setStyle(styleButton);
        btnUp.setStyle(styleButton);
        btnDel.setStyle(styleButton);

        btnCad.setOnMouseEntered(evento ->
                btnCad.setStyle(styleButton.replace("transparent", "#76c37c")));
        btnCad.setOnMouseExited(evento -> btnCad.setStyle(styleButton));

        btnUp.setOnMouseEntered(evento ->
                btnUp.setStyle(styleButton.replace("transparent", "#619ed3")));
        btnUp.setOnMouseExited(evento -> btnUp.setStyle(styleButton));

        btnDel.setOnMouseEntered(evento ->
                btnDel.setStyle(styleButton.replace("transparent", "#ff5959")));
        btnDel.setOnMouseExited(evento -> btnDel.setStyle(styleButton));

        setAlignment(Pos.CENTER);
        setSpacing(10);

        getChildren().addAll(btnCad, btnUp, btnDel);
    }
}