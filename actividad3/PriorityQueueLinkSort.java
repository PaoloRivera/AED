/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

import actividad1.ExceptionIsEmpty;

/**
 *
 * @author Usuario
 */
class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    // Clase interna EntryNode para almacenar datos y prioridad
    class EntryNode {
        E data;       // almacena el dato del tipo genérico E
        P priority;   // almacena la prioridad del tipo genérico P

        // Constructor de EntryNode que toma un dato y una prioridad
        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    // Referencia al primer y último nodo en la lista enlazada
    private Node<EntryNode> first;
    private Node<EntryNode> last;

    // Constructor de la clase PriorityQueueLinkSort
    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    // Método para agregar elementos a la cola de prioridad
    public void enqueue(E x, P pr) {
        // La lista debe estar ordenada por la prioridad de los elementos.
        // A mayor prioridad, el elemento está más hacia el frente.
        EntryNode newNode = new EntryNode(x, pr);
        Node<EntryNode> newNodeWrapper = new Node<>(newNode);

        // Caso cuando la cola está vacía
        if (isEmpty()) {
            first = newNodeWrapper;
            last = newNodeWrapper;
        } else {
            // Recorrer la lista enlazada y encontrar la posición correcta para insertar el nuevo nodo
            Node<EntryNode> current = first;
            Node<EntryNode> previous = null;

            while (current != null && newNode.priority.compareTo(current.getData().priority) <= 0) {
                previous = current;
                current = current.getNext();
            }

            // Insertar el nuevo nodo en la posición correcta en la lista enlazada
            if (previous == null) {
                newNodeWrapper.setNext(first);
                first = newNodeWrapper;
            } else if (current == null) {
                last.setNext(newNodeWrapper);
                last = newNodeWrapper;
            } else {
                previous.setNext(newNodeWrapper);
                newNodeWrapper.setNext(current);
            }
        }
    }

    // Método para eliminar y devolver el elemento con la prioridad más alta
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("No se puede eliminar de una cola vacía");
        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null)
            this.last = null;
        return aux;
    }

    // Método para obtener el elemento en la parte posterior de la cola (prioridad más baja)
    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La cola está vacía");
        return this.last.getData().data;
    }

    // Método para obtener el elemento en la parte delantera de la cola (prioridad más alta)
    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La cola está vacía");
        return this.first.getData().data;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return first == null;
    }    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> current = first;
        while (current != null) {
            sb.append("(");
            sb.append(current.getData().data);
            sb.append(", ");
            sb.append(current.getData().priority);
            sb.append(")");
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}
