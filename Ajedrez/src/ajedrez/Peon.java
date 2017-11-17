/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Color;
import java.util.Scanner;

public class Peon extends Pieza {

    String color;
    Scanner sc = new Scanner(System.in);

    public Peon(String color, int fila, int columna) {
        super(fila, columna, color);
        this.color = color;
    }

    @Override
    public String toString() {
        if (color.equals("blanco")) {
            return "♙";
        } else {
            return "♟";
        }
    }

    @Override
    public Pieza[][] movimiento(Pieza[][] tablero) {
        if (this.getColor().equals("blanco")) {
            boolean mover = false;
            do {
                if (fila == 6) {
                    if (columna != 0 && columna != 7) {
                        if (tablero[fila - 1][columna + 1] instanceof Pieza && tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro") && tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("4. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");
                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                                if (op == 4) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                            }
                        } else if (tablero[fila - 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                            }
                        } else if (tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                            }
                        } else if (tablero[fila - 1][columna - 1] == null && tablero[fila - 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila - 2][columna] != null) {
                                    if (tablero[fila - 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");
                                    }

                                } else if (tablero[fila - 1][columna] != null) {
                                    System.out.println("Esta pieza no se puede mover");
                                } else {
                                    tablero[fila - 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 2;
                                }

                            }
                        }
                    }
                    if (columna == 0) {
                        if (tablero[fila - 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } 
                        }
                        if (tablero[fila - 1][columna + 1] == null||(tablero[fila-1][columna+1] instanceof Pieza&&tablero[fila-1][columna+1].getColor().equals("blanco"))) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila - 2][columna] != null) {
                                    if (tablero[fila - 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");
                                    }

                                } else if (tablero[fila - 1][columna] != null) {
                                    System.out.println("Esta pieza no se puede mover");
                                } else {
                                    tablero[fila - 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 2;
                                }

                            }
                        }

                    }
                    if (columna == 7) {
                        if (tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila - 2][columna] != null) {
                                        if (tablero[fila - 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila - 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila -= 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");
                                        }

                                    } else if (tablero[fila - 1][columna] != null) {
                                        System.out.println("Esta pieza no se puede mover");
                                    } else {
                                        tablero[fila - 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } 
                        }if (tablero[fila - 1][columna - 1] == null||(tablero[fila-1][columna-1] instanceof Pieza&&tablero[fila-1][columna-1].getColor().equals("blanco"))) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila - 2][columna] != null) {
                                    if (tablero[fila - 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");
                                    }

                                } else if (tablero[fila - 1][columna] != null) {
                                    System.out.println("Esta pieza no se puede mover");
                                } else {
                                    tablero[fila - 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 2;
                                }

                            }
                        }
                    }
                } else {
                    if (columna != 0 && columna != 7) {
                        if (tablero[fila - 1][columna + 1] instanceof Pieza && tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro") && tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                                if (op == 3) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                            }
                        } else if (tablero[fila - 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                            }
                        } else if (tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }
                                if (op == 2) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                            }
                        } else if (tablero[fila - 1][columna - 1] == null && tablero[fila - 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }

                        }

                    }
                    if (columna == 0) {
                        if (tablero[fila - 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna + 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila - 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                            }
                        }
                        if (tablero[fila - 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }

                        }

                    }
                    if (columna == 7) {
                        if (tablero[fila - 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila - 1][columna - 1].getColor().equals("negro")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila - 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[0][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♕");
                                            System.out.println("2.Torre ♖");
                                            System.out.println("3.Alfil ♗");
                                            System.out.println("4.Caballo ♘");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[0][i] = new Reina(0, i, "blanco");
                                            }
                                            if (prom == 2) {
                                                tablero[0][i] = new Torre(0, i, "blanco");
                                            }
                                            if (prom == 3) {
                                                tablero[0][i] = new Alfil(0, i, "blanco");
                                            }
                                            if (prom == 4) {
                                                tablero[0][i] = new Caballo(0, i, "blanco");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila - 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila - 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila -= 1;
                                    }
                                }

                            }
                        } else if (tablero[fila - 1][columna - 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila - 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila - 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila -= 1;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < tablero.length; i++) {
                    if (tablero[0][i] instanceof Peon) {
                        System.out.println("Promocion!");
                        System.out.println("1.Reina ♕");
                        System.out.println("2.Torre ♖");
                        System.out.println("3.Alfil ♗");
                        System.out.println("4.Caballo ♘");
                        System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                        int prom = sc.nextInt();
                        if (prom == 1) {
                            tablero[0][i] = new Reina(0, i, "blanco");
                        }
                        if (prom == 2) {
                            tablero[0][i] = new Torre(0, i, "blanco");
                        }
                        if (prom == 3) {
                            tablero[0][i] = new Alfil(0, i, "blanco");
                        }
                        if (prom == 4) {
                            tablero[0][i] = new Caballo(0, i, "blanco");
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

        //empiezan los movimientos de las piezas negras
        if (this.getColor().equals("negro")) {
            boolean mover = false;
            do {
                if (fila == 1) {
                    if (columna != 0 && columna != 7) {
                        if (tablero[fila + 1][columna + 1] instanceof Pieza && tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco") && tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("4. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                                if (op == 4) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                            }
                        } else if (tablero[fila + 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                            }
                        } else if (tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                            }
                        } else if (tablero[fila + 1][columna - 1] == null || tablero[fila + 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila + 2][columna] != null) {
                                    if (tablero[fila + 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");

                                    }

                                } else {
                                    tablero[fila + 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 2;
                                }

                            }
                        }
                    }
                    if (columna == 0) {
                        if (tablero[fila + 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } 
                        }
                        if (tablero[fila + 1][columna + 1] == null||(tablero[fila+1][columna+1] instanceof Pieza&&tablero[fila+1][columna+1].getColor().equals("negro"))) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila + 2][columna] != null) {
                                    if (tablero[fila + 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");

                                    }

                                } else {
                                    tablero[fila + 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 2;
                                }

                            }
                        }
                    }
                    if (columna == 7) {
                        if (tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. 2 espacios");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    if (tablero[fila + 2][columna] != null) {
                                        if (tablero[fila + 1][columna] == null) {
                                            System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                            tablero[fila + 1][columna] = tablero[fila][columna];
                                            tablero[fila][columna] = null;
                                            mover = true;
                                            fila += 1;
                                        } else {
                                            System.out.println("esta pieza no se pude mover");

                                        }

                                    } else {
                                        tablero[fila + 2][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 2;
                                    }

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } 
                        }
                        if (tablero[fila + 1][columna - 1] == null||(tablero[fila+1][columna-1] instanceof Pieza&&tablero[fila+1][columna-1].getColor().equals("negro"))) {
                            System.out.println("1. 1 espacio");
                            System.out.println("2. 2 espacios");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }
                            if (op == 2) {
                                if (tablero[fila + 2][columna] != null) {
                                    if (tablero[fila + 1][columna] == null) {
                                        System.out.println("No se pudo mover 2 espacios,el peon se movera automaticamente 1 atras");
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    } else {
                                        System.out.println("esta pieza no se pude mover");

                                    }

                                } else {
                                    tablero[fila + 2][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 2;
                                }

                            }
                        }
                    }
                } else {
                    if (columna != 0 && columna != 7) {
                        if (tablero[fila + 1][columna + 1] instanceof Pieza && tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco") && tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("3. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                                if (op == 3) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                            }
                        } else if (tablero[fila + 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                            }
                        } else if (tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }
                                if (op == 2) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                            }
                        } else if (tablero[fila + 1][columna - 1] == null || tablero[fila + 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }

                        }

                    }
                    if (columna == 0) {
                        if (tablero[fila + 1][columna + 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna + 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");
                                System.out.println("2. comer diagonalmente a la derecha");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila + 1][columna + 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna += 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                            }
                        } else if (tablero[fila + 1][columna + 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }

                        }
                    }
                    if (columna == 7) {
                        if (tablero[fila + 1][columna - 1] instanceof Pieza) {
                            if (tablero[fila + 1][columna - 1].getColor().equals("blanco")) {
                                System.out.println("1. 1 espacio");

                                System.out.println("2. comer diagonalmente a la izquierda");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                                if (op == 2) {
                                    tablero[fila + 1][columna - 1] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                    columna -= 1;
                                    for (int i = 0; i < tablero.length; i++) {
                                        if (tablero[7][i] instanceof Peon) {
                                            System.out.println("Promocion!");
                                            System.out.println("1.Reina ♛");
                                            System.out.println("2.Torre ♜");
                                            System.out.println("3.Alfil ♝");
                                            System.out.println("4.Caballo ♞");
                                            System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                                            int prom = sc.nextInt();
                                            if (prom == 1) {
                                                tablero[7][i] = new Reina(7, i, "negro");
                                            }
                                            if (prom == 2) {
                                                tablero[7][i] = new Torre(7, i, "negro");
                                            }
                                            if (prom == 3) {
                                                tablero[7][i] = new Alfil(7, i, "negro");
                                            }
                                            if (prom == 4) {
                                                tablero[7][i] = new Caballo(7, i, "negro");
                                            }
                                        }
                                    }
                                    break;

                                }
                            } else {
                                System.out.println("1. 1 espacio");
                                System.out.println("Ingrese numero de movimiento que desea realizar");
                                int op = sc.nextInt();
                                if (op == 1) {
                                    if (tablero[fila + 1][columna] != null) {
                                        System.out.println("esta pieza no se pude mover");

                                    } else {
                                        tablero[fila + 1][columna] = tablero[fila][columna];
                                        tablero[fila][columna] = null;
                                        mover = true;
                                        fila += 1;
                                    }
                                }

                            }
                        }
                        if (tablero[fila + 1][columna - 1] == null) {
                            System.out.println("1. 1 espacio");
                            System.out.println("Ingrese numero de movimiento que desea realizar");
                            int op = sc.nextInt();
                            if (op == 1) {
                                if (tablero[fila + 1][columna] != null) {
                                    System.out.println("esta pieza no se pude mover");

                                } else {
                                    tablero[fila + 1][columna] = tablero[fila][columna];
                                    tablero[fila][columna] = null;
                                    mover = true;
                                    fila += 1;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < tablero.length; i++) {
                    if (tablero[7][i] instanceof Peon) {
                        System.out.println("Promocion!");
                        System.out.println("1.Reina ♛");
                        System.out.println("2.Torre ♜");
                        System.out.println("3.Alfil ♝");
                        System.out.println("4.Caballo ♞");
                        System.out.println("Ingrese numero de opcion a la que desea promover el peon");
                        int prom = sc.nextInt();
                        if (prom == 1) {
                            tablero[7][i] = new Reina(7, i, "negro");
                        }
                        if (prom == 2) {
                            tablero[7][i] = new Torre(7, i, "negro");
                        }
                        if (prom == 3) {
                            tablero[7][i] = new Alfil(7, i, "negro");
                        }
                        if (prom == 4) {
                            tablero[7][i] = new Caballo(7, i, "negro");
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
    public boolean validacion(Pieza[][] tablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
