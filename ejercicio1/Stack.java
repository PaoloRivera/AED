/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Alumno
 */
public interface Stack<E> { 
    void push(E x);
    E pop() throws ExceptionIsEmpty; 
    E top() throws ExceptionIsEmpty;
    boolean isEmpty();
} 