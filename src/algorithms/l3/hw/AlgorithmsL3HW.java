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
//       ex5(createArray(20));
//       int[] ar2={1, 4, 2, 0, 1, 6, 2, 0};6 1 1 3 2 1 6 8 2 2
       int[] ar2={6, 1, 1, 3, 2, 1, 6, 8, 2, 2};
       for (int i = 0; i < ar2.length; i++) {            
            System.out.print(ar2[i]+" ");
            
        }
       System.out.println();
//       ex5bin(createArray(10));
       ex5bin(ar2);
       
    
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
        System.out.println();
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
            if (j<3){//для элементов массива до 3го
                while(j>0){ 
                    if (temp<array[j-1]){
                        array[j]=array[j-1];
                        array[j-1]=temp;
                    }               

                    j--;
                }                
            }
            if (j>=3){//делаем для элементов массива начиная с  четвертого 
                if (temp<array[j-1]){//если элемент меньше предыдущего
                    int lp=0;//самый левый элемент
                    int rp=j-1;//самый правый элемент
                    int cp=lp+(rp-lp)/2;

                    while(array[cp]!=temp){//условие выбора нового элемента массива  для сравнения
                        System.out.print((rp-lp)+"= ");
                        if (rp-lp==1|rp-lp==2) break;
                        if (array[cp]>temp){
                            rp=cp;
                            cp=lp+(rp-lp)/2;                            
                        }
                        else{
                            lp=cp;
                            cp=lp+(rp-lp)/2; 
                        }
//                            System.out.print((rp-lp)+"= ");
//                        System.out.print(cp+"= ");
                    }
                    if (array[cp]==temp){ //делаем сдвиг
                        for (int k = j; k >= cp+1; k--) {
                            array[k]=array[k-1]; 
                        }
                    }
                    else{
                        //значит нет такого значения элемента
                        if (array[cp]<temp){
                             //то вставляем правее cp
                            for (int k = j; k >= cp+2; k--) {
                                array[k]=array[k-1];
                                array[cp+1]=temp;
                            }
                        }
                        else{
                             //вставляем левее cp
                            for (int k = j; k >= cp; k--) {
                                array[k]=array[k-1];
                                array[cp-1]=temp;
                            }
                        } 
                    }
                }             
            }
        }
        System.out.println();
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]+ " ");
            
        }
    }
    
    
}
