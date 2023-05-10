/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Alumno
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new QueueArray<>(5);
        Queue<String> stringQueue = new QueueArray<>(3);

        // Probando la cola de enteros
        try {
            System.out.println("Cola de enteros:");
            integerQueue.enqueue(1);
            integerQueue.enqueue(2);
            integerQueue.enqueue(3);
            System.out.println("Front: " + integerQueue.front()); // Debería imprimir 1
            System.out.println("Back: " + integerQueue.back()); // Debería imprimir 3
            System.out.println("Dequeue: " + integerQueue.dequeue()); // Debería imprimir 1
            System.out.println("Front despues de dequeue: " + integerQueue.front()); // Debería imprimir 2
            integerQueue.enqueue(4);
            integerQueue.enqueue(5);
            System.out.println("Queue: " + integerQueue); // Debería imprimir 2, 3, 4, 5
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        
       

        // Probando la cola de cadenas
        try {
            System.out.println("\nCola de cadenas:");
            stringQueue.enqueue("Hola");
            stringQueue.enqueue("Mundo");
            System.out.println("Front: " + stringQueue.front()); // Debería imprimir "Hola"
            System.out.println("Back: " + stringQueue.back()); // Debería imprimir "Mundo"
            System.out.println("Dequeue: " + stringQueue.dequeue()); // Debería imprimir "Hola"
            System.out.println("Front despues de dequeue: " + stringQueue.front()); // Debería imprimir "Mundo"
            stringQueue.enqueue("OpenAI");
            System.out.println("Queue: " + stringQueue); // Debería imprimir "Mundo", "OpenAI"
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}
