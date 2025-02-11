package co.edu.uniquindio.primos.diapositivas;

public class Primo2 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        System.out.println(determinarNumeroPrimo2(1003720741L));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }

    public static boolean determinarNumeroPrimo2 (long numero)
    {

        boolean centi=true;
        for (long i = 2; i <= numero / 2 && centi==true; i++)
        {

            if (numero % i == 0)
            {

                centi = false;

            }

        }
        return centi;

    }
}
