public class Matrix {

        int linhas;
        int colunas;
        double [][] matriz;

        //Constructor Matrix
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

        //Construtor para criar uma matriz "vazia" (preenchida com zeros)
        public Matrix(int linhas, int colunas) {
            this.linhas = linhas;
            this.colunas = colunas;
            this.matriz = new double[linhas][colunas];
        }


        //Getter
        public double get (int i, int j) {
            return matriz[i][j];
        }

        //Setter
        public void set (int i, int j, double valor) {
            if (Math.abs(valor) < 1e-10) {
                matriz[i][j] = 0.0;
            } else {
                matriz[i][j] = valor;
            }
        }

        //Print Matrix
        public void print () {
            for (int i = 0; i<linhas; i++) {
                for (int j = 0; j<colunas; j++) {
                    System.out.printf("%.2f ", matriz[i][j]);
                }
                System.out.println();
            }
        }

}
