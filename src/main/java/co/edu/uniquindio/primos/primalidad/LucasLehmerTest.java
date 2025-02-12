package co.edu.uniquindio.primos.primalidad;
import java.math.BigInteger;

public class LucasLehmerTest {
    public static boolean isMersennePrime(long p) {
        if (!isPrime(p)) return false;

        BigInteger Mp = BigInteger.TWO.pow((int) p).subtract(BigInteger.ONE);

        BigInteger s = BigInteger.valueOf(4);
        for (int i = 0; i < p - 2; i++) {
            s = s.multiply(s).subtract(BigInteger.TWO).mod(Mp);
        }

        return s.equals(BigInteger.ZERO);
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long num = 1003720741L;
        long inicio = System.currentTimeMillis();
        System.out.println(num + " es primo: " + isMersennePrime(num));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        System.out.println("Tiempo de ejecucion en milisegundos: " + duracion);
    }
}
