public class LinearAlgebra {

    //Transpose Matrix
    public static Matrix transpose(Matrix a) {
        int linhas = a.linhas;
        int colunas = a.colunas;
        double[] novaArrayElementos = new double[linhas * colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int novoIndice = j * linhas + i;
                double elementoOriginal = a.get(i, j);

                novaArrayElementos[novoIndice] = elementoOriginal;
            }
        }
        return new Matrix(colunas, linhas, novaArrayElementos);
    }
    public static Matrix transposeV(Vector a) {
        int dim = a.dim;
        double [] elementos = new double [dim];
        int k = 0;
        for (int i = 0; i< a.dim; i++) {
            elementos [k] =  a.get(i);
            k++;
        }
        return new Matrix(dim,1, elementos);
    }

    //Sum Matrix
    public static Matrix sum(Matrix a, Matrix b){
        double [] elementos = new double [a.linhas*a.colunas];
        int k = 0;
        for (int i = 0; i < a.linhas; i++){
            for (int j = 0; j < a.colunas; j++){
                elementos[k] = a.get(i,j) + b.get(i,j);
                k++;
            }
        }
        return new Matrix(a.linhas, a.colunas, elementos);
    }

    public static Vector sum(Vector a, Vector b){
        int [] elementos = new int[a.dim];
        int k = 0;
        for (int i = 0; i < a.dim; i++){
            elementos [k] = a.get(i) + b.get(i);
            k++;
        }
        return new Vector(a.dim, elementos);
    }

    //Dot Matrix
    public static Matrix dot(Matrix a,Matrix b) {
        Matrix c = new Matrix(a.linhas, b.colunas);

        for (int i = 0; i < c.linhas; i++) {
            for (int j = 0; j < c.colunas; j++) {

                int soma = 0;

                for (int k = 0; k < a.colunas; k++) {
                    soma += a.matriz[i][k] + b.matriz[k][j];
                }

                c.matriz[i][j] = soma;
            }
        }
        return c;
    }

    //Times Matrix
    public static Matrix times(int escalar, Matrix a) {
        int i1 = a.linhas * a.colunas;
        double [] elementos = new double[i1];
        int k = 0;
        for (int i = 0; i< a.linhas; i++) {
            for (int j = 0; j < a.colunas; j++) {
                elementos [k] = escalar * a.get(i, j);
                k++;
            }
        }
        return new Matrix(a.linhas, a.colunas, elementos);
    }

    //Times Vector
    public static Vector times(int escalar, Vector a) {
        int [] elementos = new int [a.dim];
        int k = 0;
        for (int i = 0; i< a.dim; i++) {
            elementos [k] = escalar * a.get(i);
            k++;
        }
        return new Vector(a.dim, elementos);
    }

    //Gauss Matrix
    public static Matrix gauss (Matrix a) {

        double [] elementosOriginais = new double [a.linhas*a.colunas];
        int k = 0;
        for(int i = 0; i < a.linhas; i++) {
            for(int j = 0; j < a.colunas; j++) {
                elementosOriginais[k++] = a.get(i, j);
            }
        }
        Matrix m = new Matrix(a.linhas, a.colunas, elementosOriginais);

        int pivoLinha = 0;

        for (int j = 0; j < m.colunas && pivoLinha < m.linhas; j++) {

            int maxLinha = pivoLinha;
            for (int i = pivoLinha + 1; i < m.linhas; i ++) {
                if (Math.abs(m.get(i,j)) > Math.abs (m.get(maxLinha,j))) {
                    maxLinha = i;
                }
            }

            for (int n = j; n < m.colunas; n ++) {
                double aux = m.get(pivoLinha,n);
                m.set(pivoLinha, n, m.get(maxLinha,n));
                m.set(maxLinha, n, aux);
            }

            if (Math.abs(m.get(pivoLinha, j)) <= 1e-10) {
                continue;
            }

            for (int i = pivoLinha + 1; i < m.linhas; i++) {
                double fator = m.get(i, j) / m.get(pivoLinha, j);

                for (int col = j; col < m.colunas; col++) {
                    double novoValor = m.get(i, col) - fator * m.get(pivoLinha, col);
                    m.set(i, col, novoValor);
                }
            }
            pivoLinha++;
        }
        return m;
    }

    // Solve Matrix
    public static Matrix solve(Matrix a) {
        Matrix m = gauss(a);

        int linhas = m.linhas;
        int colunas = m.colunas;

        for (int i = linhas - 1; i >= 0; i--) {

            double pivo = m.get(i, i);

            if (Math.abs(pivo) <= 1e-10) {
                continue;
            }

            for (int j = i; j < colunas; j++) {
                m.set(i, j, m.get(i, j) / pivo);
            }

            for (int k = i - 1; k >= 0; k--) {
                double fator = m.get(k, i);

                for (int j = i; j < colunas; j++) {
                    double novoValor = m.get(k, j) - fator * m.get(i, j);
                    m.set(k, j, novoValor);
                }
            }
        }
        return m;
    }
}