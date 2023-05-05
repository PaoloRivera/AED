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
public class Test {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new QueueLink<>();

        try {
            intQueue.enqueue(1);
            intQueue.enqueue(2);
            intQueue.enqueue(3);
            intQueue.enqueue(4);

            System.out.println("Cola de enteros: " + intQueue.toString());

            intQueue.dequeue();

            System.out.println("Cola de enteros después de dequeue(): " + intQueue.toString());

            System.out.println("Primer elemento (front) en la cola de enteros: " + intQueue.front());

            System.out.println("Último elemento (back) en la cola de enteros: " + intQueue.back());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        Queue<String> stringQueue = new QueueLink<>();

        try {
            stringQueue.enqueue("Uno");
            stringQueue.enqueue("Dos");
            stringQueue.enqueue("Tres");
            stringQueue.enqueue("Cuatro");

            System.out.println("Cola de cadenas: " + stringQueue.toString());

            stringQueue.dequeue();

            System.out.println("Cola de cadenas después de dequeue(): " + stringQueue.toString());

            System.out.println("Primer elemento (front) en la cola de cadenas: " + stringQueue.front());

            System.out.println("Último elemento (back) en la cola de cadenas: " + stringQueue.back());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}