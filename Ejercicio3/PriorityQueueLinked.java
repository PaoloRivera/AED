package Ejercicio3;

import java.util.Arrays;
import java.util.LinkedList;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    private int numPriorities;
    private LinkedList<E>[] queues;
    private P[] priorities; // Nuevo arreglo para almacenar las prioridades

    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        queues = new LinkedList[numPriorities];
        priorities = (P[]) new Comparable[numPriorities]; // Inicializar arreglo de prioridades
        for (int i = 1; i <= numPriorities; i++) { // Modificar aquí
            queues[i - 1] = new LinkedList<>();
            priorities[i - 1] = (P) Integer.valueOf(i); // Asignar prioridad inicialmente como Integer
        }
    }

    @Override
    public void enqueue(E x, P pr) {
        int priorityIndex = getPriorityIndex(pr);
        queues[priorityIndex].addLast(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue is empty");
        }
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].removeFirst();
            }
        }
        return null;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue is empty");
        }
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].getFirst();
            }
        }
        return null;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue is empty");
        }
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].getLast();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int getPriorityIndex(P pr) {
        for (int i = 0; i < numPriorities; i++) {
            if (pr.compareTo((P) Integer.valueOf(i + 1)) == 0) { // Modificar aquí
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid priority: " + pr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueueLinked [\n");

        // Ordenar arreglo de prioridades en orden ascendente o descendente
        Arrays.sort(priorities);

        for (int i = 0; i < numPriorities; i++) {
            int priorityIndex = getPriorityIndex(priorities[i]); // Obtener índice de la cola de prioridad
            sb.append("Cola de prioridad ");
            sb.append(priorities[i]);
            //sb.append(" = Posicion ");
            //sb.append(priorityIndex);
            sb.append(": ");
            sb.append(queues[priorityIndex].toString());
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}






