package co.edu.uniquindio.primos.multiplicacion;

public class NaivStandard2 {
    public static void main(String[] args) {
        int[][] matrizA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrizB = {
                {1, 2, 3, 7},
                {4, 5, 6, 8},
                {7, 8, 9, 10}
        };

        long inicio = System.currentTimeMillis();
        int[][] matrizC = naivStandard2(matrizA, matrizB);
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Tiempo de ejecución en milisegundos: " + duracion + "\n");
        imprimirMatriz(matrizC);
    }

    public static int[][] naivStandard2(int [][] A, int [][] B)
    {

        int [][] matriz = new int [A.length][B[0].length];
        if (A[0].length == B.length)
        {

            for (int i = 0; i < A.length; i++)
            {

                for (int j = 0; j < B[0].length; j++)
                {

                    matriz [i][j] = 0;
                    for (int k = 0; k < B.length; k++) {

                        matriz [i][j]+= (A[i][k]*B[k][j]);

                    }

                }

            }

        }
        return matriz;

    }

    public static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
