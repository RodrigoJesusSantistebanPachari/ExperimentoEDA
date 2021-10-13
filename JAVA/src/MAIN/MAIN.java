
package MAIN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MAIN {

    //INSERTION SORT
    static public void InsertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    //BUBBLE SORT
    static public void BubbleSort(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    
    //HEAP SORT
    static public void HeapSort(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    
    static public void heapify(int arr[], int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest);
        }
    }
    
    //SELECTION SORT
    static public void SelectionSort(int arr[]){
        int n = arr.length;
 
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
 
    //SHELL SORT
    static public int ShellSort(int arr[]){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];
 
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
        return 0;
    }
    
    // MERGE SORT
    static public void MergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
    
    
    static public void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    //QUICK SORT
    

    static public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static public int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high]; 

        int i = (low - 1); 

        for(int j = low; j <= high - 1; j++)
        {


            if (arr[j] < pivot) 
            {

                i++; 
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static public void quickSort(int[] arr, int low, int high)
    {
        if (low < high) 
        {


            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
  
    
 
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String linea = "";
        int numero;
        
        int Arr10000[] = new int[10000];
        int Arr20000[] = new int[20000];
        int Arr30000[] = new int[30000];
        int Arr40000[] = new int[40000];
        int Arr50000[] = new int[50000];
        int Arr60000[] = new int[60000];
        int Arr70000[] = new int[70000];
        int Arr80000[] = new int[80000];
        int Arr90000[] = new int[90000];
        int Arr100000[] = new int[100000];
        
        try{
            FileReader fileReader = new FileReader(".\\src\\MAIN\\dato.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            for(int i=0; i<100000; i++){
                linea = reader.readLine();
                numero = Integer.valueOf(linea);
                if(i<10000){
                    Arr10000[i] = numero;
                }
                if(i<20000){
                    Arr20000[i] = numero;
                }
                if(i<30000){
                    Arr30000[i] = numero;
                }
                if(i<40000){
                    Arr40000[i] = numero;
                }
                if(i<50000){
                    Arr50000[i] = numero;
                }
                if(i<60000){
                    Arr60000[i] = numero;
                }
                if(i<70000){
                    Arr70000[i] = numero;
                }
                if(i<80000){
                    Arr80000[i] = numero;
                }
                if(i<90000){
                    Arr90000[i] = numero;
                }
                
                Arr100000[i] = numero;
                
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        FileWriter salida = new FileWriter(".\\src\\MAIN\\salida.csv");
        
        
        long sal_10000[] = new long[7]; 
        //n: 10000
        for(int i=1; i<=7; i++){
            int b[] = Arr10000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_10000[i-1] = endTime;
        }
        
        //n: 20000
        long sal_20000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr20000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_20000[i-1] = endTime;
        }
        
        //n: 30000
        long sal_30000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr30000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_30000[i-1] = endTime;
        }
        
        //n: 40000
        long sal_40000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr40000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_40000[i-1] = endTime;
        }
        
        //n: 50000
        long sal_50000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr50000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_50000[i-1] = endTime;
        }
        
        
        //n: 60000
        long sal_60000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr60000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_60000[i-1] = endTime;
        }
        
        //n: 70000
        long sal_70000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr70000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_70000[i-1] = endTime;
        }
        
        
        //n: 80000
        long sal_80000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr80000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_80000[i-1] = endTime;
        }
        
        //n: 90000
        long sal_90000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr90000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_90000[i-1] = endTime;
        }
        
        //n: 100000
        long sal_100000[] = new long[7]; 
        for(int i=1; i<=7; i++){
            int b[] = Arr100000.clone();
            long startTime = System.nanoTime();
            if(i==1){
                BubbleSort(b);
            }
            else if(i==2){
                HeapSort(b);
            }
            else if(i==3){
                InsertionSort(b);
            }
            else if(i==4){
                SelectionSort(b);
            }
            else if(i==5){
                ShellSort(b);
            }
            else if(i==6){
                MergeSort(b, 0, b.length-1);
            }
            else if(i==7){
                quickSort(b, 0, b.length-1);
            }
            long endTime = System.nanoTime() - startTime; 
            sal_100000[i-1] = endTime;
        }
        
        salida.write(" ; 10000; 20000; 30000; 40000; 50000; 60000; 70000; 80000; 90000; 100000\n");
        for(int i=0; i<7; i++){
            if(i==0){
                salida.write("BubbleSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==1){
                salida.write("HeapSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==2){
                salida.write("InsertionSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==3){
                salida.write("SelectionSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==4){
                salida.write("ShellSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==5){
                salida.write("MergeSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
            else if(i==6){
                salida.write("QuickSort;"+sal_10000[i]+";"+sal_20000[i]+";"+sal_30000[i]+";"+sal_40000[i]+";"+sal_50000[i]+";"+sal_60000[i]+";"+sal_70000[i]+";"+sal_80000[i]+";"+sal_90000[i]+";"+sal_100000[i]+"\n");
            }
        }
        
        salida.close();
        
        
        
        
        
        
    }
    
}
