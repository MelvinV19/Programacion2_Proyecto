
package ajedrez;

public abstract class Pieza {
    int fila;
    int columna;
    String color;
    public Pieza(int fila, int columna,String color) {
        this.fila = fila;
        this.columna = columna;
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Pieza() {
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public abstract Pieza[][] movimiento(Pieza [][]tablero);
    
    public abstract boolean validacion(Pieza[][]tablero);
        
    
}
