public class LinearAlgebra {

    //1.  Metodo para transpor uma matriz
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
    public static Vector transpose(Vector a) {
        int dim = a.dim;
        int[] novaArrayElementos = new int[dim];
        for (int i = 0; i < dim; i++) {
            novaArrayElementos[i] = a.get(i);
        }
        return new Vector(dim, novaArrayElementos);
    }

    //2. Metodo sum
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

    // Metodo dot matriz
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

    //Metodo Gauss

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

    // Solve
    public static Vector solve(Matrix a) {
        // Verificar se a matriz é válida
        if (a.colunas < 2) {
            throw new IllegalArgumentException("Matriz aumentada deve ter pelo menos 2 colunas");
        }

        if (a.linhas != a.colunas - 1) {
            throw new IllegalArgumentException("Matriz deve ser quadrada aumentada");
        }

        // PASSO 1: Aplicar eliminação gaussiana (método gauss)
        Matrix matrizEscalonada = gauss(a);

        // PASSO 2: Aplicar eliminação acima da diagonal (Gauss-Jordan)
        // "Inverter os índices" - eliminar de baixo para cima
        for (int i = matrizEscalonada.linhas - 1; i >= 0; i--) {
            // Verificar se o pivô não é zero
            if (Math.abs(matrizEscalonada.get(i, i)) <= 1e-10) {
                continue; // Pular se  o pivô for zero
            }

            // Normalizar a linha do pivô (fazer o pivô = 1)
            double pivo = matrizEscalonada.get(i, i);
            for (int j = 0; j < matrizEscalonada.colunas; j++) {
                double novoValor = matrizEscalonada.get(i, j) / pivo;
                matrizEscalonada.set(i, j, novoValor);
            }

            // Eliminar elementos acima do pivô
            for (int k = 0; k < i; k++) {
                double fator = matrizEscalonada.get(k, i);

                for (int j = 0; j < matrizEscalonada.colunas; j++) {
                    double novoValor = matrizEscalonada.get(k, j) - fator * matrizEscalonada.get(i, j);
                    matrizEscalonada.set(k, j, novoValor);
                }
            }
        }

        // PASSO 3: Extrair apenas a última coluna (solução)
        int n = matrizEscalonada.linhas;
        int ultimaColuna = matrizEscalonada.colunas - 1;
        int[] solucao = new int[n];

        for (int i = 0; i < n; i++) {
            // Pegar o valor da última coluna (depois do "pontilhamento")
            solucao[i] = (int) Math.round(matrizEscalonada.get(i, ultimaColuna));
        }

        return new Vector(n, solucao);
    }

    // Metodo auxiliar para ver a matriz após Gauss-Jordan (para debug)
    public static Matrix gaussJordan(Matrix a) {
        // Aplicar Gauss primeiro
        Matrix matriz = gauss(a);

        // Depois eliminar acima da diagonal (Jordan)
        for (int i = matriz.linhas - 1; i >= 0; i--) {
            if (Math.abs(matriz.get(i, i)) <= 1e-10) {
                continue;
            }

            // Normalizar linha
            double pivo = matriz.get(i, i);
            for (int j = 0; j < matriz.colunas; j++) {
                double novoValor = matriz.get(i, j) / pivo;
                matriz.set(i, j, novoValor);
            }

            // Eliminar acima
            for (int k = 0; k < i; k++) {
                double fator = matriz.get(k, i);
                for (int j = 0; j < matriz.colunas; j++) {
                    double novoValor = matriz.get(k, j) - fator * matriz.get(i, j);
                    matriz.set(k, j, novoValor);
                }
            }
        }

        return matriz;
    }
}