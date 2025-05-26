package view;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PainelBotoes;
import view.components.Sidebar;
import java.text.SimpleDateFormat;

public class CadUsuario extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Image imgUser = new Image(getClass().getResourceAsStream("/view/resources/img/iconUser.png"));
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));

        ImageView viewImgUser = new ImageView(imgUser);
        viewImgUser.setFitWidth(20);
        viewImgUser.setFitHeight(20);

        Sidebar sidebar = new Sidebar();
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);

        PainelBotoes painelBotoes = new PainelBotoes();
        BorderPane botoesPane = new BorderPane();
        botoesPane.setCenter(painelBotoes);

        Label lblTitulo = new Label("Cadastro de Usuários");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(viewImgUser, lblTitulo);
        tituloBox.setSpacing(10);
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome Sobrenome");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotemail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();

        Label lblCargo = new Label("Cargo: ");
        ComboBox<String> boxCargo = new ComboBox<>();
        boxCargo.getItems().addAll("Gerência", "Recepção", "Administrador");
        boxCargo.setPromptText("Selecione:");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(boxEmail, 2, 1);

        formGrid.add(lblSenha, 0, 2);
        formGrid.add(txtSenha, 1, 2);

        formGrid.add(lblCargo, 0, 3);
        formGrid.add(boxCargo, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        mainPane.setStyle("-fx-background-color: lightgray");

        VBox layout = new VBox(10, tituloBox, formGrid, botoesPane );
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        botoesPane.setCenter(painelBotoes);

        Scene scene = new Scene(mainPane, 750, 600);
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