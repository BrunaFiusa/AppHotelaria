package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
        public Button btnCliente = new Button("Clientes");
        public Button btnFuncionario = new Button("Funcionarios");
        public Button btnQuarto = new Button("Quartos");
        public Button btnReserva = new Button("Reservas");
        public Button btnRelatorios = new Button("Relatórios");

    public Sidebar() {
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));

        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "DMSans_24pt-Regular.ttf"), 14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "DMSans_24pt-Bold.ttf"), 15);

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20);
        viewIconFuncionario.setFitWidth(20);

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(20);
        viewIconCliente.setFitWidth(20);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20);
        viewIconQuarto.setFitWidth(20);

        ImageView viewIconRelatorios = new ImageView(iconRelatorio);
        viewIconRelatorios.setFitHeight(20);
        viewIconRelatorios.setFitWidth(20);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(20);
        viewIconReserva.setFitWidth(20);

        btnFuncionario.setGraphic(viewIconFuncionario);
        btnCliente.setGraphic(viewIconCliente);
        btnQuarto.setGraphic(viewIconQuarto);
        btnRelatorios.setGraphic(viewIconRelatorios);
        btnReserva.setGraphic(viewIconReserva);

        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #a87e08;" );
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(), 25));

        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 15px;" +
                             "-fx-aligment:center;" +
                             "-fx-cursor: hand;";

        btnFuncionario.setStyle(styleButton);
        btnCliente.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorios.setStyle(styleButton);

        btnCliente.setOnMouseEntered(evento ->
           btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorios.setOnMouseEntered(evento ->
                btnRelatorios.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorios.setOnMouseExited(evento -> btnRelatorios.setStyle(styleButton));

        setMargin(lblMenu, new Insets(0,0,20,0));

        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px;");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorios);
    }
}