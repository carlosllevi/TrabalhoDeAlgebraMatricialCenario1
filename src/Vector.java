public class Vector {

    int dim;
    int [] vetor;

    //Construtor Vetor
    public Vector(int dim, int [] elementos) {
        this.dim = dim;
        vetor = new int[dim];
        for (int i = 0; i<dim; i++) {
            vetor[i] = elementos [i];
        }
    }

    //Metodo Get
    public int get (int i) {
        return vetor[i];
    }

    //Metodo Set
    public void set (int i, int valor) {
        vetor [i] = valor;
    }

    //Metodo Print do Vetor
    public void print () {
        for (int i = 0; i < dim; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

}
