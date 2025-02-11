package co.edu.uniquindio.primos.matrices;

import java.util.Random;

import static co.edu.uniquindio.primos.matrices.IdentificarMatrizSimetrica.esSimetricaUno;

public class IdentificarMatrizSimetricaDos {

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
        System.out.println(esSimetrica(matriz));
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);

        long inicio2 = System.currentTimeMillis();
        System.out.println(esSimetricaUno(matriz));
        long fin2 = System.currentTimeMillis();
        long duracion2 = fin2 - inicio2;

        System.out.println("Tiempo de ejecución en milisegundos primer algoritmo: " + duracion2);
    }
    public static boolean esSimetrica(double[][] arreglo)
    {

        for (int i = 0; i < arreglo.length; i++)
        {

            for (int j = i + 1; j < arreglo.length; j++)
            {

                if (arreglo[i][j] != arreglo[j][i])
                {

                    return false;

                }

            }

        }
        return true;

    }
}
