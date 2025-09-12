public class LinearAlgebra {

    //Metodo times matriz
    public static Matrix times(int escalar, Matrix a) { // ajeitar para a possibilidade de entrada de uma matriz
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

    public static Matrix gauss (Matrix a) {
        //Matriz Cópia
        double [] elementosOriginais = new double [a.linhas*a.colunas];
        int k = 0;
        for(int i = 0; i < a.linhas; i++) {
            for(int j = 0; j < a.colunas; j++) {
                elementosOriginais[k++] = a.get(i, j);
            }
        }
        Matrix m = new Matrix(a.linhas, a.colunas, elementosOriginais);

        //Passar por cada coluna para zerar os elementos abaixo da diagonal
        int pivoLinha = 0;

        for (int j = 0; j < m.colunas && pivoLinha < m.linhas; j++) {
            // Encontrar a linha com maior valor em módulo
            int maxLinha = pivoLinha;
            for (int i = pivoLinha + 1; i < m.linhas; i ++) {
                if (Math.abs(m.get(i,j)) > Math.abs (m.get(maxLinha,j))) {
                    maxLinha = i;
                }
            }
            //Trocar a linha do pivô com a linha de maior valor
            for (int n = j; n < m.colunas; n ++) {
                double aux = m.get(pivoLinha,n);
                m.set(pivoLinha, n, m.get(maxLinha,n));
                m.set(maxLinha, n, aux);
            }

            // Se o pivo for zero pula para a prx linha
            if (Math.abs(m.get(pivoLinha, j)) <= 1e-10) {
                continue;
            }

            //Zerar todos os elementos abaixo da coluna abaixo do pivo
            for (int i = pivoLinha + 1; i < m.linhas; i++) {
                //Saber o fator q vai multiplicar a linha
                double fator = m.get(i, j) / m.get(pivoLinha, j);

                //Subtrair a linha pela linha multiplicada pelo fator
                for (int col = j; col < m.colunas; col++) {
                    double novoValor = m.get(i, col) - fator * m.get(pivoLinha, col);
                    m.set(i, col, novoValor);
                }
            }
            pivoLinha++;
        }
        return m;
    }
}