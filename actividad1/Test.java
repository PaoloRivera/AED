/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

/**
 *
 * @author Usuario
 */
public class Test {
    public static void main(String[] args) {
        // Prueba con una pila de enteros
        Stack<Integer> stackInt = new StackArray<>(5);
        try {
            stackInt.push(1);
            stackInt.push(2);
            stackInt.push(3);
            stackInt.push(4);
            stackInt.push(5);

            System.out.println("Pila de enteros: " + stackInt.toString());

            System.out.println("Elemento superior: " + stackInt.top());

            stackInt.pop();
            System.out.println("Pila después de eliminar el elemento superior: " + stackInt.toString());

        } catch (ExceptionIsEmpty e) {
        }

        // Prueba con una pila de cadenas
        Stack<String> stackString = new StackArray<>(3);
        try {
            stackString.push("Hola");
            stackString.push("Mundo");
            stackString.push("!");

            System.out.println("Pila de cadenas: " + stackString.toString());

            System.out.println("Elemento superior: " + stackString.top());

            stackString.pop();
            System.out.println("Pila después de eliminar el elemento superior: " + stackString.toString());

        } catch (ExceptionIsEmpty e) {
        }
    }
}