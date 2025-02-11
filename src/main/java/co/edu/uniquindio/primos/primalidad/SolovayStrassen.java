package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;
import java.util.Random;

public class SolovayStrassen {

    public static int jacobiSymbol(long a, long n) {
        if (n <= 0 || n % 2 == 0) return 0;
        int result = 1;

        if (a < 0) {
            a = -a;
            if (n % 4 == 3) result = -result;
        }

        while (a != 0) {
            while (a % 2 == 0) {
                a /= 2;
                if (n % 8 == 3 || n % 8 == 5) result = -result;
            }

            long temp = a;
            a = n;
            n = temp;

            if (a % 4 == 3 && n % 4 == 3) result = -result;
            a %= n;
        }

        return (n == 1) ? result : 0;
    }

    public static boolean esPrimoSolovayStrassen(long n, int iteraciones) {
        if (n < 4) return (n == 2 || n == 3);

        Random rand = new Random();

        for (int i = 0; i < iteraciones; i++) {
            long a = 2 + (Math.abs(rand.nextLong()) % (n - 3));
            int jacobi = jacobiSymbol(a, n);
            if (jacobi == 0) return false;

            BigInteger base = BigInteger.valueOf(a);
            BigInteger mod = BigInteger.valueOf(n);
            BigInteger exp = BigInteger.valueOf((n - 1) / 2);
            BigInteger resultado = base.modPow(exp, mod);

            if (!resultado.equals(BigInteger.valueOf((jacobi + n) % n))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int iteracciones = 10;
        System.out.println(esPrimoSolovayStrassen(1003720741L, iteracciones));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}
