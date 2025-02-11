package co.edu.uniquindio.primos.diapositivas;

public class Primo4 {
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();
        System.out.println(determinarNumeroPrimo4(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }

    public static boolean determinarNumeroPrimo4 (long numero)
    {

        for (long i = 2; i <= (int)Math.sqrt(numero); i++)
        {

            if (numero % i == 0)
            {

                return false;

            }

        }
        return true;

    }
}
