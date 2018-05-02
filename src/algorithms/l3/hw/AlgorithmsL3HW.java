/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package algorithms.l3.hw;

import java.util.Random;

/**
 *
 * @author Yuri Tveritin
 */
public class AlgorithmsL3HW {
    
    public static void main(String[] args) {
       ex5(createArray(20));
       
    
    }
    
    /**
     * Задание 5. **Реализовать сортировку вставками, используя бинарный поиск.
     */
    
    
    /**
     * Метод  создания массива заданного размера с случайным 
     * заполнением 
     * @param n 
     */
    static int[] createArray(int n){
        int[] ar;
        ar=new int[n];
        Random rand=new Random ();
        for (int i = 0; i < n; i++) {
            ar[i]=rand.nextInt(n);
            System.out.print(ar[i]+" ");
            
        }
        return ar;
    }
    
    static void ex5(int[] array){
        for (int i = 0; i < array.length; i++) {
            int temp =array[i];
            int j=i;
            while(j>0){ 
                if (temp<array[j-1]){
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }                
                j--;
            }
        }
        System.out.println();
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+ " ");
            
        }
    }
    
    
    
}
