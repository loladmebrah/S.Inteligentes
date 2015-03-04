package model;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import searchAlgorithms.AbstractAlgorithm;
import searchAlgorithms.AlgorithmIDS;

public class Main {
    
    public static void main(String[] args) {
        PuzzleGame game = new PuzzleGame(4);
        //game.scramble(15);
        //game.printThis();
        //System.out.println(Arrays.toString(game.getSeed()));
        //System.out.println(Arrays.deepToString(game.getSeeds(30)));
//        PriorityQueue<Node> lol = new PriorityQueue<>();
//        
//        lol.add(new Node(5));
//        lol.add(new Node(2));
//        
//        System.out.println(lol);
//        int[] test = new int[2];
//        test[0] = 1;
//        test[1] = 2;
//        
//        int[] test1 = new int[2];
//        test1[0] = 1;
//        test1[1] = 2;
//        
//        System.out.println(Arrays.equals(test, test1));

//        int[] lol;
//        lol = new int[] {1,1};
//        
//        System.out.println(Arrays.binarySearch(lol, 1));
        
//        byte lol = 0;
//        lol |= 4;
//        lol |= 2;
//        System.out.println(Integer.toBinaryString(lol) + " " + (lol & 1));
        
//        ArrayList<Integer> lol = new ArrayList<>();
//        
//        lol.add(1);
//        lol.add(2);
//        System.out.println(lol);
//        lol.add(1, 3);
//        System.out.println(lol);
//        
//        for (int i = 0; i < lol.size(); i++) {
//            System.out.println(lol.remove(i));
//        }
        //int[] rofl = {1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 10, 11, 13, 15, -1, 12};
        //int[] rofl7 = {1, 2, 3, 4, -1, 9, 7, 8, 6, 5, 15, 11, 13, 10, 14, 12};
        int[] rofl;
        //System.out.println(Arrays.binarySearch(rofl, 11));
        
        AbstractAlgorithm lol;
        //lol.Search();
        System.out.println(Time.valueOf(LocalTime.now()));
        for(int i = 0; i < 10; i++){
            System.out.println(" ");
            System.out.println("Iteración " + i + " :");
            game.scramble(15);
            rofl = game.getSeed();
            lol = new AlgorithmIDS(rofl);
            System.out.println("Seed problema: " + Arrays.toString(game.getSeed()));
            
            System.out.println("Tiempo Inicio: " + Time.valueOf(LocalTime.now()) + " <----------------");
            lol.Search();
            System.out.println("Tiempo Final: " + Time.valueOf(LocalTime.now()) + " <----------------");
        }
    }

}
