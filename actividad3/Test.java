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
public class Test {
    public static void main(String[] args) {
        // Crear una PriorityQueueLinkSort que almacene Strings con prioridades de tipo Integer
        PriorityQueue<String, Integer> priorityQueue = new PriorityQueueLinkSort<>();

        try {
            // Agregar elementos a la cola de prioridad
            priorityQueue.enqueue("Tarea 1", 3);
            priorityQueue.enqueue("Tarea 2", 1);
            priorityQueue.enqueue("Tarea 3", 4);
            priorityQueue.enqueue("Tarea 4", 2);

            // Mostrar el estado actual de la cola de prioridad
            System.out.println("Cola de prioridad actual:");
            System.out.println(priorityQueue);

            // Obtener y mostrar el elemento de mayor prioridad (parte delantera de la cola)
            System.out.println("Elemento de mayor prioridad: " + priorityQueue.front());

            // Obtener y mostrar el elemento de menor prioridad (parte trasera de la cola)
            System.out.println("Elemento de menor prioridad: " + priorityQueue.back());

            // Eliminar el elemento de mayor prioridad de la cola
            System.out.println("Eliminando el elemento de mayor prioridad: " + priorityQueue.dequeue());

            // Mostrar el estado de la cola de prioridad después de eliminar el elemento de mayor prioridad
            System.out.println("Cola de prioridad después de eliminar el elemento de mayor prioridad:");
            System.out.println(priorityQueue);

        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}
