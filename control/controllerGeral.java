/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 20/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: Controlador do Problema dos Trens
* Funcao...........: Controler GERAL, é o controller que gerencia
toda as threads, e toda parte do JavaFx, ele controla
todos labels, texts, images ..., inicializa as threads, seta
todos controladores em todas threads, starta as threads por 
meio dos métodos, atualiza as imagens, e controla a visualização de tudo
****************************************************************/

package control;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import thread.*;

public class controllerGeral implements Initializable {

  @FXML private AnchorPane AnchorPaneInicial;
  @FXML private ImageView train01IMG;
  @FXML private ImageView train02IMG;
  @FXML private ChoiceBox<String> choiceBox02;
  @FXML private ChoiceBox<String> choiceBox1;
  @FXML private Button buttonInit;
  @FXML private ImageView imgInit;
  @FXML private Slider sliderBlue;
  @FXML private Slider sliderYellow;
  @FXML private ImageView operator;
  @FXML private ImageView operator1;
  @FXML private ImageView operator11;
  @FXML private ImageView operator2;
  @FXML private ImageView view1;
  @FXML private ImageView view2;
  @FXML private ImageView pare01;
  @FXML private ImageView pare02;


  // Instanciando Threads
  private trem01 trem01;
  private trem02 trem02;

  //Escolhas Decisoes
  private int escolhaPos = 0;
  private int resolucao = 0;

  // Variaveis de Tavamento
  private int variavelTravamento1 = 0;
  private int variavelTravamento2 = 0;

  //Variavel de Estrita Alternancia
  private int estritaAlt1= 0;
  private int estritaAlt2= 0;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
    //Setando as Alternativas no ChoiceBox
    choiceBox02.getItems().addAll("Estrita Alternancia", "Variavel de Travamento");
    choiceBox1.getItems().addAll("Ambos Trens do lado [ ESQUERDO ]", "Ambos Trens do lado [ DIREITO ]", "Trem [ ESQUERDO ENCIMA ] & Trem [ DIREITO EMBAIXO ]", "Trem [ ESQUERDO EMBAIXO ] & Trem [ DIREITO ENCIMA ]");
    
    this.trem01 = new trem01();
    this.trem02 = new trem02();
    
    // Setando um controllador COMUM (unico) Para todas Threads
    trem01.setControlador(this);
    trem02.setControlador(this);
  }
  
  //Setando as Posições iniciais e Novas do Trem Amarelo
  public void setPositionYellow(int x, int y) {
    train01IMG.setX(0);
    train01IMG.setY(0);
    train01IMG.setX(x);
    train01IMG.setY(y);
  }
    //Setando as Posições iniciais e Novas do Trem Amarelo
  public void setPositionBlue(int x, int y) {
    train02IMG.setX(0);
    train02IMG.setY(0);
    train02IMG.setX(x);
    train02IMG.setY(y);
  }

  @FXML
  void clickIniciar(MouseEvent event) {
    // Verifica se foi escolhido as duas opcoes
   if(choiceBox1.getValue() !=null && choiceBox02.getValue() != null){
    // Desativando a visualicacao e funcionalidade dos Labels: ChoiceBoxs, Buttons e Tela de Abertura
    imgInit.setVisible(false);
    imgInit.setDisable(true);

    buttonInit.setVisible(false);
    buttonInit.setDisable(true);

    choiceBox02.setVisible(false);
    choiceBox02.setDisable(true);

    choiceBox1.setVisible(false);
    choiceBox1.setDisable(true);

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Estrita Alternancia") && choiceBox1.getValue().equals("Ambos Trens do lado [ ESQUERDO ]")){
      setEscolhas(1, 1); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulD.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 142);
      setPositionBlue(0, 226);
      trem01.start();
      trem02.start();
    }

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Estrita Alternancia") && choiceBox1.getValue().equals("Ambos Trens do lado [ DIREITO ]")){
      setEscolhas(2, 1); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloE.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(800, 142);
      setPositionBlue(800, 226);
      trem01.start();
      trem02.start();
    }

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Estrita Alternancia") && choiceBox1.getValue().equals("Trem [ ESQUERDO ENCIMA ] & Trem [ DIREITO EMBAIXO ]")){
      setEscolhas(3, 1); // Seta as Escolhas com valores
       // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 142);
      setPositionBlue(800, 226);
      setEstritaAlt2(1);
      trem01.start();
      trem02.start();
    }

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Estrita Alternancia") && choiceBox1.getValue().equals("Trem [ ESQUERDO EMBAIXO ] & Trem [ DIREITO ENCIMA ]")){
      setEscolhas(4, 1); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 226);
      setPositionBlue(800, 142);
      setEstritaAlt2(1);
      trem01.start();
      trem02.start();
    }

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Variavel de Travamento") && choiceBox1.getValue().equals("Ambos Trens do lado [ ESQUERDO ]")){
      setEscolhas(1, 2); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulD.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 142);
      setPositionBlue(0, 226);
      trem01.start();
      trem02.start();
    }

    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Variavel de Travamento") && choiceBox1.getValue().equals("Ambos Trens do lado [ DIREITO ]")){
      setEscolhas(2, 2); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloE.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(800, 142);
      setPositionBlue(800, 226);
      trem01.start();
      trem02.start();
    }
    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Variavel de Travamento") && choiceBox1.getValue().equals("Trem [ ESQUERDO ENCIMA ] & Trem [ DIREITO EMBAIXO ]")){
      setEscolhas(3, 2); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 142);
      setPositionBlue(800, 226);
      trem01.start();
      trem02.start();
    }
    // Verificacao de qual selecao do Usuario
    if(choiceBox02.getValue().equals("Variavel de Travamento") && choiceBox1.getValue().equals("Trem [ ESQUERDO EMBAIXO ] & Trem [ DIREITO ENCIMA ]")){
      setEscolhas(4, 2); // Seta as Escolhas com valores
      // Seta a imagem na orientacao correta
      train01IMG.setImage(new Image("./assets/TremAmareloD.png"));
      train02IMG.setImage(new Image("./assets/TremAzulE.png"));
      //Seta as Posicoes Iniciais e Starta as Threads
      setPositionYellow(0, 226);
      setPositionBlue(800, 142);
      trem01.start();
      trem02.start();
    }
   }
   else{
    System.out.println("SELECIONE TODAS OPÇÕES");
   }
  }

  public void atualizaPosicaoX(int src, double position) {   // Atualiza Posicoes do Trem no Eixo X
    Platform.runLater(() ->{
    switch (src) {
      case 1:
        train01IMG.setX(position);
        break;
      case 2:
        train02IMG.setX(position);
        break;
    }
    });
  }

  public void atualizaPosicaoY(int src, double position) {     // Atualiza Posicoes do Trem no Eixo Y
    Platform.runLater(() ->{
      switch (src) {
        case 1:
        train01IMG.setY(position);
        break;
        case 2:
        train02IMG.setY(position);
        break;
      }
    });
  }

  public double getPositionY(int src) {     // Retorna a posicao do Trem no Eixo Y
    double position = 0;
    switch (src) {
      case 1:
        position = train01IMG.getY();
        break;

      case 2:
      position = train02IMG.getY();
        break;
    }
    return position;
  }

  public double getPositionX(int src) {   // Retorna a posicao do Trem no Eixo X
    double position = 0;
    switch (src) {
      case 1:
        position = train01IMG.getX();
        break;

      case 2:
      position = train02IMG.getX();
        break;
    }
    return position;
  }

  public void setRotateImg(int src, double graus) {  // Rotaciona a Imagem
    Platform.runLater(() ->{
    switch (src) {
      case 1:
        train01IMG.setRotate(graus);
        break;

      case 2:
      train02IMG.setRotate(graus);
        break;
    }
  });
  }

  public double getRotation(int src){ // Pega a Rotacao do Trem
    double position = 0;
    switch (src) {
      case 1:
        position = train01IMG.getRotate();
        break;

      case 2:
      position = train02IMG.getRotate();
        break;
    }
    return position;
  }

  public void setEscolhas(int pos, int esc){ // Seta as Escolhas do Usuário
    escolhaPos = pos;
    resolucao = esc;
  }

  // Slider de Velocidade AMARELO
  public int getSliderYellow() {
    double aux = sliderYellow.getValue();
    int retorno = (int)aux;
    return retorno;
  }
  
  // Slider de Velocidade Azul
  public int getSliderBlue() {
    double aux = sliderBlue.getValue();
    int retorno = (int)aux;
    return retorno;
  }

  // Getters e Setters Abaixo
  public int getResolucao() {
      return resolucao;
  }
  public int getEscolhaPos() {
      return escolhaPos;
  }

public int getVariavelTravamento1() {
    return variavelTravamento1;
}
public int getVariavelTravamento2() {
    return variavelTravamento2;
}
public void setVariavelTravamento1(int variavelTravamento1) {
    this.variavelTravamento1 = variavelTravamento1;
}
public void setVariavelTravamento2(int variavelTravamento2) {
    this.variavelTravamento2 = variavelTravamento2;
}

public int getEstritaAlt1() {
    return estritaAlt1;
}
public ImageView getTrain02IMG() {
    return train02IMG;
}
public void setEstritaAlt1(int estritaAlt1) {
    this.estritaAlt1 = estritaAlt1;

}
public void setEstritaAlt2(int estritaAlt2) {
    this.estritaAlt2 = estritaAlt2;
}
public int getEstritaAlt2() {
    return estritaAlt2;
}

public void setVisiblePare01(){
  pare01.setVisible(true);
}

public void setVisiblePare02(){
  pare02.setVisible(true);
}

public void setVisibleFALSEPare01(){
  pare01.setVisible(false);
}

public void setVisibleFALSEPare02(){
  pare02.setVisible(false);
}

} // The End
