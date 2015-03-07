package searchAlgorithms;

import java.util.Arrays;

public class Node implements Comparable<Node>{
    
    private Integer weight;
    private int[] seed;
    private Node father;
    private int moveFFather;
    
    public static final int[] sol = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,-1};

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(Integer weight, int[] seed, Node father, int moveFFather) {
        this.weight = weight;
        this.seed = seed;
        this.father = father;
        this.moveFFather = moveFFather;
    }
    
    public int[] getSeed() {
        return seed;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Node getFather() {
        return father;
    }
    
    @Override
    public int compareTo(Node o) {
        return weight.compareTo(o.weight);
    }

    @Override
    public String toString() {
        return weight.toString();
    }
    
    public byte posibleMoves(){
        int pos = Node.searchPos(seed, -1);
        byte tries = 0;
        if(pos/4 == 0)
            tries |= 1;
        else
            if(pos/4 == 3)
                tries |= 4;
        if(pos%4 == 3)
            tries |= 2;
        else
            if(pos%4 == 0)
                tries |= 8;
        return tries;
    }
    
    public boolean isSolution(){
        return Arrays.equals(seed, sol);
    }
    
    public int[] newSeed(int n){
        int[] aux;
        aux = Arrays.copyOf(this.getSeed(), this.getSeed().length);
        int pos = Node.searchPos(aux, -1);
        //System.out.println(pos + " - " + Arrays.toString(aux));
        if(n == 0){
            aux[pos] = aux[pos - 4];
            aux[pos - 4] = -1;
        }
        if(n == 1){
            aux[pos] = aux[pos + 1];
            aux[pos + 1] = -1;
        }
        if(n == 2){
            aux[pos] = aux[pos + 4];
            aux[pos + 4] = -1;
        }
        if(n == 3){
            aux[pos] = aux[pos - 1];
            aux[pos - 1] = -1;
        }
        return aux;
    }
    
    public void thePathIDS() {
        AlgorithmIDS.Path.add(this.moveFFather);
        if(this.moveFFather != -1)
            this.father.thePathIDS();
    }
    
    public void thePathH1() {
        AlgorithmH1.Path.add(this.moveFFather);
        if(this.moveFFather != -1)
            this.father.thePathH1();
    }
    
    
    public static int searchPos(int[] a, int k){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == k)
                return i;
        }
        return -1;
    }
 
   public static int manhattan(int seed [])
{
	int posllegada;
	int pesox;
	int pesoy;
	int pesoseed = 0;

	for (int i=0; i<=seed.length; i++)
	{
		posllegada= seed[i] - 1;
		pesox = Math.abs((posllegada/4) - (i/4));
		pesoy = Math.abs((posllegada%4) - (i%4));
		pesoseed = pesox+pesoy+pesoseed;

	}
	return pesoseed;

}

public static int rabioso(int seed [])
{
	int pesoseed = 0;

	for (int i=0; i<=seed.length; i++)
	{  
		if(!(seed[i]==(i+1)))
		{
			pesoseed=pesoseed+1;
		}
		 
	}
	return pesoseed;
}

public static int conflictolineal(int seed [])
{
	int posllegada;
	int pesox;
	int pesoy;
	int pesoseed = 0;

	for (int i=0; i<=seed.length; i++)
	{
		if(i<(seed.length-1))
		{
			if(!(((i%4)==3) && ((i+1)%4)==0))
			{
				if((seed[i]==(i+1)) && (seed[i+1]==(i)))
				{

					pesoseed= pesoseed+2;
				}
			}


		}

		posllegada=seed[i] - 1;
		pesox = Math.abs((posllegada/4) - (i/4));
		pesoy = Math.abs((posllegada%4) - (i%4));
		pesoseed = pesox+pesoy+pesoseed;

	}
	return pesoseed;

}
    
    public static int manJatan (int[] seed) {
        int cont = 0;
        for(int i = 0; i < seed.length; i++){
            
        }
    }
}
