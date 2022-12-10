/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.PrintStream;

/**
 *
 * @author pablo
 */
public class arbolbin {

    private NodoCadena raiz;

    public arbolbin() {

    }

    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(NodoCadena n, String busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(String dato, String g) {
        if (this.raiz == null) {
            this.raiz = new NodoCadena(dato, g);
        } else {
            this.insertar(this.raiz, dato, g);
        }
    }

    private void insertar(NodoCadena padre, String dato, String g) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new NodoCadena(dato, g));
            } else {
                this.insertar(padre.getDerecha(), dato, g);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new NodoCadena(dato, g));
            } else {
                this.insertar(padre.getIzquierda(), dato, g);
            }
        }

    }

    private void preorden(NodoCadena n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(NodoCadena n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(NodoCadena n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    private void BMujeres(NodoCadena n) {

        if (n != null) {
            if (n.getGenero().equals("F")) {
                n.imprimirDato();
            }
            BMujeres(n.getIzquierda());
            BMujeres(n.getDerecha());
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }

    public void BMujeres() {
        this.BMujeres(this.raiz);
    }
}
