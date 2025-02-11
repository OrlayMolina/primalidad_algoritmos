package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;

public class WilsonPrimality {

    // Función que calcula (n-1)! % n usando BigInteger
    public static boolean esPrimoWilson(long n) {
        if (n < 2) return false; // 1 y 0 no son primos

        BigInteger factorial = BigInteger.ONE;
        for (long i = 2; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(n));
        }

        // Comprobamos la condición de Wilson
        return factorial.equals(BigInteger.valueOf(n - 1));
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(esPrimoWilson(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}
