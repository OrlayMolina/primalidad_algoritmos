package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;
import java.util.Random;

public class PrimalidadFermat {

    public static boolean esPrimoFermat(long n, int iteraciones) {
        if (n < 4) return (n == 2 || n == 3);

        Random rand = new Random();
        for (int i = 0; i < iteraciones; i++) {
            long a = 2 + (Math.abs(rand.nextLong()) % (n - 3));

            if (!BigInteger.valueOf(a).modPow(BigInteger.valueOf(n - 1), BigInteger.valueOf(n)).equals(BigInteger.ONE)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int iteracciones = 10;
        System.out.println(esPrimoFermat(1003720741L, iteracciones));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}

