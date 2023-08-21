/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 20/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: Thread01 do Problema dos Trens
* Funcao...........: Thread do Trem 01, ele faz o caminho do trem
verifica as regioões de zona crítica e atualiza suas rotações
e tudo que se faz Necessario
****************************************************************/

package thread;

import control.controllerGeral;
import javafx.application.Platform;

public class trem01 extends Thread {
  controllerGeral cG = new controllerGeral(); // Instanciando e Criando o Controller

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Thread
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // Start RUN
    while (true) { // Repetir o Trem inumeras vezes
      switch (cG.getEscolhaPos()) { // Pega a escolha realizada no controle
// -------------------------------------------------------------------------//
// AMBOS TRENS DO LADO ESQUERDO
        case 1:
          this.moveTremFrente(130, 0.0);
          this.moveTremBaixo(5, 90);

          // ZONA CRITICA 1
          if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
            TrilhoVazioEstAlt1();
            cG.setVisiblePare01();
            this.moveTremBaixo(40, 90);
            this.moveTremFrente(160, 0.0);
            cG.setEstritaAlt1(1);
            cG.setVisibleFALSEPare01();
          } 
          else {
            TrilhoVazioTRAVAMENTO1();
            cG.setVisiblePare01();
            this.moveTremBaixo(40, 90);
            this.moveTremFrente(160, 0.0);
            cG.setVariavelTravamento1(0);
            cG.setVisibleFALSEPare01();
          }
          // FIM ZONA CRITICA 1

          // Continuar o Percurso
          this.moveTremCima(45, -90);
          this.moveTremFrente(170, 0.0);
          this.moveTremBaixo(5, 90);

           // ZONA CRITICA 2
           if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
            TrilhoVazioEstAlt2();
            cG.setVisiblePare02();
            this.moveTremBaixo(40, 90);
            this.moveTremFrente(160, 0.0);
            cG.setEstritaAlt2(1);
            cG.setVisibleFALSEPare02();
          } 
          else {
            TrilhoVazioTRAVAMENTO2();
            cG.setVisiblePare02();
            this.moveTremBaixo(40, 90);
            this.moveTremFrente(160, 0.0);
            cG.setVariavelTravamento2(0);
            cG.setVisibleFALSEPare02();
          }
          // FIM ZONA CRITICA 2

          this.moveTremCima(45, -90);
          this.moveTremFrente(170, 0.0);
          cG.setPositionYellow(0, 142);  
          break;

// -------------------------------------------------------------------------//

// -------------------------------------------------------------------------//
// AMBO DOS LADOS DIREITO
        case 2:
        this.moveTremTras(175, 0.0);
        this.moveTremBaixo(5, -90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          cG.setEstritaAlt2(1);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremCima(45, 90);
        this.moveTremTras(170, 0.0);
        this.moveTremBaixo(5, -90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          cG.setEstritaAlt1(1);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, -90);
          this.moveTremTras(160, 0.0);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 2

        this.moveTremCima(45, 90);
        this.moveTremTras(170, 0.0);
        cG.setPositionYellow(800, 142);  
          break;
// -------------------------------------------------------------------------//

// -------------------------------------------------------------------------//
// ESQUERDO ENCIMA E DIREITO EMBAIXO
        case 3:
        this.moveTremFrente(130, 0.0);
        this.moveTremBaixo(5, 90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, 90);
          this.moveTremFrente(160, 0.0);
          this.moveTremCima(30, -90);
          cG.setEstritaAlt1(1);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremBaixo(40, 90);
          this.moveTremFrente(160, 0.0);
          this.moveTremCima(30, -90);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremCima(15, -90);
        this.moveTremFrente(170, 0.0);
        this.moveTremBaixo(5, 90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, 90);
          this.moveTremFrente(160, 0.0);
          this.moveTremCima(30, -90);
          cG.setEstritaAlt2(1);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremBaixo(40, 90);
          this.moveTremFrente(160, 0.0);
          this.moveTremCima(30, -90);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 2

        this.moveTremCima(15, -90);
        this.moveTremFrente(170, 0.0);
        cG.setPositionYellow(0, 142);  
        break;
// -------------------------------------------------------------------------//

// -------------------------------------------------------------------------//
// ESQUERDO EMBAIXO E DIREITO ENCIMA
        case 4:
        this.moveTremFrente(130, 0.0);
        this.moveTremCima(5, -90);

        // ZONA CRITICA 1
        if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt1();
          cG.setVisiblePare01();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          this.moveTremBaixo(30, 90);
          cG.setEstritaAlt1(1);
          cG.setVisibleFALSEPare01();
        } 
        else {
          TrilhoVazioTRAVAMENTO1();
          cG.setVisiblePare01();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          this.moveTremBaixo(30, 90);
          cG.setVariavelTravamento1(0);
          cG.setVisibleFALSEPare01();
        }
        // FIM ZONA CRITICA 1

        // Continuar o Percurso
        this.moveTremBaixo(15, 90);
        this.moveTremFrente(170, 0.0);
        this.moveTremCima(5, -90);

         // ZONA CRITICA 2
         if (cG.getResolucao() == 1) { // Verifica qual é o tipo de Resolucao
          TrilhoVazioEstAlt2();
          cG.setVisiblePare02();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          this.moveTremBaixo(30, 90);
          cG.setEstritaAlt2(1);
          cG.setVisibleFALSEPare02();
        } 
        else {
          TrilhoVazioTRAVAMENTO2();
          cG.setVisiblePare02();
          this.moveTremCima(40, -90);
          this.moveTremFrente(160, 0.0);
          this.moveTremBaixo(30, 90);
          cG.setVariavelTravamento2(0);
          cG.setVisibleFALSEPare02();
        }
        // FIM ZONA CRITICA 2

        this.moveTremBaixo(15, 90);
        this.moveTremFrente(170, 0.0);
        cG.setPositionYellow(0, 226);  
          break;
// -------------------------------------------------------------------------//
      } // Fim Switch
    } // Fim While
  } // Fim Run

// Metodo que move o trem para frente e rotaciona o mesmo
  public void moveTremFrente(int quantidade, double rotate) {

    if (cG.getRotation(1) != rotate) {
      cG.setRotateImg(1, rotate);
    }

    Double x = cG.getPositionX(1);
    for (int i = 0; i < quantidade; i++) {
        x += 1;
        Double finalX = x;
        Platform.runLater(() -> cG.atualizaPosicaoX(1, finalX));
        try {
            Thread.sleep(cG.getSliderYellow());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Metodo que move o trem para baixo e rotaciona o mesmo
public void moveTremBaixo(int quantidade, double rotate) {
  if (cG.getRotation(1) != rotate) {
    cG.setRotateImg(1, rotate);
  }

  Double y = cG.getPositionY(1);
  for (int i = 0; i < quantidade; i++) {
      y += 1;
      Double finalY = y;
      Platform.runLater(() -> cG.atualizaPosicaoY(1, finalY));
      try {
          Thread.sleep(cG.getSliderYellow());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}

// Metodo que move o trem para tras e rotaciona o mesmo
public void moveTremTras(int quantidade, double rotate) {
  if (cG.getRotation(1) != rotate) {
    cG.setRotateImg(1, rotate);
  }

  Double x = cG.getPositionX(1);

  for (int i = 0; i < quantidade; i++) {
      x -= 1;
      double finalX = x;
      Platform.runLater(() -> cG.atualizaPosicaoX(1, finalX));
      try {
          Thread.sleep(cG.getSliderYellow());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}

// Metodo que move o trem para cima e rotaciona o mesmo
public void moveTremCima(int quantidade, double rotate) {
  if (cG.getRotation(1) != rotate) {
    cG.setRotateImg(1, rotate);
  }

  Double y = cG.getPositionY(1);
  for (int i = 0; i < quantidade; i++) {
      y -= 1;
      Double finalY = y;
      Platform.runLater(() -> cG.atualizaPosicaoY(1, finalY));
      try {
          Thread.sleep(cG.getSliderYellow());
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}

// Metodo de Verificacao de Variavel de Travamento 01
  public void TrilhoVazioTRAVAMENTO1(){
    while(cG.getVariavelTravamento1() == 1){
      try {
        trem01.sleep(cG.getSliderYellow());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    cG.setVariavelTravamento1(1);
  }

  // Metodo de Verificacao de Variavel de Travamento 02
  public void TrilhoVazioTRAVAMENTO2(){
    while(cG.getVariavelTravamento2() == 1){
      try {
        trem01.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    cG.setVariavelTravamento2(1);
  }

  // Metodo de Verificacao de Estrita Alternancia 1
  public void TrilhoVazioEstAlt1(){
    while(cG.getEstritaAlt1() != 0){
      try {
        trem01.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  // Metodo de Verificacao de Estrita Alternancia 2
  public void TrilhoVazioEstAlt2(){
    while(cG.getEstritaAlt2() != 0){
      try {
        trem01.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}