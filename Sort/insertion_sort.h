#ifndef INSERTION_SORT_H
#define INSERTION_SORT_H

#include <bits/stdc++.h>
using namespace std;


void insertion_sort(int Aux[], int n){
    int i, key, j;

    for (i = 1; i < n; i++){
        key = Aux[i];
        j = i - 1;

        while (j >= 0 && Aux[j] > key){
            Aux[j + 1] = Aux[j];
            j = j - 1;
        }
        Aux[j + 1] = key;
    }
}

#endif
