#include<bits/stdc++.h>
#include "generador.h"
#include "bubble_sort.h"
#include "heap_sort.h"
#include "insertion_sort.h"
#include "selection_sort.h"
#include "shell_sort.h"
#include "merge_sort.h"
#include "quick_sort.h"

using namespace std;

int main(){

    int _size = 100000;
    int *bubble_sort_ = new int[_size];
    int *heap_sort_ = new int[_size];
    int *insertion_sort_ = new int[_size];
    int *selection_sort_ = new int[_size];
    int *shell_sort_ = new int[_size];
    int *merge_sort_ = new int[_size];
    int *quick_sort_ = new int[_size];

    int reason = _size/10;

    double time_bubble, time_heap, time_insertion, time_selection, time_shell, time_merge, time_quick;

    ofstream salida{"Resultados.txt", ios::out};

    for(size_t lenght = reason; lenght <= _size ; lenght+=reason){
        generar(bubble_sort_,lenght);
        generar(heap_sort_,lenght);
        generar(insertion_sort_,lenght);
        generar(selection_sort_,lenght);
        generar(shell_sort_,lenght);
        generar(merge_sort_,lenght);
        generar(quick_sort_,lenght);

        auto begin = chrono::steady_clock::now();
        bubbleSort(bubble_sort_, lenght-1);
        auto end = chrono::steady_clock::now();
        time_bubble = double(chrono::duration_cast <chrono::microseconds> (end - begin).count());

        auto begin2 = chrono::steady_clock::now();
        heapSort(heap_sort_, lenght-1);
        auto end2 = chrono::steady_clock::now();
        time_heap = double(chrono::duration_cast <chrono::microseconds> (end2 - begin2).count());

        auto begin3 = chrono::steady_clock::now();
        insertion_sort(insertion_sort_, lenght-1);
        auto end3 = chrono::steady_clock::now();
        time_insertion = double(chrono::duration_cast <chrono::microseconds> (end3 - begin3).count());

        auto begin4 = chrono::steady_clock::now();
        selectionSort(selection_sort_, lenght-1);
        auto end4 = chrono::steady_clock::now();
        time_selection = double(chrono::duration_cast <chrono::microseconds> (end4 - begin4).count());

        auto begin5 = chrono::steady_clock::now();
        shellSort(shell_sort_, lenght-1);
        auto end5 = chrono::steady_clock::now();
        time_shell = double(chrono::duration_cast <chrono::microseconds> (end5 - begin5).count());

        auto begin6 = chrono::steady_clock::now();
        mergeSort(merge_sort_,0, lenght-1);
        auto end6 = chrono::steady_clock::now();
        time_merge = double(chrono::duration_cast <chrono::microseconds> (end6 - begin6).count());

        auto begin7 = chrono::steady_clock::now();
        quicksort(quick_sort_,0, lenght-1);
        auto end7 = chrono::steady_clock::now();
        time_quick = double(chrono::duration_cast <chrono::microseconds> (end7 - begin7).count());


        salida << lenght << "\t" << time_bubble << "\t" << time_heap <<"\t" << time_insertion << "\t" << 
        time_selection << "\t" <<time_shell << "\t" << time_merge << "\t" << time_quick <<endl;  
    }

    delete[] bubble_sort_;
    delete[] heap_sort_;
    delete[] insertion_sort_;
    delete[] selection_sort_;
    delete[] shell_sort_;
    delete[] merge_sort_;
    delete[] quick_sort_;

    return 0;
}