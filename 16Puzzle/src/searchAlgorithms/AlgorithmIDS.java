package searchAlgorithms;

import java.util.ArrayList;

public class AlgorithmIDS extends AbstractAlgorithm{

    private boolean sol;
    private int w;
    private Node s;
    public static ArrayList<Integer> Path;
    
    private ArrayList<Node> list;
    
    public AlgorithmIDS(int[] seed) {
        super(seed);
        
        w = 0;
        list = new ArrayList<>();
        Path = new ArrayList<>();
        
        Node origin = new Node(w, seed, null, -1);
        this.getQueue().add(origin);
        list.add(origin);
        w++;
    }

    @Override
    public void Search() {
        do{
            System.out.println(list.size());
            for (Node n : list) {
                sol = n.isSolution();
                if(sol){
                    s = n;
                    break;
                }
            }
            if(!sol)
                this.expand();
        }while(!sol);
        result();
    }

    @Override
    public void result() {
        s.thePathIDS();
        System.out.println("Solucion: " + AlgorithmIDS.Path.toString());
    }

    private void expand() {
        int aux = this.getQueue().size();
        Node aux1;
        Node nu;
        int pos;
        byte mov;
        for (int i = 0; i < aux; i++) {
            aux1 = this.getQueue().remove();
            pos = list.indexOf(aux1);
            mov = aux1.posibleMoves();
            //System.out.println(Integer.toBinaryString(mov));
            if((mov & 1) == 0){
                nu = new Node(w, aux1.newSeed(0), aux1, 0);
                this.getQueue().add(nu);
                this.list.add(pos + 1, nu);
                w++;
            }
            if((mov & 2) == 0){
                nu = new Node(w, aux1.newSeed(1), aux1, 1);
                this.getQueue().add(nu);
                this.list.add(pos + 1, nu);
                w++;
            }
            if((mov & 4) == 0){
                nu = new Node(w, aux1.newSeed(2), aux1, 2);
                this.getQueue().add(nu);
                this.list.add(pos + 1, nu);
                w++;
            }
            if((mov & 8) == 0){
                nu = new Node(w, aux1.newSeed(3), aux1, 3);
                this.getQueue().add(nu);
                this.list.add(pos + 1, nu);
                w++;
            }
        }
    }

    
}
