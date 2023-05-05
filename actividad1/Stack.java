/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad1;

/**
 *
 * @author Usuario
 */
public interface Stack<E> { 
    void push(E x);
    E pop() throws ExceptionIsEmpty; 
    E top() throws ExceptionIsEmpty;
    boolean isEmpty();
} 

