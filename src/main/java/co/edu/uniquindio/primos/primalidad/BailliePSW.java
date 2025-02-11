package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;

public class BailliePSW {

    // Test de Miller-Rabin con base 2
    public static boolean millerRabinBase2(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        long d = n - 1;
        int s = 0;
        while (d % 2 == 0) {
            d /= 2;
            s++;
        }

        BigInteger base = BigInteger.valueOf(2);
        BigInteger num = BigInteger.valueOf(n);
        BigInteger exp = BigInteger.valueOf(d);
        BigInteger x = base.modPow(exp, num);

        if (x.equals(BigInteger.ONE) || x.equals(BigInteger.valueOf(n - 1))) {
            return true;
        }

        for (int r = 0; r < s - 1; r++) {
            x = x.modPow(BigInteger.TWO, num);
            if (x.equals(BigInteger.ONE)) return false;
            if (x.equals(BigInteger.valueOf(n - 1))) return true;
        }
        return false;
    }

    // Test de Lucas fuerte
    public static boolean lucasTest(long n) {
        if (n < 2) return false;

        long d = 5;
        while (jacobiSymbol(d, n) != -1) {
            d = (d > 0) ? -d - 2 : -d + 2;
        }

        long p = 1, q = (1 - d) / 4;
        return lucasStrongTest(n, d, p, q);
    }

    // Cálculo del símbolo de Jacobi
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

    // Test de Lucas fuerte
    public static boolean lucasStrongTest(long n, long d, long p, long q) {
        BigInteger num = BigInteger.valueOf(n);
        BigInteger P = BigInteger.valueOf(p);
        BigInteger Q = BigInteger.valueOf(q);

        BigInteger U = BigInteger.ZERO;
        BigInteger V = BigInteger.TWO;
        BigInteger Qk = BigInteger.ONE;

        long k = n + 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                BigInteger temp = U.multiply(V).mod(num);
                V = V.multiply(V).subtract(Qk.multiply(BigInteger.TWO)).mod(num);
                U = temp;
            }

            Qk = Qk.multiply(Qk).mod(num);
            k >>= 1;
        }
        return U.equals(BigInteger.ZERO);
    }

    // Test de Baillie-PSW
    public static boolean esPrimoBailliePSW(long n) {
        return millerRabinBase2(n) && lucasTest(n);
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(esPrimoBailliePSW(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}
