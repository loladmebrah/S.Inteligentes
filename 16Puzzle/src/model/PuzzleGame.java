package model;

import java.util.Random;

public class PuzzleGame {
    
    private int[][] m_matrix;
    //private int[] m_array;
    
    private int m_x;
    private int m_y;
    
    public PuzzleGame(int n) {
        initialState(n);
    }
    
    private boolean moveLeft(){
        if(m_y > 0){
            changeWith(0, -1);
            return true;
        }
        else
            return false;
    }
    
    private boolean moveRight(){
        if(m_y < m_matrix.length - 1){
            changeWith(0, 1);
            return true;
        }
        else
            return false;
    }
    
    private boolean moveUp(){
        if(m_x > 0){
            changeWith(-1, 0);
            return true;
        }
        else
            return false;
    }
    
    private boolean moveDown(){
        if(m_x < m_matrix.length - 1){
            changeWith(1, 0);
            return true;
        }
        else
            return false;
    }

    private void initialState(int n) {
        m_matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n; j++){
                m_matrix[i][j-1] = (i*n + j);
            }
        }
        m_matrix[n-1][n-1] = -1;
        m_x = n-1;
        m_y = n-1;
        /*
        m_array = new int[n*n];
        for(int i = 0; i < n*n; i++){
            m_array[i] = i+1;
        }
        m_array[n*n - 1] = -1;
        m_x = n*n - 1;
        */
    }
    
    protected void printThis(){
        for (int i = 0; i < m_matrix.length; i++) {
            for (int j = 0; j < m_matrix.length; j++) {
                System.out.print(m_matrix[i][j] + " ");
            }
            System.out.println();
        }
        /*
        for (int i = 0; i < m_array.length; i++) {
            System.out.print(m_array[i] + " ");
            if(i % Math.sqrt(m_array.length))
                System.out.println();
        }
        */
    }

    private void changeWith(int i, int i0) {
        m_x += i;
        m_y += i0;
        m_matrix[m_x - i][m_y - i0] = m_matrix[m_x][m_y];
        m_matrix[m_x][m_y] = -1;
    }
    
    public void scramble(int n) {
        Random rand = new Random();
        double aux;
        byte lastMove = 0;
        for(int i = 0; i < n; i++){
            aux = rand.nextDouble();
            //System.out.println(aux);
            if((aux < 0.25) && ((lastMove & 8) != 8)){
                System.out.println("r");
                if(!moveRight()){
                    System.out.println("right");
                    i --;
                }else{
                    lastMove = 0;
                    lastMove |= 2;
                }
            }else
            if(aux < 0.5 && ((lastMove & 4) != 4)){
                System.out.println("u");
                if(!moveUp()){
                    System.out.println("up");
                    i --;
                }else{
                    lastMove = 0;
                    lastMove |= 1;
                }
            }else
            if(aux < 0.75 && ((lastMove & 2) != 2)){
                System.out.println("l");
                if(!moveLeft()){
                    System.out.println("left");
                    i --;
                }else{
                    lastMove = 0;
                    lastMove |= 8;
                }
            }
            else
            if((lastMove & 1) != 1){
                System.out.println("d");
                if(!moveDown()){
                    System.out.println("down");
                    i --;
                }else{
                    lastMove = 0;
                    lastMove |= 4;
                }
            }
                
        }
    }
    
    public int[] getSeed() {
        int[] seed = new int[m_matrix.length * m_matrix.length];
        for (int i = 0; i < m_matrix.length; i++) {
            for (int j = 0; j < m_matrix.length; j++) {
                seed[i*m_matrix.length + j] = m_matrix[i][j];
            }
        }
        return seed;
    }
    
    public int[][] getSeeds(int n) {
        int[][] seeds =  new int[n][m_matrix.length * m_matrix.length];
        for (int i = 0; i < seeds.length; i++) {
            this.scramble(15);
            seeds[i] = this.getSeed();
        }
        return seeds;
    }
}
