package searchAlgorithms;

import java.util.ArrayList;

public class AlgorithmH1 extends AbstractAlgorithm{

    private Node s;
    public static ArrayList<Integer> Path;
    private boolean sol;
    
    public AlgorithmH1(int[] seed) {
        super(seed);
        
        Path = new ArrayList<>();
    }

    @Override
    public void Search() {
        Node aux;
        do{
            System.out.println(this.getQueue().size());
            
            aux = this.getQueue().remove();
            sol = aux.isSolution();
            
            if(sol){
                s = aux;
            }
            else
                this.expand(aux);
        }while(!sol);
        result();
    }

    @Override
    public void result() {
        s.thePathH1();
        System.out.println(AlgorithmH1.Path.toString());
    }

    private void expand(Node aux) {
        byte mov = aux.posibleMoves();
        Node nu;
        if((mov & 1) == 0){
            nu = new Node(1, aux.newSeed(0), aux, 0);
            this.getQueue().add(nu);
        }
        if((mov & 2) == 0){
            nu = new Node(1, aux.newSeed(1), aux, 1);
            this.getQueue().add(nu);
        }
        if((mov & 4) == 0){
            nu = new Node(1, aux.newSeed(2), aux, 2);
            this.getQueue().add(nu);
        }
        if((mov & 8) == 0){
            nu = new Node(1, aux.newSeed(3), aux, 3);
            this.getQueue().add(nu);
        }
    }
    
}
