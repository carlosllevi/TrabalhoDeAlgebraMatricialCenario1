public class Main {

    public static void main(String[] args) {

        // matriz 2x2 com os elementos 1,2,3,4

        int linhas = 2;
        int colunas = 2;
        int [] elementos = {1,2,3,4};

        //chamamos nossa matriz\

        Matrix matriz = new Matrix();

        //utilizamos o metodo construtor paraq construir a matriz

        matriz.construtor(linhas, colunas, elementos);
        matriz.print();

        //pula linha

        System.out.println();

        // definimos um novo valor para o elemento 1,1

        matriz.set(1,1,10);
        matriz.print();

        //pula linha

        System.out.println();

        //localizamos o elemento 1,1

        System.out.println(matriz.get(1,1));

        System.out.println("Classe Vetor");

        //Classe Vector

        Vector vetor = new Vector();
        int [] elementosVetor = {1,2,3,4,5};

        vetor.construtor(5, elementosVetor);
        vetor.print();
        System.out.println("Definindo o elemento 1, para 10");

        vetor.set(1,10);
        vetor.print();
        System.out.println("Apresentando o novo elemento 1");

        System.out.println(vetor.get(1));

    }

}
