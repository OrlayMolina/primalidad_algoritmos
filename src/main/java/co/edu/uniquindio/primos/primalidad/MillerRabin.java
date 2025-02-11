package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {

    public static boolean esPrimoMillerRabin(long n, int iteraciones) {
        if (n < 4) return (n == 2 || n == 3);

        long d = n - 1;
        int s = 0;


        while (d % 2 == 0) {
            d /= 2;
            s++;
        }

        Random rand = new Random();

        for (int i = 0; i < iteraciones; i++) {
            long a = 2 + (Math.abs(rand.nextLong()) % (n - 3));
            BigInteger base = BigInteger.valueOf(a);
            BigInteger mod = BigInteger.valueOf(n);
            BigInteger x = base.modPow(BigInteger.valueOf(d), mod);

            if (x.equals(BigInteger.ONE) || x.equals(BigInteger.valueOf(n - 1))) {
                continue;
            }

            boolean esCompuesto = true;
            for (int r = 0; r < s - 1; r++) {
                x = x.modPow(BigInteger.TWO, mod);
                if (x.equals(BigInteger.ONE)) return false;
                if (x.equals(BigInteger.valueOf(n - 1))) {
                    esCompuesto = false;
                    break;
                }
            }

            if (esCompuesto) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int iteracciones = 10;
        System.out.println(esPrimoMillerRabin(1003720741L, iteracciones));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}