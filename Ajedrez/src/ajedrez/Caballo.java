package ajedrez;

import java.util.Scanner;

public class Caballo extends Pieza {

    String color;
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        if (color.equals("blanco")) {
            return "♘";
        } else {
            return "♞";
        }
    }

    public Caballo(int fila, int columna, String color) {
        super(fila, columna, color);
        this.color = color;
    }

    public Caballo() {
    }

    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {

        if (this.getColor().equals("blanco")) {
            boolean mover = false;
            do {
                System.out.println("Ingrese fila donde quiere moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde quiere moverse");
                int n_columna = sc.nextInt();
                if (n_fila > tablero.length - 1 || n_columna > tablero.length - 1) {
                    System.out.println("No puede poner numeros mas grandes que el tablero");
                    System.out.println("");
                }
                if (((n_columna - columna == 2 || n_columna - columna == -2) && (n_fila - fila == 1 || n_fila - fila == -1)) || ((n_columna - columna == 1 || n_columna - columna == -1) && (n_fila - fila == 2 || n_fila - fila == -2))) {
                    if (tablero[n_fila][n_columna] instanceof Pieza) {
                        if (tablero[n_fila][n_columna].getColor().equals("blanco")) {
                            System.out.println("No puede moverse aqui");
                            System.out.println("");

                        } else {
                            tablero[n_fila][n_columna] = tablero[fila][columna];
                            tablero[fila][columna] = null;
                            mover = true;
                            fila = n_fila;
                            columna = n_columna;
                        }

                    } else {
                        tablero[n_fila][n_columna] = tablero[fila][columna];
                        tablero[fila][columna] = null;
                        mover = true;
                        fila = n_fila;
                        columna = n_columna;
                    }
                }
                if (mover == false) {
                    System.out.println("No se pudo mover");
                    System.out.println("Ingrese fila de otra pieza");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de otra pieza");
                    columna = sc.nextInt();
                    System.out.println("");
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Turno de las piezas blancas");
                        System.out.println("Ingrese fila de la pieza blanca: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de la pieza blanca: ");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila de pieza blanca");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de pieza blanca");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while(tablero[fila][columna] instanceof Pieza&&tablero[fila][columna].getColor().equals("negro")){
                        System.out.println("Esto no es una pieza blanca");
                        System.out.println("Ingrese fila de pieza blanca");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de pieza blanca");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    tablero = tablero[fila][columna].movimiento(tablero);
                    mover = true;

                }
            } while (mover == false);
        }
        if (this.getColor().equals("negro")) {
            boolean mover = false;
            do {
                System.out.println("Ingrese fila donde quiere moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde quiere moverse");
                int n_columna = sc.nextInt();
                if (n_fila > tablero.length - 1 || n_columna > tablero.length - 1) {
                    System.out.println("No puede poner numeros mas grandes que el tablero");
                    System.out.println("");
                }
                if (((n_columna - columna == 2 || n_columna - columna == -2) && (n_fila - fila == 1 || n_fila - fila == -1)) || ((n_columna - columna == 1 || n_columna - columna == -1) && (n_fila - fila == 2 || n_fila - fila == -2))) {
                    if (tablero[n_fila][n_columna] instanceof Pieza) {
                        if (tablero[n_fila][n_columna].getColor().equals("negro")) {
                            System.out.println("No puede moverse aqui");
                            System.out.println("");
                        } else {
                            tablero[n_fila][n_columna] = tablero[fila][columna];
                            tablero[fila][columna] = null;
                            mover = true;
                            fila = n_fila;
                            columna = n_columna;
                        }

                    } else {
                        tablero[n_fila][n_columna] = tablero[fila][columna];
                        tablero[fila][columna] = null;
                        mover = true;
                        fila = n_fila;
                        columna = n_columna;
                    }
                }
                if (mover == false) {
                    System.out.println("No se pudo mover");
                    System.out.println("Ingrese fila de otra pieza");
                    fila = sc.nextInt();
                    System.out.println("Ingrese columna de otra pieza");
                    columna = sc.nextInt();
                    System.out.println("");
                    while (fila > tablero.length - 1 || columna > tablero.length - 1) {
                        System.out.println("No puede poner numeros mas grandes que el tablero");
                        System.out.println("Ingrese fila de la pieza negra: ");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de la pieza negra: ");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while (tablero[fila][columna] == null) {
                        System.out.println("Aqui no hay ninguna pieza");
                        System.out.println("Ingrese fila de pieza negra");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de pieza negra");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    while(tablero[fila][columna] instanceof Pieza&&tablero[fila][columna].getColor().equals("blanco")){
                        System.out.println("Esto no es una pieza negra");
                        System.out.println("Ingrese fila de pieza negra");
                        fila = sc.nextInt();
                        System.out.println("Ingrese columna de pieza negra");
                        columna = sc.nextInt();
                        System.out.println("");
                    }
                    tablero = tablero[fila][columna].movimiento(tablero);
                    mover = true;

                }
            } while (mover == false);

        }
        return tablero;
    }

    @Override
    public boolean validacion(Pieza[][] tablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
