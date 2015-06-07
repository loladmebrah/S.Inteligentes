package unalcol.agents.examples.labyrinth.teseoeater.jffEater.addons;

public class SSigmoid implements Sigma{

    @Override
    public double sigmaVal(double a, double p) {
        return (1/(1+ Math.exp(-a/p)));
    }
    
}
