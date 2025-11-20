package controllers;

import java.util.Arrays;

public class SortMethods {
    
    public void sortBubble(int[] numeros){
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }


    public void sortBubbleMejorado(int[] numeros){
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        boolean swapped;
        for (int i = 0; i < numeros.length; i++) {
            swapped = false;
            for (int j = 0; j < numeros.length -i -1; j++) {
                if (numeros[j] < numeros[j+1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temp;
                    swapped= true;
                }
            }
            if (!swapped) break;
        }
    }

    public void sortShell(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] aux, int ini, int fin) {
        if (ini >= fin) return;
        int medio = (ini + fin) / 2;
        mergeSort(arr, aux, ini, medio);
        mergeSort(arr, aux, medio + 1, fin);
        merge(arr, aux, ini, medio, fin);
    }

    private void merge(int[] arr, int[] aux, int ini, int medio, int fin) {
        int i = ini;
        int j = medio + 1;
        int k = ini;
        while (i <= medio && j <= fin) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        while (i <= medio) aux[k++] = arr[i++];
        while (j <= fin) aux[k++] = arr[j++];

        // Copiar aux -> arr
        for (int p = ini; p <= fin; p++) {
            arr[p] = aux[p];
        }
    }
}
