package view; //Classe que quando executada interage com o usuário
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop()) --> launch()
import javafx.geometry.Pos;
import javafx.scene.Scene; //Container que vai conter os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; //É a propria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;//Um dos tipos de layouts
import javafx.scene.control.TextField;
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadCliente extends Application {

    @Override
    public void start(Stage janela) throws Exception {

        //Carregar imagens
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));
        Image imgUser = new Image(getClass().getResourceAsStream("/view/resources/img/iconUser.png"));

        Sidebar sidebar = new Sidebar();
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);

        PainelBotoes painelBotoes = new PainelBotoes();
        BorderPane botoesPane = new BorderPane();
        botoesPane.setCenter(painelBotoes);

        ImageView viewImgUser = new ImageView(imgUser);
        viewImgUser.setFitWidth(20);
        viewImgUser.setFitHeight(20);
        //icon.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox( viewImgUser, lblTitulo);
        tituloBox.setSpacing(10);
        //tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome Sobrenome");

        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotemail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(##)#####-####");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);

        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);

        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);

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

    //Metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;

            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
                txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (Aplicação)
    }
}