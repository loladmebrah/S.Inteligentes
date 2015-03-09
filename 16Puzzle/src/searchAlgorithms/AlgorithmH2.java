package searchAlgorithms;

import java.util.ArrayList;

public class AlgorithmH2 extends AbstractAlgorithm{
    
    private Node s;
    public static ArrayList<Integer> Path;
    private boolean sol;
    
    public AlgorithmH2(int[] seed) {
        super(seed);
        
        Path = new ArrayList<>();
        this.getQueue().add(new Node(0, seed, null, -1));
    }

    @Override
    public void Search() {
        Node aux;
        do{
            //System.out.println(this.getQueue().size());
            
            aux = this.getQueue().remove();
            sol = aux.isSolution();
            
            if(sol){
                System.out.println(this.getQueue().size());
                s = aux;
            }
            else
                this.expand(aux);
        }while(!sol);
        result();
    }

    @Override
    public void result() {
        s.thePathH2();
        System.out.println(AlgorithmH2.Path.toString());
    }

    private void expand(Node aux) {
        byte mov = aux.posibleMoves();
        Node nu;
        int pH = aux.pesoHoja();
        if((mov & 1) == 0){
            nu = new Node(Node.manhattan(aux.newSeed(0), pH), aux.newSeed(0), aux, 0);
            this.getQueue().add(nu);
        }
        if((mov & 2) == 0){
            nu = new Node(Node.manhattan(aux.newSeed(1), pH), aux.newSeed(1), aux, 1);
            this.getQueue().add(nu);
        }
        if((mov & 4) == 0){
            nu = new Node(Node.manhattan(aux.newSeed(2), pH), aux.newSeed(2), aux, 2);
            this.getQueue().add(nu);
        }
        if((mov & 8) == 0){
            nu = new Node(Node.manhattan(aux.newSeed(3), pH), aux.newSeed(3), aux, 3);
            this.getQueue().add(nu);
        }
    }
}
