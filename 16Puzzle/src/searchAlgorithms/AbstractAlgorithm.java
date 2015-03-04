package searchAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public abstract class AbstractAlgorithm {
    
    private PriorityQueue<Node> queue;
    private int[] originSeed;
    
    public AbstractAlgorithm(int[] seed) {
        this.originSeed = seed;
        this.queue = new PriorityQueue<>();
    }
    
    public abstract void Search();
    
    public abstract void result();
    
    public void print(){
        System.out.println(Arrays.toString(this.originSeed));
    }

    public void setOriginSeed(int[] originSeed) {
        this.originSeed = originSeed;
    }

    public void setQueue(PriorityQueue<Node> queue) {
        this.queue = queue;
    }

    public int[] getOriginSeed() {
        return originSeed;
    }

    public PriorityQueue<Node> getQueue() {
        return queue;
    }
    
    
}
