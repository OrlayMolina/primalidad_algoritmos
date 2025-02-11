package co.edu.uniquindio.primos.primalidad;

import java.math.BigInteger;

public class LucasLehmer {

    public static boolean esPrimoLucasLehmer(long p) {
        if (p < 2) return false;

        BigInteger Mp = BigInteger.valueOf(2).pow((int) p).subtract(BigInteger.ONE);
        BigInteger S = BigInteger.valueOf(4);

        for (int i = 0; i < p - 2; i++) {
            S = S.multiply(S).subtract(BigInteger.TWO).mod(Mp);
        }

        return S.equals(BigInteger.ZERO);
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(esPrimoLucasLehmer(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
}
