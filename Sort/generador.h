#ifndef GENERADOR_H
#define GENERADOR_H

#include <bits/stdc++.h>
using namespace std;

void generar(int *A , int n_elem){
    int max = n_elem;
    srand(time(0));
    for (int i=0; i<n_elem; i++){
        *(A+i) = rand()% (2*max+1)-max;
    }
}

#endif