/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

/**
 *
 * @author Usuario
 */
class StackArray<E> implements Stack<E> {
    private E[] array; // arreglo para almacenar los elementos
    private int tope;  // índice del último elemento agregado

    public StackArray(int n) {
        this.array = (E[]) new Object[n]; // crea un arreglo de objetos y lo asigna a array
        tope = -1; // inicializa el tope en -1
    }

    public void push(E x) {
        if (isFull()) {
            throw new IllegalStateException("La pila está llena");
        }
        array[++tope] = x; // incrementa el tope e inserta el elemento en esa posición
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return array[tope--]; // devuelve el elemento en la posición del tope y decrementa el tope
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return array[tope]; // devuelve el elemento en la posición del tope
    }

    public boolean isEmpty() {
        return this.tope == -1; // retorna true si el tope es -1, lo que indica que la pila está vacía
    }

    public boolean isFull() {
        return this.tope == array.length - 1; // retorna true si el tope es igual a la longitud del arreglo menos 1, lo que indica que la pila está llena
    }

    // Los elementos deben incluirse en la cadena desde el de la parte superior
    // hasta el de la parte inferior de la pila.
    public String toString() {
        StringBuilder sb = new StringBuilder(); // crea un StringBuilder para construir la cadena de salida
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]).append(i == 0 ? "" : ", "); // agrega los elementos al StringBuilder, separados por comas
        }
        return sb.toString(); // retorna la cadena de salida
    }
}