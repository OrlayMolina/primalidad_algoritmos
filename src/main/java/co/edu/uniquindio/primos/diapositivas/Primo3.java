package co.edu.uniquindio.primos.diapositivas;

public class Primo3 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(determinarNumeroPrimo3(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }

    public static boolean determinarNumeroPrimo3 (long numero)
    {
        long i;
        for (i = 2 ; i <= numero / 2 ; i++ )
        {

            if ( numero % i == 0 )
            {

                break;

            }

        }
        if ( numero / 2 < i )
        {

            return true;

        }
        else
        {

            return false;

        }

    }
}
