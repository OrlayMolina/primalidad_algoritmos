package co.edu.uniquindio.primos.matrices;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class IdentificarMatrizSimetricaOptimizada {

    public static void main(String[] args) {
        int size = 5000;
        double[][] matriz = new double[size][size];

        Random rand = new Random();

        // Llenar solo la mitad superior y reflejar en la parte inferior para hacerla simétrica
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                double valor = 1 + (9 * rand.nextDouble()); // Valores entre 1 y 10
                matriz[i][j] = valor;
                matriz[j][i] = valor; // Reflejo en la parte inferior
            }
        }

        long inicio = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool(); // Paralelismo automático según núcleos de la CPU
        boolean resultado = pool.invoke(new VerificarSimetria(matriz, 0, size));
        long fin = System.nanoTime();

        long duracion = (fin - inicio) / 1_000_000; // Convertir nanosegundos a milisegundos
        System.out.println("¿Es simétrica? " + resultado);
        System.out.println("Tiempo de ejecución en milisegundos: " + duracion);
    }

    // Clase recursiva para el procesamiento paralelo
    static class VerificarSimetria extends RecursiveTask<Boolean> {
        private static final int UMBRAL = 500; // Tamaño mínimo de partición
        private final double[][] matriz;
        private final int inicio, fin;

        public VerificarSimetria(double[][] matriz, int inicio, int fin) {
            this.matriz = matriz;
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        protected Boolean compute() {
            if (fin - inicio <= UMBRAL) {
                // Caso base: Verificamos la simetría en la submatriz
                for (int i = inicio; i < fin; i++) {
                    for (int j = i + 1; j < matriz.length; j++) {
                        if (matriz[i][j] != matriz[j][i]) {
                            return false; // Si no es simétrica, cortamos el proceso
                        }
                    }
                }
                return true;
            } else {
                // Caso recursivo: Dividimos en dos tareas en paralelo
                int medio = (inicio + fin) / 2;
                VerificarSimetria tarea1 = new VerificarSimetria(matriz, inicio, medio);
                VerificarSimetria tarea2 = new VerificarSimetria(matriz, medio, fin);

                tarea1.fork(); // Ejecutar la primera tarea en otro hilo
                boolean resultado2 = tarea2.compute(); // Ejecutar la segunda en el hilo actual
                boolean resultado1 = tarea1.join(); // Esperar la primera tarea

                return resultado1 && resultado2; // Ambas deben ser verdaderas
            }
        }
    }
}
