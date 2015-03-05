/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queens;

public class CHSolution implements Solution {
    private Board Current;
    private Board Neighbor;
    private int runs;
    private int maxRun;
   
    
    public CHSolution(Board board, int maxRuns){
        this.Current = board;
        maxRun = maxRuns;
    }

    public Board search () {
         while(runs < maxRun){
             
            Neighbor = Current.generateNeighbor(); 
                if(Neighbor.getFitness()<=Current.getFitness()){
                 return Current;
                }
                
            Current = Neighbor;
                        
         }
         
        return Current;
    }
    
    
}
