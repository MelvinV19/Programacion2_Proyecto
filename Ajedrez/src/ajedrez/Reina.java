/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Reina extends Pieza {
    String color;
    Scanner sc=new Scanner(System.in);
    
    @Override
    public String toString() {
        if(color.equals("blanco")){ 
            return "♕";
       }else{
           return"♛";
       }  
    }

    public Reina(int fila, int columna,String color) {
        super(fila, columna,color);
        this.color=color;
    }

    public Reina() {
    }
    

   

    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {
       if (this.getColor().equals("blanco")) {
            boolean mover = false;
            do {
                System.out.println("Ingrese fila donde desea moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde desea moverse");
                int n_columna = sc.nextInt();
                if (n_fila == fila || n_columna == columna) {
                    if (n_fila == fila) {
                        if (n_columna > columna) {
                            for (int i = columna + 1; i <= n_columna; i++) {
                                if (tablero[fila][i] instanceof Pieza) {
                                    if (tablero[fila][i].getColor().equals("blanco")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[fila][i].getColor().equals("negro")) {
                                        tablero[fila][i] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    columna++;
                                    mover = true;
                                }

                            }
                        }
                        if (n_columna < columna) {
                            for (int i = columna - 1; i >= n_columna; i--) {
                                if (tablero[fila][i] instanceof Pieza) {
                                    if (tablero[fila][i].getColor().equals("blanco")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[fila][i].getColor().equals("negro")) {
                                        tablero[fila][i] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    columna--;
                                    mover = true;
                                }

                            }
                        }
                    }
                    if (n_columna == columna) {
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if(tablero[i][columna].getColor().equals("blanco")){
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if(tablero[i][columna].getColor().equals("negro")){
                                        tablero[i][columna]=tablero[fila][columna];
                                        tablero[fila][columna]=null;
                                        fila++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    fila++;
                                    mover = true;
                                }
                            }

                        }
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if(tablero[i][columna].getColor().equals("blanco")){
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if(tablero[i][columna].getColor().equals("negro")){
                                        tablero[i][columna]=tablero[fila][columna];
                                        tablero[fila][columna]=null;
                                        fila--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    fila--;
                                    mover = true;
                                }
                            }

                        }
                    }

                }
                if (Math.abs(fila - n_fila) == Math.abs(columna - n_columna)) {
                    int cont2=0;
                    if (n_columna > columna) {
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna +1 ; j <= n_columna; j++) {
                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila--;
                                            columna++;
                                            mover = true;
                                            cont2++;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila--;
                                        columna++;
                                        mover = true;
                                        break;
                                    }

                                }
                            }

                        }
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna + 1; j <= n_columna; j++) {

                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila++;
                                            columna++;
                                            cont2++;
                                            mover = true;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila++;
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                            }
                        }

                    }
                    if (n_columna < columna) {
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna -1 ; j >= n_columna; j--) {
                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila++;
                                            columna--;
                                            mover = true;
                                            cont2++;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila++;
                                        columna--;
                                        mover = true;
                                        break;
                                    }

                                }
                            }
                        }
                        if (n_fila < fila) {
                           for (int i = fila - 1; i >= n_fila; i--) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna - 1; j >= n_columna; j--) {

                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila--;
                                            columna--;
                                            cont2++;
                                            mover = true;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila--;
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                            } 
                        }
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
                    while (tablero[fila][columna] instanceof Pieza && tablero[fila][columna].getColor().equals("negro")) {
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
                System.out.println("Ingrese fila donde desea moverse");
                int n_fila = sc.nextInt();
                System.out.println("Ingrese columna donde desea moverse");
                int n_columna = sc.nextInt();
                if (n_fila == fila || n_columna == columna) {
                    if (n_fila == fila) {
                        if (n_columna > columna) {
                            for (int i = columna + 1; i <= n_columna; i++) {
                                if (tablero[fila][i] instanceof Pieza) {
                                    if (tablero[fila][i].getColor().equals("negro")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[fila][i].getColor().equals("blanco")) {
                                        tablero[fila][i] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    columna++;
                                    mover = true;
                                }

                            }
                        }
                        if (n_columna < columna) {
                            for (int i = columna - 1; i >= n_columna; i--) {
                                if (tablero[fila][i] instanceof Pieza) {
                                    if (tablero[fila][i].getColor().equals("negro")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[fila][i].getColor().equals("blanco")) {
                                        tablero[fila][i] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    columna--;
                                    mover = true;
                                }

                            }
                        }
                    }
                    if (n_columna == columna) {
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if(tablero[i][columna].getColor().equals("negro")){
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if(tablero[i][columna].getColor().equals("blanco")){
                                        tablero[i][columna]=tablero[fila][columna];
                                        tablero[fila][columna]=null;
                                        fila++;
                                        mover=true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    fila++;
                                    mover = true;
                                }
                            }

                        }
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if(tablero[i][columna].getColor().equals("negro")){
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if(tablero[i][columna].getColor().equals("blanco")){
                                        tablero[i][columna]=tablero[fila][columna];
                                        tablero[fila][columna]=null;
                                        fila--;
                                        mover=true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    fila--;
                                    mover = true;
                                }
                            }

                        }
                    }
                }
                if (Math.abs(fila - n_fila) == Math.abs(columna - n_columna)) {
                    int cont2=0;
                    if (n_columna > columna) {
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna +1 ; j <= n_columna; j++) {
                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila--;
                                            columna++;
                                            mover = true;
                                            cont2++;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila--;
                                        columna++;
                                        mover = true;
                                        break;
                                    }

                                }
                            }

                        }
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna + 1; j <= n_columna; j++) {

                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila++;
                                            columna++;
                                            cont2++;
                                            mover = true;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila++;
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                            }
                        }

                    }
                    if (n_columna < columna) {
                        if (n_fila > fila) {
                            for (int i = fila + 1; i <= n_fila; i++) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna -1 ; j >= n_columna; j--) {
                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila++;
                                            columna--;
                                            mover = true;
                                            cont2++;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila++;
                                        columna--;
                                        mover = true;
                                        break;
                                    }

                                }
                            }
                        }
                        if (n_fila < fila) {
                           for (int i = fila - 1; i >= n_fila; i--) {
                                
                                if (cont2 > 0) {
                                    break;
                                }
                                for (int j = columna - 1; j >= n_columna; j--) {

                                    if (tablero[i][j] instanceof Pieza) {
                                        if (tablero[i][j].getColor().equals("negro")) {
                                            System.out.println("Hay algo bloqueando el camino");
                                            cont2++;
                                            break;
                                        }
                                        if (tablero[i][j].getColor().equals("blanco")) {
                                            tablero[i][j] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            fila--;
                                            columna--;
                                            cont2++;
                                            mover = true;
                                            break;
                                        }
                                    }
                                    if (tablero[i][j] == null) {
                                        tablero[i][j] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        fila--;
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                            } 
                        }
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
                    while (tablero[fila][columna] instanceof Pieza && tablero[fila][columna].getColor().equals("blanco")) {
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
    public boolean validacion(Pieza[][]tablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
