package ajedrez;

import java.util.Scanner;

public class Torre extends Pieza {

    String color;
    int contcortob = 0;
    int contlargob = 0;
    int contcorton = 0;
    int contlargon = 0;
    Scanner sc = new Scanner(System.in);

    public int getContcortob() {
        return contcortob;
    }

    public void setContcortob(int contcortob) {
        this.contcortob = contcortob;
    }

    public int getContlargob() {
        return contlargob;
    }

    public void setContlargob(int contlargob) {
        this.contlargob = contlargob;
    }

    public int getContcorton() {
        return contcorton;
    }

    public void setContcorton(int contcorton) {
        this.contcorton = contcorton;
    }

    public int getContlargon() {
        return contlargon;
    }

    public void setContlargon(int contlargon) {
        this.contlargon = contlargon;
    }

    public Torre(int fila, int columna, String color) {
        super(fila, columna, color);
        this.color = color;
    }

    public Torre() {
    }

    @Override
    public String toString() {
        if (color.equals("blanco")) {
            return "♖";
        } else {
            return "♜";
        }
    }

    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {
        if (this.getColor().equals("blanco")) {
            boolean mover = false;
            do {
                if (enroqueb(tablero) == 1 ) {
                    mover = true;
                    break;
                }
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
                                        if (columna == 0) {
                                            contlargob++;
                                        }
                                        if (columna == 7) {
                                            contcortob++;
                                        }
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargob++;
                                    }
                                    if (columna == 7) {
                                        contcortob++;
                                    }
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
                                        if (columna == 0) {
                                            contlargob++;
                                        }
                                        if (columna == 7) {
                                            contcortob++;
                                        }
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargob++;
                                    }
                                    if (columna == 7) {
                                        contcortob++;
                                    }
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
                                    if (tablero[i][columna].getColor().equals("blanco")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[i][columna].getColor().equals("negro")) {
                                        tablero[i][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        if (columna == 0) {
                                            contlargob++;
                                        }
                                        if (columna == 7) {
                                            contcortob++;
                                        }
                                        fila++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargob++;
                                    }
                                    if (columna == 7) {
                                        contcortob++;
                                    }
                                    fila++;
                                    mover = true;
                                }
                            }

                        }
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if (tablero[i][columna].getColor().equals("blanco")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[i][columna].getColor().equals("negro")) {
                                        tablero[i][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        if (columna == 0) {
                                            contlargob++;
                                        }
                                        if (columna == 7) {
                                            contcortob++;
                                        }
                                        fila--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargob++;
                                    }
                                    if (columna == 7) {
                                        contcortob++;
                                    }
                                    fila--;
                                    mover = true;
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
                if (enroquen(tablero) == 1 || enroquen(tablero) == 2) {
                    mover = true;
                    break;
                }
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
                                        if (columna == 0) {
                                            contlargon++;
                                        }
                                        if (columna == 7) {
                                            contcorton++;
                                        }
                                        columna++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargon++;
                                    }
                                    if (columna == 7) {
                                        contcorton++;
                                    }
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
                                        if (columna == 0) {
                                            contlargon++;
                                        }
                                        if (columna == 7) {
                                            contcorton++;
                                        }
                                        columna--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[fila][i] == null) {
                                    tablero[fila][i] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargon++;
                                    }
                                    if (columna == 7) {
                                        contcorton++;
                                    }
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
                                    if (tablero[i][columna].getColor().equals("negro")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[i][columna].getColor().equals("blanco")) {
                                        tablero[i][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        if (columna == 0) {
                                            contlargon++;
                                        }
                                        if (columna == 7) {
                                            contcorton++;
                                        }
                                        fila++;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargon++;
                                    }
                                    if (columna == 7) {
                                        contcorton++;
                                    }
                                    fila++;
                                    mover = true;
                                }
                            }

                        }
                        if (n_fila < fila) {
                            for (int i = fila - 1; i >= n_fila; i--) {
                                if (tablero[i][columna] instanceof Pieza) {
                                    if (tablero[i][columna].getColor().equals("negro")) {
                                        System.out.println("Hay algo bloqueando el camino");
                                        break;
                                    }
                                    if (tablero[i][columna].getColor().equals("blanco")) {
                                        tablero[i][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        if (columna == 0) {
                                            contlargon++;
                                        }
                                        if (columna == 7) {
                                            contcorton++;
                                        }
                                        fila--;
                                        mover = true;
                                        break;
                                    }
                                }
                                if (tablero[i][columna] == null) {
                                    tablero[i][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    if (columna == 0) {
                                        contlargon++;
                                    }
                                    if (columna == 7) {
                                        contcorton++;
                                    }
                                    fila--;
                                    mover = true;
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

    public int enroqueb(Pieza[][] tablero) {
        int op = 0;
        if (contlargob == 0) {
            if (columna==0&&tablero[7][1] == null && tablero[7][2] == null && tablero[7][3] == null && tablero[7][4] instanceof Rey) {
                System.out.println("Posibilidad de enroque largo");
                System.out.println("1. para realizar el enroque largo");
                System.out.println("Ingrese cualquier otro numero para no hacer el enroque");
                op = sc.nextInt();
                if (op == 1) {
                    tablero[7][2] =  new Rey(7,2,"blanco");
                    tablero[7][4] = null;
                    tablero[7][3] = new Torre(7,3,"blanco");
                    tablero[7][0] = null;
                }
                
            }
        }
        if (contcortob == 0) {
            if (columna==7&&tablero[7][6] == null && tablero[7][5] == null && tablero[7][4] instanceof Rey) {
                System.out.println("Posibilidad de enroque corto");
                System.out.println("1.para realizar el enroque corto");
                System.out.println("Ingrese cualquier otro numero para no hacer el enroque");
                op = sc.nextInt();
                if (op == 1) {
                    tablero[7][6] = new Rey(7,6,"blanco");
                    tablero[7][4] = null;
                    tablero[7][5] = new Torre(7,5,"blanco");
                    tablero[7][7] = null;
                }
                
            }
        }
        

        return op;
    }
    public int enroquen(Pieza[][] tablero) {
        int op = 0;
        if (contlargon == 0) {
            if (columna==0&&tablero[0][1] == null && tablero[0][2] == null && tablero[0][3] == null && tablero[0][4] instanceof Rey) {
                System.out.println("Posibilidad de enroque largo");
                System.out.println("1. para realizar el enroque largo");
                System.out.println("Ingrese cualquier otro numero para no hacer el enroque");
                op = sc.nextInt();
                if (op == 1) {
                    tablero[0][2] = new Rey(0,2,"negro");
                    tablero[0][4] = null;
                    tablero[0][3] = new Torre(0,3,"negro");
                    tablero[0][0] = null;
                   
                }
                
            }
        }
        if (contcorton == 0) {
            if (columna==7&&tablero[0][6] == null && tablero[0][5] == null && tablero[0][4] instanceof Rey) {
                System.out.println("Posibilidad de enroque corto");
                System.out.println("1.para realizar el enroque corto");
                System.out.println("Ingrese cualquier otro numero para no hacer el enroque");
                op = sc.nextInt();
                if (op == 1) {
                    tablero[0][6] = new Rey(0,6,"negro");
                    tablero[0][4] = null;
                    tablero[0][5] = new Torre(0,5,"negro");
                    tablero[0][7] = null;
                }
                
            }
        }
        

        return op;
    }

    @Override
    public boolean validacion(Pieza[][] tablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
