package ajedrez;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ajedrez {

    static Pieza tablero[][] = new Pieza[8][8];
    static Scanner sc = new Scanner(System.in);
    static int fila;
    static int columna;
    static String color;

    public static void main(String[] args) {
        tablero = llenar(tablero);
        imprimir(tablero, 0, 0);
        jugar(tablero);
    }

    public static void jugar(Pieza[][] tablero) {
        boolean ganador = false;
        boolean turno = false;
    try{    
        do {
            if (turno == false) {

                System.out.println("Turno de las piezas blancas");
                System.out.println("Ingrese fila de la pieza blanca: ");
                fila = sc.nextInt();
                System.out.println("Ingrese columna de la pieza blanca: ");
                columna = sc.nextInt();
                while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                    System.out.println("No puede poner numeros mas grandes que el tablero");
                    System.out.println("Turno de las piezas blancas");
                    System.out.println("Ingrese fila de la pieza blanca: ");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de la pieza blanca: ");
                    columna = sc.nextInt();
                }
                while (tablero[fila][columna] == null) {
                    System.out.println("Aqui no hay ninguna pieza");
                    System.out.println("Ingrese fila de pieza blanca");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de pieza blanca");
                    columna = sc.nextInt();
                }
                if (tablero[fila][columna].getColor().equals("blanco")) {
                    tablero = tablero[fila][columna].movimiento(tablero);
                    imprimir(tablero, 0, 0);
                    turno = true;
                } else {
                    System.out.println("Esta no es una pieza blanca");
                }
            } else {
                System.out.println("Turno de las piezas negras");
                System.out.println("Ingrese fila de la pieza negra: ");
                fila = sc.nextInt();

        System.out.println("Ingrese columna de la pieza negra: ");
                columna = sc.nextInt();

                while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                    System.out.println("No puede poner numeros mas grandes que el tablero");
                    System.out.println("Turno de las piezas negras");
                    System.out.println("Ingrese fila de la pieza negras: ");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de la pieza negras: ");
                    columna = sc.nextInt();
                }
                while (tablero[fila][columna] == null) {
                    System.out.println("Aqui no hay ninguna pieza");
                    System.out.println("Ingrese fila de pieza blanca");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de pieza blanca");
                    columna = sc.nextInt();
                }
                if (tablero[fila][columna].getColor().equals("negro")) {
                    tablero = tablero[fila][columna].movimiento(tablero);
                    imprimir(tablero, 0, 0);
                    turno = false;
                } else {
                    System.out.println("Esta no es una pieza negra");
                    
                }
            }
        } while (ganador(tablero) == false);
    }catch(InputMismatchException e){
        e.getMessage();
    } 
    }

    public static Pieza[][] llenar(Pieza[][] tablero) {

        /*String reyb="♔";
      String reinab="♕";
      String torreb="♖";
      String alfilb="♗";
      String caballob="♘";
      String peonb="♙";
      String reyn="♚";
      String reinan="♛";
      String torren="♜";
      String alfiln="♝";
      String caballon="♞";
      String peonn="♟";
         */
        tablero[0][0] = new Torre(0, 0, "negro");
        tablero[0][1] = new Caballo(0, 1, "negro");
        tablero[0][2] = new Alfil(0, 2, "negro");
        tablero[0][3] = new Reina(0, 3, "negro");
        tablero[0][4] = new Rey(0, 4, "negro");
        tablero[0][5] = new Alfil(0, 5, "negro");
        tablero[0][6] = new Caballo(0, 6, "negro");
        tablero[0][7] = new Torre(0, 7, "negro");
        tablero[1][0] = new Peon("negro", 1, 0);
        tablero[1][1] = new Peon("negro", 1, 1);
        tablero[1][2] = new Peon("negro", 1, 2);
        tablero[1][3] = new Peon("negro", 1, 3);
        tablero[1][4] = new Peon("negro", 1, 4);
        tablero[1][5] = new Peon("negro", 1, 5);
        tablero[1][6] = new Peon("negro", 1, 6);
        tablero[1][7] = new Peon("negro", 1, 7);
        tablero[6][0] = new Peon("blanco", 6, 0);
        tablero[6][1] = new Peon("blanco", 6, 1);
        tablero[6][2] = new Peon("blanco", 6, 2);
        tablero[6][3] = new Peon("blanco", 6, 3);
        tablero[6][4] = new Peon("blanco", 6, 4);
        tablero[6][5] = new Peon("blanco", 6, 5);
        tablero[6][6] = new Peon("blanco", 6, 6);
        tablero[6][7] = new Peon("blanco", 6, 7);
        tablero[7][0] = new Torre(7, 0, "blanco");
        tablero[7][1] = new Caballo(7, 1, "blanco");
        tablero[7][2] = new Alfil(7, 2, "blanco");
        tablero[7][3] = new Reina(7, 3, "blanco");
        tablero[7][4] = new Rey(7, 4, "blanco");
        tablero[7][5] = new Alfil(7, 5, "blanco");
        tablero[7][6] = new Caballo(7, 6, "blanco");
        tablero[7][7] = new Torre(7, 7, "blanco");

        return tablero;
    }

    public static void imprimir(Pieza[][] tablero, int i, int j) {

        if (i < tablero.length && j < tablero[0].length) {
            if (tablero[i][j] == null) {
                System.out.print(" ☐ ");
            } else {
                System.out.print(" " + tablero[i][j] + " ");
            }

            if (j == tablero[0].length - 1) {
                System.out.print(i);
                i++;
                j = 0;
                System.out.println("");
            } else {
                j++;
            }
            imprimir(tablero, i, j);
        }
    }
    public static boolean ganador(Pieza[][]tablero){
        boolean gano=false;
        int conta=0;
        int contb=0;
        for (int i = 0; i <tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                   if(tablero[i][j] instanceof Pieza){
                       if(tablero[i][j]instanceof Rey&&tablero[i][j].getColor().equals("blanco")){
                           conta++;
                       }
                       if(tablero[i][j] instanceof Rey&&tablero[i][j].getColor().equals("negro")){
                           contb++;
                       }
                   }
                   
            }
            
        }
        if(contb==0&&conta==1){
                System.out.println("Ganaron las piezas blancas");
                gano=true;
            }
            if(conta==0&&contb==1){
                System.out.println("Ganaron las piezas negras");
                gano=true;
            }
        return gano;
    }

}
