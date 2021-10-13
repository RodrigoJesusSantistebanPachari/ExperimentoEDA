def bubbleSort(arr):
    n = len(arr)
    for i in range(n):
        swapped = False

        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if swapped == False:
            break


def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and arr[largest] < arr[l]:
        largest = l
    if r < n and arr[largest] < arr[r]:
        largest = r
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heapSort(arr):
    n = len(arr)
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)


def insertionSort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def selectionSort(A):
    for i in range(len(A)):
        min_idx = i
        for j in range(i + 1, len(A)):
            if A[min_idx] > A[j]:
                min_idx = j
        A[i], A[min_idx] = A[min_idx], A[i]


def shellSort(arr):
    gap = len(arr) // 2
    while gap > 0:
        i = 0
        j = gap
        while j < len(arr):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j += 1
            k = i
            while k - gap > -1:
                if arr[k - gap] > arr[k]:
                    arr[k - gap], arr[k] = arr[k], arr[k - gap]
                k -= 1
        gap //= 2


def mergeSort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        L = arr[:mid]
        R = arr[mid:]
        mergeSort(L)
        mergeSort(R)

        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1
        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1


def partition(start, end, array):
    pivot_index = start
    pivot = array[pivot_index]
    while start < end:
        while start < len(array) and array[start] <= pivot:
            start += 1
        while array[end] > pivot:
            end -= 1
        if (start < end):
            array[start], array[end] = array[end], array[start]
    array[end], array[pivot_index] = array[pivot_index], array[end]
    return end

def quick_sort(start, end, array):
    if (start < end):
        p = partition(start, end, array)
        quick_sort(start, p - 1, array)
        quick_sort(p + 1, end, array)

if __name__ == '__main__':
    from timeit import default_timer as timer
    salida = open('insertionsort.txt', 'w')
    salida1 = open('bubblesort.txt', 'w')
    salida2 = open('heapsort.txt', 'w')
    salida3 = open('selecction.txt', 'w')
    salida4 = open('shell.txt', 'w')
    salida5 = open('merge.txt', 'w')
    salida6 = open('quick.txt', 'w')
    with open("dato.txt", "r") as tf:
        lines = tf.read().split('\n')
    for i in range (0,len(lines)):
        lines[i]=float(lines[i])

    for x in range(100000, 100001, 10000):
        array = lines[0:x]

        start = timer()
        insertionSort(array)
        end = timer()
        print(x, end - start)
        texto=end-start
        salida.write(str(texto))
        salida.write("\n")
        #print(array)
    salida.close()

    for x in range(100000, 100001, 10000):
        array2 = lines[0:x]

        start1 = timer()
        bubbleSort(array2)
        end1 = timer()
        print(x, end1 - start1)
        text=end1-start1
        salida1.write(str(text))
        salida1.write("\n")
        #print(array)
    salida1.close()
    for x in range(100000, 100001, 10000):
        array3 = lines[0:x]

        start2 = timer()
        heapSort(array3)
        end2 = timer()
        print(x, end2 - start2)
        text2=end2-start2
        salida2.write(str(text2))
        salida2.write("\n")
        #print(array)
    salida2.close()
    
    for x in range(10000, 100001, 10000):
        array3 = lines[0:x]
        start3 = timer()
        selectionSort(array3)
        end3 = timer()
        print(x, end3 - start3)
        text3=end3-start3
        salida3.write(str(text3))
        salida3.write("\n")
    salida3.close()


    for x in range(10000, 100001, 10000):
        array5 = lines[0:x]
        start5 = timer()
        mergeSort(array5)
        end5 = timer()
        print(x, end5 - start5)
        texto5=end5-start5
        salida5.write(str(texto5))
        salida5.write("\n")
    salida5.close()
    for x in range(10000, 100001, 10000):
        array6 = lines[0:x]
        start6 = timer()
        quick_sort(0,x-1,array6)
        end6 = timer()
        print(x, end6 - start6)
        texto6 = end6 - start6
        salida6.write(str(texto6))
        salida6.write("\n")
    salida6.close()

    for x in range(80000, 100001, 10000):
        array4 = lines[0:x]
        start4 = timer()
        shellSort(array4)
        end4 = timer()
        print(x, end4 - start4)
        texto4 = end4 - start4
        salida4.write(str(texto4))
        salida4.write("\n")
        # print(array)
    salida4.close()

