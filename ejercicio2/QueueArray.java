/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Alumno
 */
public class QueueArray<E> implements Queue<E> {
    private E[] array; // Arreglo para almacenar los elementos
    private int front; // Índice del primer elemento de la cola
    private int back;  // Índice del último elemento de la cola
    private int size;  // Cantidad de elementos en la cola

    public QueueArray(int n) {
        this.array = (E[]) new Object[n]; // Crea un arreglo de objetos y lo asigna a array
        this.front = 0;                   // Inicializa el frente en 0
        this.back = -1;                   // Inicializa la parte posterior en -1
        this.size = 0;                    // Inicializa el tamaño en 0
    }

    public void enqueue(E x) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena");
        }
        back = (back + 1) % array.length; // Incrementa el índice de atrás y lo mantiene dentro de los límites del arreglo
        array[back] = x;                  // Inserta el elemento en la posición de atrás
        size++;                           // Incrementa el tamaño de la cola
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = array[front];            // Almacena el dato en la posición de frente
        front = (front + 1) % array.length; // Incrementa el índice de frente y lo mantiene dentro de los límites del arreglo
        size--;                           // Decrementa el tamaño de la cola
        return data;                      // Retorna el dato extraído
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[front]; // Retorna el dato en la posición de frente
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[back]; // Retorna el dato en la posición de atrás
    }

    public boolean isEmpty() {
        return size == 0; // Retorna true si el tamaño es 0, lo que indica que la cola está vacía
    }

    public boolean isFull() {
        return size == array.length; // Retorna true si el tamaño es igual a la longitud del arreglo, lo que indica que la cola está llena
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena de salida
        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length; // Calcula el índice actual
            sb.append(array[index]);               // Agrega el dato en el índice actual al StringBuilder
            if (i < size - 1) {
                sb.append(", ");                   // Agrega una coma si hay un siguiente elemento
            }
        }
        return sb.toString(); // Retorna la cadena de salida
    }
}
