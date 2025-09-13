public class Matrix {

        int linhas;
        int colunas;
        double [][] matriz;

        //Construtor da Matriz
        public Matrix(int linhas, int colunas, double [] elementos) {
            this.linhas = linhas;
            this.colunas = colunas;
            matriz = new double[linhas][colunas];

            int k = 0;

            for (int i = 0; i<linhas; i++) {
                for (int j = 0; j<colunas; j++) {
                    matriz[i][j] = elementos [k];
                    k++;
                }
            }
        }

    // Construtor para criar uma matriz "vazia" (preenchida com zeros)
    public Matrix(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        // Apenas cria o array 2D com as dimensões corretas.
        // O Java automaticamente inicializa todos os elementos de um array de int com 0.
        this.matriz = new double[linhas][colunas];
    }


    // Metodo get retornar valor do elemento da matriz
        public double get (int i, int j) {
            return matriz[i][j];
        }

        //Metodo set define um novo valor para o elemento [i][j] da matriz
        public void set (int i, int j, double valor) {
            matriz [i][j] = valor;
        }

        //Print Matriz
        public void print () {
            for (int i = 0; i<linhas; i++) {
                for (int j = 0; j<colunas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }

}
