public class LinearAlgebra {

    //Metodo times matriz
    public static Matrix times(int escalar, Matrix a) {
        int [] elementos = new int [a.linhas*a.colunas];
        int k = 0;
        for (int i = 0; i< a.linhas; i++) {
            for (int j = 0; j < a.colunas; j++) {
                elementos [k] = escalar * a.get(i, j);
                k++;
            }
        }
        return new Matrix(a.linhas, a.colunas, elementos);
    }

    //Metodo times vetor
    public static Vector times(int escalar, Vector a) {
        int [] elementos = new int [a.dim];
        int k = 0;
        for (int i = 0; i< a.dim; i++) {
                elementos [k] = escalar * a.get(i);
                k++;
        }
        return new Vector(a.dim, elementos);
    }

    //Metodo gauss
    public static int [][] gauss(int[][] m) {
        int n = m.length; //linhas
        int p = m[0]. length; //colunas
        for (int k = 0; k < n; k++) {
            //Descobre pivo
            int pivo = m[k][k];
            if (pivo == 0) {
                continue;
            }
            //Pivo vira 1
            for (int j = k; j < p; j ++) {
                m[k][j] = m [k][j]/pivo;
            }
            //Zera os elementos abaixo do pivo
            for (int i = k + 1; i < n; i++) {
                int fator = m[i][k];
                for (int j = k; j < p; j++) {
                    m[i][j] = m[i][j] - fator * m[k][j];
                }
            }
        }
        return m;

    }

}
