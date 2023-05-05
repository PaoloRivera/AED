/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

/**
 *
 * @author Usuario
 */
class Node<E> {
    private E data;           // almacena el dato del tipo genérico E
    private Node<E> next;     // referencia al siguiente nodo en la lista enlazada

    public Node(E data) {
        this.data = data;     // inicializa el dato con el valor proporcionado
        this.next = null;     // inicializa el siguiente nodo como null
    }

    public E getData() {
        return data;          // retorna el dato almacenado en el nodo
    }

    public void setData(E data) {
        this.data = data;     // actualiza el dato almacenado en el nodo
    }

    public Node<E> getNext() {
        return next;          // retorna el siguiente nodo en la lista enlazada
    }

    public void setNext(Node<E> next) {
        this.next = next;     // establece el siguiente nodo en la lista enlazada
    }
}
