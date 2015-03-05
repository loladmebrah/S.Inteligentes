/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queens;

/**
 *
 * @author USER
 */
public class Queens {

     public static void main(String[] args) {
        Board saSolution = new SASolution(new Board(),100000).search();
        Board gaSolution = new GASolution(30,0.4).search();
        Board CSPSolution = new CSPSolution().search();
    }
    
}
