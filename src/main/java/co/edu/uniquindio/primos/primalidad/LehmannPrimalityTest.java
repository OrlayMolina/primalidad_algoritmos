package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;
import java.util.Random;

public class LehmannPrimalityTest {

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        return lehmanTest(n);
    }

    private static boolean lehmanTest(long n) {
        double sqrtN = Math.cbrt(n); // Raíz cúbica de n
        Random rand = new Random();

        for (int i = 0; i < 5; i++) { // 5 iteraciones para mejorar la precisión
            long a = 2 + (Math.abs(rand.nextLong()) % (n - 2));
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigN = BigInteger.valueOf(n);
            BigInteger modExp = bigA.modPow(bigN.subtract(BigInteger.ONE).divide(BigInteger.TWO), bigN);

            if (!modExp.equals(BigInteger.ONE) && !modExp.equals(bigN.subtract(BigInteger.ONE))) {
                return false;
            }
        }

        for (long b = 2; b <= sqrtN; b++) {
            if (n % b == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long num = 1003720741L;
        long inicio = System.currentTimeMillis();
        System.out.println(num + " es primo: " + isPrime(num));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        System.out.println("Tiempo de ejecucion en milisegundos: " + duracion);
    }
}
