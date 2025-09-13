import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Coleta de dados ao usuário (Matriz)
        System.out.println("Informe o número de LINHAS da matriz que você quer criar:");
        int linhas = scan.nextInt();
        System.out.println("Informe o número de COLUNAS da matriz que você quer criar:");
        int colunas = scan.nextInt();
        int n = linhas*colunas;
        double[]elementos1M = new double[n];
        for (int i = 0; i<n; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos1M[i] = scan.nextInt();
        }
        System.out.println(" ");

        //Aplicação dos metódos da classe Matrix:
        Matrix mA = new Matrix(linhas, colunas, elementos1M);
        mA.print();
        System.out.println(" ");
        System.out.println("Indique a linha do elemento a ser alterado:");
        int l = scan.nextInt();
        l = l - 1;
        System.out.println("Indique a coluna do elemento a ser alterado:");
        int c = scan.nextInt();
        c = c - 1;
        System.out.println("Indique o novo valor a ser escolhido:");
        int e = scan.nextInt();
        mA.set(l, c, e);
        System.out.println(" ");
        mA.print();
        System.out.println(" ");
        System.out.println("O valor foi alterado para:" + mA.get(l,c));

        // 1. Aplicação dos metodos da classe Linear Algebra (Matriz Transposta): Giovana
        System.out.println("Aplicação do método Matriz Transposta:");
        Matrix transposta = LinearAlgebra.transpose(mA);
        System.out.println(" ");
        transposta.print();
        System.out.println(" ");

        // 2. Aplicação dos metodos da classe Linear Algebra (Matriz Sum): Sophia
        System.out.println("Aplicação do metódo Sum para Matriz");
        System.out.println("Para isso precisamos construir outra matriz");
        double[]elementos2M = new double[n];
        for (int i = 0; i<n; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos2M[i] = scan.nextInt();
        }
        Matrix mB = new Matrix(linhas, colunas, elementos2M);
        System.out.println(" ");
        mB.print();
        System.out.println(" ");
        Matrix sum = LinearAlgebra.sum(mA, mB);
        System.out.println("Após fazer a soma:");
        sum.print();
        System.out.println(" ");

        // 3. Aplicação dos metodos da classe Linear Algebra (Matriz Times): Levi
        System.out.println("Escolha um valor para multiplicar a matriz que você criou:");
        int escalar = scan.nextInt();
        Matrix timesM = LinearAlgebra.times(escalar, mA);
        timesM.print();
        System.out.println(" ");

        // 4. Dot Rafael
        System.out.println("Utilizando método dot:");
        System.out.println("Informe o número de LINHAS da matriz C que você quer criar:");
        int linhasC = scan.nextInt();
        System.out.println("Informe o número de COLUNAS da matriz C que você quer criar:");
        int colunasC = scan.nextInt();
        int nC = linhasC*colunasC;
        double[]elementos3M = new double[nC];
        for (int i = 0; i<n; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos3M[i] = scan.nextInt();
        }
        Matrix mC = new Matrix(linhasC, colunasC, elementos3M);
        mC.print();
        System.out.println(" ");
        Matrix dotM = LinearAlgebra.dot(mA,mC);
        System.out.println("Resultado:");
        dotM.print();
        System.out.println(" ");

        // 5. Aplicação dos metodos da classe Linear Algebra (Matriz Gauss): Levi
        System.out.println("Realizando a eliminação de Gauss:");
        Matrix gauss = LinearAlgebra.gauss(mA);
        gauss.print();
        System.out.println(" ");

        // 6. Solve Thais

        Vector solve = LinearAlgebra.solve(mA);
        System.out.println("Matriz após o solve:");
        solve.print();
        System.out.println(" ");

        //Coleta de dados ao usuário Vetor
        System.out.println("Informe a dimensão do seu vetor: ");
        int dim = scan.nextInt();
        int [] elementos1V = new int[dim];
        for (int i = 0; i<dim; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos1V[i] = scan.nextInt();
        }

        //Aplicação dos metódos da classe Vector:
        Vector vA = new Vector(dim, elementos1V);
        System.out.println("Vetor construído: " );
        vA.print();
        System.out.println(" ");
        System.out.println("Informe a posição do elemento que você quer alterar:");
        int i = scan.nextInt();
        i = i-1;
        System.out.println("Informe o valor que você quer inserir:");
        int valor = scan.nextInt();
        vA.set(i, valor);
        vA.print();
        System.out.println(" ");
        System.out.println("O valor foi alterado para:" + vA.get(i));

        //Aplicação dos metodos da classe Linear Algebra (Vetor tranposto):
        System.out.println("O vetor transposto é:");
        Vector transposto = LinearAlgebra.transpose(vA);
        for (int m=0; m<vA.dim; m++) {
            System.out.println(transposto.get(m));
        }
        System.out.println(" ");

        //Aplicação dos metodos da classe Linear Algebra (Vetor Sum):
        System.out.println("Aplicação do metódo Sum para Vetor");
        System.out.println("Para isso precismaos construir um novo vetor:");
        int [] elementos2V = new int[dim];
        for (int j = 0; j<dim; j++) {
            System.out.println("Informe o " + (j+1) + "º elemento: ");
            elementos2V[i] = scan.nextInt();
        }
        System.out.println(" ");
        Vector vB = new Vector(dim, elementos2V);
        Vector sumV = LinearAlgebra.sum(vA,vB);
        System.out.println("O resultado da soma dos vetores são: " );
        sumV.print();
        System.out.println(" ");

        //Aplicação dos metodos da classe Linear Algebra (Vetor Times):
        System.out.println("Escolha um valor para multiplicar o vetor que você criou:");
        int escalarV = scan.nextInt();
        Vector timesV = LinearAlgebra.times(escalarV, vA);
        timesV.print();

    }

}