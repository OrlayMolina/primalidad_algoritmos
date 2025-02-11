package co.edu.uniquindio.primos.primalidad;
import java.math.BigInteger;

public class LucasLehmerTest {
    public static boolean isMersennePrime(long p) {
        if (p < 2) return false;

        BigInteger Mp = BigInteger.TWO.pow((int) p).subtract(BigInteger.ONE); // Mersenne number 2^p - 1
        BigInteger s = BigInteger.valueOf(4);

        for (long i = 0; i < p - 2; i++) {
            s = s.multiply(s).subtract(BigInteger.TWO).mod(Mp);
        }

        return s.equals(BigInteger.ZERO);
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
