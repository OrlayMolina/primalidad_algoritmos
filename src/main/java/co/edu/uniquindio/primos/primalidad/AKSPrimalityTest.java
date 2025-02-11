package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;

public class AKSPrimalityTest {
    public static boolean isPrime(long n) {
        // Casos base
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Verificar si es potencia perfecta
        if (isPerfectPower(n)) return false;

        // Encontrar límite r
        int r = findR(n);

        // Verificar condiciones de coprimidad
        for (long a = 2; a <= r; a++) {
            if (gcd(a, n) > 1) return false;
        }

        // Prueba polinómica
        if (n <= r) return true;

        for (long a = 1; a <= r; a++) {
            if (!checkPolynomialCondition(a, n)) {
                return false;
            }
        }

        return true;
    }

    // Verificar si es potencia perfecta
    private static boolean isPerfectPower(long n) {
        for (int b = 2; b <= Math.log(n) / Math.log(2); b++) {
            double a = Math.pow(n, 1.0 / b);
            if (Math.pow(Math.round(a), b) == n) {
                return true;
            }
        }
        return false;
    }

    // Encontrar r óptimo
    private static int findR(long n) {
        for (int r = 2; r < n; r++) {
            if (areCoprime(r, n)) {
                return r;
            }
        }
        return (int)n;
    }

    // Verificación de condición polinómica
    private static boolean checkPolynomialCondition(long a, long n) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigN = BigInteger.valueOf(n);

        // (x + a)^n mod (x^r - 1, n)
        BigInteger left = bigA.modPow(BigInteger.valueOf(n), bigN);
        BigInteger right = bigA.modPow(BigInteger.ONE, bigN);

        return left.equals(right);
    }

    // Máximo común divisor
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Verificar si son coprimos
    private static boolean areCoprime(long a, long b) {
        return gcd(a, b) == 1;
    }

    // Método principal de prueba
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(isPrime(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}
