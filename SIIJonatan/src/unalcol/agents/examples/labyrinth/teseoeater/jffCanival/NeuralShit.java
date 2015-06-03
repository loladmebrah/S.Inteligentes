package unalcol.agents.examples.labyrinth.teseoeater.jffCanival;

import java.util.ArrayList;
import java.util.Random;

public class NeuralShit {
    
    int m_numNeurHidden;
    
    double[] m_input;
    ArrayList<Double> m_neurHidden;
    double m_output;
    
    ArrayList<Double> m_inputWeight;
    double[] m_outputWeight;
    
    
    public NeuralShit(int numNeurHidden) {
        this.m_numNeurHidden = numNeurHidden;
        m_neurHidden = new ArrayList(this.m_numNeurHidden);
        m_inputWeight = new ArrayList(this.m_numNeurHidden*4);
        m_input = new double[4];
        m_outputWeight = new double [m_numNeurHidden];
        initWeigths();
    }
    
    public void propageichion(boolean[] a){
        m_neurHidden.get(m_inputWeight.size() % m_numNeurHidden.size())=a[]*m_inputWeight.get();
        
    }
    
    private double sigma(double a, double p){
        return (1/(1+ Math.exp(-a/1.0)));
    }
    
    private double aleatorio(){
        Random rofl = new Random();
        return rofl.nextDouble();
    }

    private void initWeigths() {
        for(int i = 0; i<m_numNeurHidden*4; i++){
            m_inputWeight.add(aleatorio());
        }
        for(int i =0; i<m_numNeurHidden; i++){
            m_outputWeight[i]=aleatorio();
        }
    }
    
}
