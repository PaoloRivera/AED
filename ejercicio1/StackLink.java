/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Alumno
 */
class StackLink<E> implements Stack<E> {
    private Node<E> top;  // referencia al nodo en la cima de la pila

    public StackLink() {
        top = null;  // inicializa la pila como vacía
    }

    public void push(E x) {
        Node<E> newNode = new Node<>(x);  // crea un nuevo nodo con el dato proporcionado
        newNode.setNext(top);  // el nuevo nodo apunta al antiguo nodo en la cima de la pila
        top = newNode;  // el nuevo nodo se convierte en la cima de la pila
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {  // si la pila está vacía, lanza una excepción
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E data = top.getData();  // recupera el dato del nodo en la cima de la pila
        top = top.getNext();  // el siguiente nodo se convierte en la cima de la pila
        return data;  // devuelve el dato del nodo que se ha quitado
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {  // si la pila está vacía, lanza una excepción
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return top.getData();  // devuelve el dato del nodo en la cima de la pila sin quitarlo
    }

    public boolean isEmpty() {
        return top == null;  // devuelve true si la cima de la pila es null, lo que indica que la pila está vacía
    }
}
