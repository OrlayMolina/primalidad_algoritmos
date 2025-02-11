package co.edu.uniquindio.primos.diapositivas;

public class Primo1 {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(determinarNumeroPrimo1(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }
    public static boolean determinarNumeroPrimo1 (long numero)
    {
        int resultado = 0;
        long i;
        for( i = 2; i < numero; i++ )
        {

            if (numero % i == 0)
            {

                resultado = 1;

            }

        }
        if (resultado == 0)
        {

            return true;

        }
        else
        {

            return false;

        }
    }
}
