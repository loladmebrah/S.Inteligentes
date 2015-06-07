package unalcol.agents.examples.labyrinth.teseoeater.jffEater.addons;

import java.util.ArrayList;
import java.util.Random;

public class NNGeneral {
    
    int m_numNeurHidden;
    double p = 1.0;
    //double[] m_input;
    ArrayList<Double> m_neurHidden;
    double m_output;
    double learning_v;
    double error;
    ArrayList<Double> m_inputWeight;
    double[] m_outputWeight;
    
    
    public NNGeneral(int numNeurHidden) {
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

    /**
     * Init values for the number of neurons
     * [0] = input
     * [1] = hidden
     * [2] = output
     */
    int[] m_numN;
    
    /**
     * Arrays of neurons
     */
    ArrayList<Double> m_hid;
    ArrayList<Double> m_out;
    
    /**
     * Arrays of weights
     */
    ArrayList<Double> m_inW;
    ArrayList<Double> m_outW;
    
    /**
     * Sigma formula to use
     */
    Sigma m_sig;
    
    /**
     * Constructor with he number of neurons for input, hiddenLayer, and output 
     * @param input 
     * @param hidden
     * @param output 
     */    
    public NNGeneral(int input, int hidden, int output) {
        m_numN = new int[3];
        m_numN[0] = input;
        m_numN[1] = hidden;
        m_numN[2] = output;
        
        m_sig = new SSigmoid();
        init();
        
    }
    
    /**
     * Function to initialize the neurons and weights
     */
    private void init(){
        initArray(m_numN[1], m_hid);
        initArray(m_numN[2], m_out);
        
        Random rand = new Random();
        
        initArray(m_numN[0] * m_numN[1], m_inW, rand);
        initArray(m_numN[1] * m_numN[2], m_outW, rand);
    }
    
    /**
     * Function that initialize the arrays of neurons, with values of 0
     * @param n 
     * @param array 
     */
    private void initArray(int n, ArrayList array){
        for(int i = 0; i < n; i++){
            boolean add = array.add(0.0);
            if(!add) i--;
        }
    }
    
    private void initArray(int n, ArrayList array, Random rand){
        for(int i = 0; i < n; i++){
            boolean add = array.add(rand.nextDouble());
            if(!add) i--;
        }
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
