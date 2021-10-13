#ifndef BUBBLE_SORT_H
#define BUBBLE_SORT_H

#include <bits/stdc++.h>
using namespace std;

void _swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n-1; i++)    
     
    for (j = 0; j < n-i-1; j++)
        if (arr[j] > arr[j+1])
            _swap(&arr[j], &arr[j+1]);
}

#endif 