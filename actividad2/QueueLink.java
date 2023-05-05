/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2;

import actividad1.ExceptionIsEmpty;

/**
 *
 * @author Usuario
 */
class QueueLink<E> implements Queue<E> {
    private Node<E> first; 
    private Node<E> last; 

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x); 
        if (this.isEmpty()) {
            this.first = aux; // si la cola está vacía, el nuevo nodo será el primer elemento
        } else {
            this.last.setNext(aux); // de lo contrario, el último nodo apunta al nuevo nodo
        }
        this.last = aux; // el nuevo nodo se convierte en el último nodo
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = first.getData(); // almacena el dato del primer nodo
        first = first.getNext(); // mueve el primer nodo al siguiente en la cola
        if (first == null) {
            last = null; // si la cola queda vacía, last también se establece en null
        }
        return data; // retorna el dato extraído
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return first.getData(); // devuelve el dato del primer nodo
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return last.getData(); // devuelve el dato del último nodo
    }

    public boolean isEmpty() {
        return first == null; // retorna true si el primer nodo es null, lo que indica que la cola está vacía
    }


    public String toString() {
        StringBuilder sb = new StringBuilder(); // crea un StringBuilder para construir la cadena de salida
        Node<E> current = first;
        while (current != null) {
            sb.append(current.getData()); // agrega el dato del nodo actual al StringBuilder
            if (current.getNext() != null) {
                sb.append(", "); // agrega una coma si hay un siguiente nodo
            }
            current = current.getNext(); // avanza al siguiente nodo
        }
        return sb.toString(); // retorna la cadena de salida
    }
}







