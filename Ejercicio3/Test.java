package Ejercicio3;

import java.util.Scanner;


public class Test {

    public static void main(String[] args) throws ExceptionIsEmpty {
        Scanner sc = new Scanner(System.in);

        // Crear la cola de prioridad
        PriorityQueueLinked<String, Integer>[] queues = new PriorityQueueLinked[5];
        queues[0] = new PriorityQueueLinked<>(5);
        queues[1] = new PriorityQueueLinked<>(5);
        queues[2] = new PriorityQueueLinked<>(5);
        queues[3] = new PriorityQueueLinked<>(5);
        queues[4] = new PriorityQueueLinked<>(5);

        // Agregar elementos a la cola de prioridad
        queues[0].enqueue("Elemento 1", 1);
        queues[1].enqueue("Elemento 2", 2);
        queues[2].enqueue("Elemento 3", 3);
        queues[3].enqueue("Elemento 4", 4);
        queues[4].enqueue("Elemento 5", 5);

        // Mostrar la cola de prioridad seleccionada por el usuario
        System.out.print("Ingrese la prioridad a visualizar:");
        int priority = sc.nextInt();
        System.out.println(queues[priority - 1].toString());

        // Ordenar las colas de prioridad por su índice y mostrarlas
        PriorityQueueLinked<String, Integer>[] sortedQueues = new PriorityQueueLinked[5];
        sortedQueues[0] = queues[0];
        sortedQueues[1] = queues[1];
        sortedQueues[2] = queues[2];
        sortedQueues[3] = queues[3];
        sortedQueues[4] = queues[4];
        
        System.out.println("Colas de prioridad Enlazadas a una lista");
        for (int i = 0; i < sortedQueues.length; i++) {
            System.out.println("Prioridad " + (i + 1) + " = Posición situada " + i);
            //System.out.println(sortedQueues[i].toString());  //muestra los elementos de las colas
        }
    }
}




