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
        int[]elementos1 = new int[n];
        for (int i = 0; i<n; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos1[i] = scan.nextInt();
        }

        //Aplicação dos metódos da classe Matrix:
        Matrix mA = new Matrix(linhas, colunas, elementos1);
        mA.print();
        System.out.println("Indique a linha do elemento a ser alterado:");
        int l = scan.nextInt();
        l = l - 1;
        System.out.println("Indique a coluna do elemento a ser alterado:");
        int c = scan.nextInt();
        c = c - 1;
        System.out.println("Indique o novo valor a ser escolhido:");
        int e = scan.nextInt();
        mA.set(l, c, e);
        mA.print();
        System.out.println("O valor foi alterado para:" + mA.get(l,c));

        // Aplicação dos metodos da classe Linear Algebra (Matriz Times):
        System.out.println("Escolha um valor para multiplicar a matriz que você criou:");
        int escalar = scan.nextInt();
        Matrix timesM = LinearAlgebra.times(escalar, mA);
        timesM.print();

        // Aplicação dos metodos da classe Linear Algebra (Matriz Gauss):
        System.out.println("Realizando a eliminação de Gauss:");
        Matrix gauss = LinearAlgebra.gauss(mA);
        mA.print();

        //Coleta de dados ao usuário Vetor
        System.out.println("Informe a dimensão do seu vetor: ");
        int dim = scan.nextInt();
        int [] elementos2 = new int[dim];
        for (int i = 0; i<dim; i++) {
            System.out.println("Informe o " + (i+1) + "º elemento: ");
            elementos2[i] = scan.nextInt();
        }

        //Aplicação dos metódos da classe Vector:
        Vector vA = new Vector(dim, elementos2);
        System.out.println("Vetor construído: " );
        vA.print();
        System.out.println("Informe a posição do elemento que você quer alterar:");
        int i = scan.nextInt();
        i = i-1;
        System.out.println("Informe o valor que você quer inserir:");
        int valor = scan.nextInt();
        vA.set(i, valor);
        vA.print();
        System.out.println("O valor foi alterado para:" + vA.get(i));

        //Aplicação dos metodos da classe Linear Algebra (Vetor Times):
        System.out.println("Escolha um valor para multiplicar o vetor que você criou:");
        int escalarV = scan.nextInt();
        Vector timesV = LinearAlgebra.times(escalarV, vA);
        timesV.print();

    }

}
