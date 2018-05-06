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
//       int[] ar2={1, 4, 2, 0, 1, 6, 2, 0};
       System.out.println();
//       ex5bin(createArray(15));
//       ex5bin(ar2);
       
    
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
    /**
     * Метод, печатающий отсортированный вставками массив, поданный на вход
     * @param array 
     */
    
    static void ex5(int[] array){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            int temp =array[i];
            int j=i;
            while(j>0){ 
                if (temp<array[j-1]){
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }                
                count++;
                j--;
            }
        }
        System.out.println("Count="+count);
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+ " ");
            
        }
    }
    /**
     * Метод (оптимизированный бинарным поиском), возвращающий отсортированный 
     * вставками массив, поданный на вход
     * @param array 
     */
    static void ex5bin(int[] array){
        
        
        
        for (int i = 0; i < array.length; i++) {//бежим по всему массиву
            
            int temp =array[i];
            int j=i;
            if (j>0){//делаем для элементов массива начиная со второго 
                if (temp<array[j-1]){//если элемент меньше предыдущего
                    int lp=0;//самый левый элемент
                    int rp=j-1;//самый правый элемент
                    int cp=lp+(rp-lp)/2;
                    if ((rp-lp)<2){
                        array[j]=array[j-1];
                        array[j-1]=temp;
                    }
                    while(2<=(rp-lp)&array[cp]!=temp){
                        if (array[cp]>temp){
                            rp=cp-1;
                            cp=lp+(rp-lp)/2;                            
                        }
                        else{
                            lp=cp+1;
                            cp=lp+(rp-lp)/2; 
                        }
                    }
                    if(array[cp]==temp){
                        for (int k = j; k >= cp+1; k--) {
                           array[k]=array[k-1]; 
                        }
                    }
                    else{
                        if((rp-cp)==1){
                            for (int k = j; k > cp+1; k--) {
                                array[k]=array[k-1]; 
                            }   
                        array[cp+1]=temp;
                        }
                        if((cp-lp)==1){
                            for (int k = j; k > cp-1; k--) {
                                array[k]=array[k-1]; 
                            }
                            array[cp-1]=temp;
                        }
                    }              
                }                
//                j--;
            }
        }
        System.out.println();
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+ " ");
            
        }
    }
    
    
}
