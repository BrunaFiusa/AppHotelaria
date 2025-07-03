package view;

import controller.UsuariosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login extends Application {
    public void start(Stage janela) throws Exception {
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));
        Image hotel = new Image(getClass().getResourceAsStream("/view/resources/img/fachadaHotel.jpg"));
        Image olhoAberto = new Image(getClass().getResourceAsStream("/view/resources/img/olhoabre.png"));
        Image olhoFechado = new Image(getClass().getResourceAsStream("/view/resources/img/olhofecha.png"));

        ImageView olhoAbertoView = new ImageView(olhoAberto);
        olhoAbertoView.setFitHeight(20);
        olhoAbertoView.setFitWidth(20);

        ImageView olhoFechadoView = new ImageView(olhoFechado);
        olhoFechadoView.setFitHeight(20);
        olhoFechadoView.setFitWidth(20);

        Button btnEntrar = new Button("Login");
        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 15px;" +
                "-fx-aligment:center;" +
                "-fx-text-fill: white;" +
                "-fx-cursor: hand;";

        btnEntrar.setStyle(styleButton);

        btnEntrar.setOnMouseEntered(evento ->
                btnEntrar.setStyle(styleButton.replace("transparent", "#486bc8")));
        btnEntrar.setOnMouseExited(evento -> btnEntrar.setStyle(styleButton));

        ImageView hotelView = new ImageView(hotel);
        hotelView.setStyle("color: white");
        hotelView.setFitHeight(600);
        hotelView.setFitWidth(750);

        Label lblTitulo = new Label("User Login");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        lblTitulo.setStyle("-fx-text-fill: white;");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Email");

        PasswordField passSenha = new PasswordField();
        passSenha.setPromptText("Senha");

        TextField txtsenha = new TextField();
        txtsenha.setPromptText("Senha");
        txtsenha.setVisible(false);
        txtsenha.setManaged(false);

        ImageView olhoIcone = new ImageView(olhoAberto);
        olhoIcone.setFitHeight(20);
        olhoIcone.setFitWidth(20);
        olhoIcone.setCursor(javafx.scene.Cursor.HAND);

        olhoIcone.setOnMouseClicked(event -> {
            boolean verificarSenha = passSenha.isVisible();

            if (verificarSenha) { //Se a senha está oculta, ou seja, verificarSenha = FALSE
                txtsenha.setText(passSenha.getText()); //Coloco o texto digitado no TextField

                passSenha.setVisible(false); //Tirar o campo Password
                passSenha.setManaged(false);
                txtsenha.setVisible(true); //Colocar o campo TextField
                txtsenha.setManaged(true);

                olhoIcone.setImage(olhoFechado);

            } else { //Se a senha está visivel, ou seja, verificarSenha = TRUE
                passSenha.setText(txtsenha.getText()); //Coloco o texto digitado no Password

                passSenha.setVisible(true); //Colocar o campo Password
                passSenha.setManaged(true);
                txtsenha.setVisible(false); //Tirar o campo TextField
                txtsenha.setManaged(false);

                olhoIcone.setImage(olhoAberto);
            }
        });

        btnEntrar.setOnAction(evento -> {
            String email = txtEmail.getText();
            String senha = passSenha.isVisible() ? passSenha.getText() : txtsenha.getText();

            UsuariosController usuariosController = new UsuariosController();
            boolean loginSucesso = usuariosController.verificarCredenciais(email, senha);
            if (loginSucesso) {
                System.out.println("Login efetuado com sucesso!");
                CadCliente cadCliente = new CadCliente();
                try {
                    cadCliente.start(janela);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Login inválido!");
            }
        });

        HBox senhaBox = new HBox(txtsenha, passSenha, olhoIcone);
        senhaBox.setSpacing(5);
        senhaBox.setAlignment(Pos.CENTER_LEFT);

        GridPane formGrid = new GridPane();
        formGrid.add(txtEmail, 0, 0);
        formGrid.add(senhaBox, 0, 1);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, lblTitulo, formGrid, btnEntrar);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: rgba(50,30,20,0.8); -fx-background-radius: 30;");
        layout.setMaxWidth(250);
        layout.setMaxHeight(100);

        StackPane root = new StackPane(hotelView, layout);
        root.setStyle("-fx-background-size: cover;");

        Scene scene = new Scene(root, 750, 600);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (Aplicação)
    }
}
