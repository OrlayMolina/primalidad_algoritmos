package co.edu.uniquindio.primos.diapositivas;

public class Primo5 {
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();
        System.out.println(determinarNumeroPrimo5(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }

    public static boolean determinarNumeroPrimo5 (long numero)
    {

        if (numero < 2)
        {

            return false;

        }
        for (long i = 2; i * i <= numero; i++)
        {

            if (numero % i == 0)
            {

                return false;

            }

        }
        return true;

    }
}
