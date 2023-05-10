/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Alumno
 */
public class Test {
    public static void main(String[] args) {
        // Crea una pila de enteros usando la implementación de StackLink
        Stack<Integer> integerStack = new StackLink<>();
        try {
            integerStack.push(1);
            integerStack.push(2);
            integerStack.push(3);
            System.out.println(integerStack.top()); // Debería imprimir 3
            System.out.println(integerStack.pop()); // Debería imprimir 3
            System.out.println(integerStack.top()); // Debería imprimir 2
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }

        // Crea una pila de cadenas usando la implementación de StackLink
        Stack<String> stringStack = new StackLink<>();
        try {
            stringStack.push("Hola");
            stringStack.push("Mundo");
            System.out.println(stringStack.top()); // Debería imprimir "Mundo"
            System.out.println(stringStack.pop()); // Debería imprimir "Mundo"
            System.out.println(stringStack.top()); // Debería imprimir "Hola"
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }

        // Prueba que la pila está vacía
        System.out.println(stringStack.isEmpty()); // Debería imprimir "false"
        try {
            while (!stringStack.isEmpty()) {
                System.out.println(stringStack.pop());
            }
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        System.out.println(stringStack.isEmpty()); // Debería imprimir "true"
    }
}