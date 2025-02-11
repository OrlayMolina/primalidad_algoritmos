package co.edu.uniquindio.primos.matrices;

import java.util.Random;

public class IdentificarMatrizSimetrica {

    public static void main(String[] args) {
        int size = 5000;
        double[][] matriz = new double[size][size];

        Random rand = new Random();

        // Llenar solo la mitad de la matriz y reflejar en la otra mitad para que sea simétrica
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {  // Solo llenamos la diagonal y parte superior
                double valor = 1 + (9 * rand.nextDouble()); // Valores entre 1 y 10
                matriz[i][j] = valor;
                matriz[j][i] = valor; // Reflejamos el valor en la parte inferior
            }
        }
        long inicio = System.currentTimeMillis();
        System.out.println(esSimetricaUno(matriz));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
}

    public static boolean esSimetricaUno ( double[][] arreglo )
    {

        boolean aux = true;

        for (int i = 0; i < arreglo.length && aux==true; i++ )
        {

            for (int j = 0; j < arreglo[0].length && aux==true ; j++ )
            {

                if (arreglo[i][j]!= arreglo[j][i] && i!=j)
                {

                    aux=false;

                }

            }

        }
        return aux;
    }
}



