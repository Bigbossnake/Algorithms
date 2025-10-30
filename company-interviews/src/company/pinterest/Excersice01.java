package company.pinterest;

import java.util.*;

public class Excersice01 {

    public static boolean puedeObtenerTarget(int[] numeros, int target) {
        return backtrack(numeros, 1, numeros[0], target); // comenzamos desde el segundo elemento
    }

    private static boolean backtrack(int[] numeros, int index, int acumulado, int target) {
        if (index == numeros.length) {
            return acumulado == target;
        }

        int actual = numeros[index];

        // Probar con suma
        if (backtrack(numeros, index + 1, acumulado + actual, target)) {
            return true;
        }

        // Probar con multiplicación
        if (backtrack(numeros, index + 1, acumulado * actual, target)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 3, 5};
        int target = 30;

        boolean resultado = puedeObtenerTarget(numeros, target);
        System.out.println("¿Se puede obtener el número objetivo? " + resultado);
    }
}