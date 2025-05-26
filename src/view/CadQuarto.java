package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadQuarto extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));

        Sidebar sidebar = new Sidebar();
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);

        PainelBotoes painelBotoes = new PainelBotoes();
        BorderPane botoesPane = new BorderPane();
        botoesPane.setCenter(painelBotoes);

        Label lblTitulo = new Label("Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(lblTitulo);
        tituloBox.setSpacing(10);
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome do quarto");

        Label lblNum = new Label("Número de quartos: ");
        TextField txtNum = criarMascaraCampo("###");

        Label lblCamaCasal = new Label("Cama de Casal: ");
        Spinner<Integer> qtdCamaCasal = new Spinner (0,10,1);

        Label lblCamaSolteiro = new Label("Cama de Solteiro: ");
        Spinner qtdCamaSolteiro = new Spinner(0, 10, 1);

        Label lblPreco = new Label("Preço: ");
        TextField txtPreco = criarMascaraCampo("R$ #################");

        Label lblDisponivel = new Label("Disponível:  ");
        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Não");
        boxDisponivel.setPromptText("Selecione:");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblNum, 0, 1);
        formGrid.add(txtNum, 1, 1);

        formGrid.add(lblCamaCasal, 0, 2);
        formGrid.add(qtdCamaCasal, 1, 2);

        formGrid.add(lblCamaSolteiro, 0, 3);
        formGrid.add(qtdCamaSolteiro, 1, 3);

        formGrid.add(lblPreco, 0, 4);
        formGrid.add(txtPreco, 1, 4);

        formGrid.add(lblDisponivel, 0, 5);
        formGrid.add(boxDisponivel, 1, 5);

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
            String value = newValue.replaceAll("[^0-9,]", "");
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