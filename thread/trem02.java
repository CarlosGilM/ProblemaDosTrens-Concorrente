/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 20/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: Thread02 do Problema dos Trens
* Funcao...........: Thread do Trem 01, ele faz o caminho do trem
verifica as regioões de zona crítica e atualiza suas rotações
e tudo que se faz Necessario
****************************************************************/

package thread;
import control.controllerGeral;
import javafx.application.Platform;

public class trem02 extends Thread {

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Thread
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  controllerGeral cG = new controllerGeral(); // Instanciando e Criando o Controller

  @Override
  public void run() { // Start RUN
    while (true) { // Repetir o Percurso Inumeras Vezes
      switch (cG.getEscolhaPos()) { //Pega a posicao escolhida no controle
        // -------------------------------------------------------------------------//
        // AMBOS TRENS DO LADO ESQUERDO
        case 1:
        this.moveTremFrente(130, 0.0);
        this.moveTremCima(5, -90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          cG.setEstritaAlt1(0);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremBaixo(45, 90);
        this.moveTremFrente(170, 0.0);
        this.moveTremCima(5, -90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          cG.setEstritaAlt2(0);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 2

        this.moveTremBaixo(45, 90);
        this.moveTremFrente(170, 0.0);
        cG.setPositionBlue(0, 226);  
          break;

        // -------------------------------------------------------------------------//

        // -------------------------------------------------------------------------//
        // AMBO DOS LADOS DIREITO
        case 2:
        this.moveTremTras(175, 0.0);
        this.moveTremCima(5, 90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          cG.setEstritaAlt2(0);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremBaixo(45, -90);
        this.moveTremTras(170, 0.0);
        this.moveTremCima(5, -90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          cG.setEstritaAlt1(0);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 2

        this.moveTremBaixo(45, -90);
        this.moveTremTras(170, 0.0);
        cG.setPositionBlue(800, 226);  
        break;
        // -------------------------------------------------------------------------//

        // -------------------------------------------------------------------------//
        // ESQUERDO ENCIMA E DIREITO EMBAIXO
        case 3:
        this.moveTremTras(175, 0.0);
        this.moveTremCima(5, 90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          this.moveTremBaixo(30, -90);
          cG.setEstritaAlt2(0);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          this.moveTremBaixo(30, -90);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremBaixo(15, -90);
        this.moveTremTras(170, 0.0);
        this.moveTremCima(5, 90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          this.moveTremBaixo(30, -90);
          cG.setEstritaAlt1(0);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();

          this.moveTremCima(40, 90);
          this.moveTremTras(160, 0.0);
          this.moveTremBaixo(30, -90);

          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 2

        this.moveTremBaixo(15, -90);
        this.moveTremTras(170, 0.0);
        cG.setPositionBlue(800, 226);  
        break;
        // -------------------------------------------------------------------------//

        // -------------------------------------------------------------------------//
        // ESQUERDO EMBAIXO E DIREITO ENCIMA
        case 4:
        this.moveTremTras(175, 0.0);
        this.moveTremBaixo(5, -90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          this.moveTremCima(30, 90);
          cG.setEstritaAlt2(0);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          this.moveTremCima(30, 90);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremCima(15, 90);
        this.moveTremTras(170, 0.0);
        this.moveTremBaixo(5, -90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          this.moveTremCima(30, 90);
          cG.setEstritaAlt1(0);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          this.moveTremCima(30, 90);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 2

        this.moveTremCima(15, 90);
        this.moveTremTras(170, 0.0);
        cG.setPositionBlue(800, 142);  
          break;
        // -------------------------------------------------------------------------//
      } // Fim Switch
    } // Fim While
  } // Fim Run

  // Mover o trem para frente e rotaciona o mesmo com o paramemetro passado
  public void moveTremFrente(int quantidade, double rotate) {

    if (cG.getRotation(2) != rotate) {
      cG.setRotateImg(2, rotate);
    }

    Double x = cG.getPositionX(2);
    for (int i = 0; i < quantidade; i++) {
        x += 1;
        Double finalX = x;
        Platform.runLater(() -> cG.atualizaPosicaoX(2, finalX));
        try {
            Thread.sleep(cG.getSliderBlue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
  // Mover o trem para baixo e rotaciona o mesmo com o paramemetro passado
public void moveTremBaixo(int quantidade, double rotate) {
  if (cG.getRotation(2) != rotate) {
    cG.setRotateImg(2, rotate);
  }

  Double y = cG.getPositionY(2);
  for (int i = 0; i < quantidade; i++) {
      y += 1;
      Double finalY = y;
      Platform.runLater(() -> cG.atualizaPosicaoY(2, finalY));
      try {
          Thread.sleep(cG.getSliderBlue());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
  // Mover o trem para tras e rotaciona o mesmo com o paramemetro passado
public void moveTremTras(int quantidade, double rotate) {
  if (cG.getRotation(2) != rotate) {
    cG.setRotateImg(2, rotate);
  }

  Double x = cG.getPositionX(2);

  for (int i = 0; i < quantidade; i++) {
      x -= 1;
      double finalX = x;
      Platform.runLater(() -> cG.atualizaPosicaoX(2, finalX));
      try {
          Thread.sleep(cG.getSliderBlue());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}

  // Mover o trem para cima e rotaciona o mesmo com o paramemetro passado
public void moveTremCima(int quantidade, double rotate) {
  if (cG.getRotation(2) != rotate) {
    cG.setRotateImg(2, rotate);
  }

  Double y = cG.getPositionY(2);
  for (int i = 0; i < quantidade; i++) {
      y -= 1;
      Double finalY = y;
      Platform.runLater(() -> cG.atualizaPosicaoY(2, finalY));
      try {
          Thread.sleep(cG.getSliderBlue());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
// Metodo de Verificacao de Variavel de Travamento 01
  public void TrilhoVazioTRAVAMENTO1() {
    while (cG.getVariavelTravamento1() == 1) {
      try {
        trem02.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    cG.setVariavelTravamento1(1);
  }
// Metodo de Verificacao de Variavel de Travamento 02
  public void TrilhoVazioTRAVAMENTO2() {
    while (cG.getVariavelTravamento2() == 1) {
      try {
        trem02.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    cG.setVariavelTravamento2(1);
  }
// Metodo de Verificacao de Estrita Alternancia 1
  public void TrilhoVazioEstAlt1() {
    while (cG.getEstritaAlt1() != 1) {
      try {
        trem02.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
// Metodo de Verificacao de Estrita Alternancia 2
  public void TrilhoVazioEstAlt2() {
    while (cG.getEstritaAlt2() != 1) {
      try {
        trem02.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}