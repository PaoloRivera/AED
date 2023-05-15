/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    
    // Método para agregar un elemento a la pila
    public void push(T item) {
        stack.add(item);
    }
    
    // Método para remover y devolver el elemento superior de la pila
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            return null;
        }
    }
    
    // Método para ver el elemento superior de la pila sin removerlo
    public T peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            return null;
        }
    }
    
    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

