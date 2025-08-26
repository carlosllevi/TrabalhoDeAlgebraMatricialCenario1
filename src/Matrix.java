import java.util.Scanner;

public class Matrix {

        int linhas;
        int colunas;
        int [][] matriz;

        //construtor da matriz

        public void construtor (int linhas, int colunas, int [] elementos) {

            this.linhas = linhas;
            this.colunas = colunas;
            matriz = new int[linhas][colunas];

            int k = 0;

            for (int i = 0; i<linhas; i++) {

                for (int j = 0; j<colunas; j++) {

                    matriz[i][j] = elementos [k];
                    k++;

                }

            }

        }

        // metodo get retornar valor do elemento da matriz

        public int get (int i, int j) {

            return matriz[i][j];

        }

        //metodo set define um novo valor para o elemento [i][j] da matriz

        public void set (int i, int j, int valor) {

            matriz [i][j] = valor;

        }

        //print

        public void print () {


            for (int i = 0; i<linhas; i++) {

                for (int j = 0; j<colunas; j++) {

                    System.out.print(matriz[i][j] + " ");

                }

                System.out.println();

            }

        }

}
