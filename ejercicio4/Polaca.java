/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Usuario
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Polaca {
    private Stack<Character> stack = new Stack<>(); // Creamos una pila para los caracteres
    
    public void readFile(String ruta) {
        // Utilizamos un try-with-resources para gestionar el archivo
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine()) != null) { // Mientras haya líneas por leer
                String infix = line.substring(1, line.length() - 1); // Quitamos los símbolos $ de las expresiones
                String postfix = inToPos(infix); // Convertimos la expresión de notación infija a postfija
                int result = resultExpresion(postfix); // Calculamos el resultado de la expresión postfija
                System.out.println("Resultado: " + result); // Imprimimos el resultado
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de la excepción en caso de error de lectura del archivo
        }
    }

    public String inToPos(String infix) {
        StringBuilder postfix = new StringBuilder(); // Usamos un StringBuilder para construir la expresión postfija
        for (char c : infix.toCharArray()) { // Recorremos cada carácter de la expresión infija
            switch (c) {
                // Si el carácter es un operador
                case '+':
                case '-':
                case '*':
                case '/':
                case 'S':
                    // Mientras la pila no esté vacía y el operador actual tenga menor o igual precedencia que el operador en la cima de la pila
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        postfix.append(stack.pop()); // Sacamos el operador de la pila y lo añadimos a la expresión postfija
                    }
                    stack.push(c); // Añadimos el operador actual a la pila
                    break;
                case '(':
                    stack.push(c); // Si es un paréntesis abierto, lo añadimos a la pila
                    break;
                case ')':
                    // Mientras la pila no esté vacía y no encontremos un paréntesis abierto
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()); // Sacamos los operadores de la pila y los añadimos a la expresión postfija
                    }
                    // Si la pila no está vacía y en la cima hay un paréntesis abierto, lo sacamos de la pila
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                default:
                    postfix.append(c); // Si es un operando (un número), lo añadimos directamente a la expresión postfija
            }
        }
        // Si quedan operadores en la pila, los añadimos a la expresión postfija
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private int precedence(char c) {
        // Método auxiliar para determinar la precedencia de los operadores
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case 'S':
                return 3;
            default:
                return -1; // Si no es un operador, regresamos -1
        }
    }

    public int resultExpresion(String postfix) {
        Stack<Integer> stack = new Stack<>(); // Usamos una pila para almacenar los operandos
        for (char c : postfix.toCharArray()) { // Recorremos cada carácter de la expresión postfija
            if (Character.isDigit(c)) { // Si es un dígito
                stack.push(c - '0'); // Lo convertimos a int y lo añadimos a la pila
            } else { // Si es un operador
                int val1 = stack.pop(); // Sacamos el primer operando de la pila
                int val2 = stack.pop(); // Sacamos el segundo operando de la pila
                switch (c) {
                    case '+': // Si es suma
                        stack.push(val2 + val1); // Sumamos los operandos y añadimos el resultado a la pila
                        break;
                    case '-': // Si es resta
                        stack.push(val2 - val1); // Restamos los operandos y añadimos el resultado a la pila
                        break;
                    case '*': // Si es multiplicación
                        stack.push(val2 * val1); // Multiplicamos los operandos y añadimos el resultado a la pila
                        break;
                    case '/': // Si es división
                        stack.push(val2 / val1); // Dividimos los operandos y añadimos el resultado a la pila
                        break;
                    case 'S': // Si es potencia
                        stack.push((int) Math.pow(val2, val1)); // Elevamos el segundo operando a la potencia del primer operando y añadimos el resultado a la pila
                        break;
                }
            }
        }
        return stack.pop(); // El resultado final de la expresión es el último elemento en la pila
    }
}

