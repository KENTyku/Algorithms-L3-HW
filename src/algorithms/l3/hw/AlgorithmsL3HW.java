/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package algorithms.l3.hw;

import java.util.Random;

/**
 *
 * @author kentyku
 */
public class AlgorithmsL3HW {
    
    public static void main(String[] args) {
       createArray(100);
    
    }
    
    /**
     * Задание 5. **Реализовать сортировку вставками, используя бинарный поиск.
     */
    
    
    /**
     * Метод  создания массива заданного размера с случайным 
     * заполнением 
     * @param n 
     */
    static void createArray(int n){
        Integer[] ar;
        ar=new Integer[n];
        Random rand=new Random ();
        for (int i = 0; i < n; i++) {
            ar[i]=rand.nextInt(n);
            System.out.print(ar[i]+" ");
            
        }
    }
    
    static void ex5(Integer[] array){
        
    }
    
}
