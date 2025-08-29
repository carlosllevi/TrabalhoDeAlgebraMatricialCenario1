public class Matrix {

        int linhas;
        int colunas;
        int [][] matriz;

        //Construtor da Matriz
        public Matrix(int linhas, int colunas, int [] elementos) {
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

        // Metodo get retornar valor do elemento da matriz
        public int get (int i, int j) {
            return matriz[i][j];
        }

        //Metodo set define um novo valor para o elemento [i][j] da matriz
        public void set (int i, int j, int valor) {
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
