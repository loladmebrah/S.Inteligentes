package unalcol.agents.examples.labyrinth.teseoeater.jffCanival;

import java.util.ArrayList;
import java.util.Random;

public class NeuralShit {
    
    int m_numNeurHidden;
    double p = 1.0;
    //double[] m_input;
    ArrayList<Double> m_neurHidden;
    double m_output;
    double learning_v;
    double error;
    ArrayList<Double> m_inputWeight;
    double[] m_outputWeight;
    
    
    public NeuralShit(int numNeurHidden) {
        this.learning_v = 0.01;
        this.m_numNeurHidden = numNeurHidden;
        m_neurHidden = new ArrayList(this.m_numNeurHidden);
        m_inputWeight = new ArrayList(this.m_numNeurHidden*4);
        //m_input = new double[4];
        m_outputWeight = new double [m_numNeurHidden];
        initWeigths();
        initHidden();
        this.p = 1.0;
    }
    
    private void propageichion(boolean[] a){
      
        for (int i =0; i<m_inputWeight.size(); i++){
            m_neurHidden.set(i % m_numNeurHidden,m_neurHidden.get(i % m_numNeurHidden) + m_inputWeight.get(i)*(getValueA(a[(int)i/4])));  
        }
        for(int i = 0; i<m_numNeurHidden; i++){
            m_output = m_output + m_outputWeight[i] * sigma(m_neurHidden.get(i),p);
        }
          m_output = sigma(m_output,p); 
    }
    
    public void tablaTraining(double answer, boolean []inputs){
        /*
            1. provide inputs with answer
            2. Ask neuralshit to give an answer
            3. compute error
            4. Adjust all weights using error 
        */
         /*
            nuevo peso =  peso +Apeso
            Apeso = Error * Input
            
            1. Adquire error
            2. change IW acordly
            3. Adquire error
            4. Change OW acordly
            5. rinse and repeat
        */
        propageichion(inputs);
        error = answer - m_output;
        retropropageichion(answer,error,inputs);    
    }
    
    private void retropropageichion(double ans,double err, boolean[]a){
        while(err>0.01){
            for (int i =0; i<m_inputWeight.size(); i++){
                m_inputWeight.set(i, m_inputWeight.get(i) + learning_v * err * getValueA(a[(int)i/4])); // i'm not even sure dude
                m_neurHidden.set(i % m_numNeurHidden,m_neurHidden.get(i % m_numNeurHidden) + m_inputWeight.get(i)*(getValueA(a[(int)i/4])));  
            }
            for(int i = 0; i<m_numNeurHidden; i++){
                m_outputWeight[i] = m_outputWeight[i] + learning_v * err *getValueA(a[(int)i/4]); // im not even sure
                m_output = m_output + m_outputWeight[i] * sigma(m_neurHidden.get(i),p);
            }          
            m_output = sigma(m_output,p); 
            err = ans - m_output;
            
        }
    }
    
    private double sigma(double a, double p){
        return (1/(1+ Math.exp(-a/p)));
    }
    
    private double aleatorio(){
        Random rofl = new Random();
        if(Math.random() > 0.49){
            return rofl.nextDouble();
        }else{
        return rofl.nextDouble()* -1 ;
        }    
    }

    private void initWeigths() {
        for(int i = 0; i<m_numNeurHidden*4; i++){
            m_inputWeight.add(aleatorio());
        }
        for(int i =0; i<m_numNeurHidden; i++){
            m_outputWeight[i]=aleatorio();
        }
    }

    private Double getValueA(boolean a) {
        if(a)
         return 0.9;
        
        return 0.1;
    }

    private void initHidden() {
        for(int i = 0; i<m_numNeurHidden; i++){
            m_neurHidden.add(0.0);
        }
    }
    
}
