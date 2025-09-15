public class Vector {

    int dim;
    int [] vetor;

    //Constructor Vector
    public Vector(int dim, int [] elementos) {
        this.dim = dim;
        vetor = new int[dim];
        for (int i = 0; i<dim; i++) {
            vetor[i] = elementos [i];
        }
    }

    //Getter
    public int get (int i) {
        return vetor[i];
    }

    //Setter
    public void set (int i, int valor) {
        vetor [i] = valor;
    }

    //Print Vector
    public void print () {
        for (int i = 0; i < dim; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

}
