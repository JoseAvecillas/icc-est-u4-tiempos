package controllers;
import java.util.Arrays;

public class SortMethods {

    public void sortBubble(int[] numeros){
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        int n = cp.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (cp[j] > cp[j + 1]) {
                    int temp = cp[j];
                    cp[j] = cp[j + 1];
                    cp[j + 1] = temp;
                }
            }
        }
        System.arraycopy(cp, 0, numeros, 0, numeros.length);
    }


    public void sortBubbleMejorado(int[] numeros){
        int[] cp = Arrays.copyOf(numeros, numeros.length);
        boolean swapped;
        for (int i = 0; i < cp.length; i++) {
            swapped = false;

            for (int j = 0; j < cp.length - i - 1; j++) {
                if (cp[j] < cp[j+1]) {   // OJO: está en orden descendente
                    int temp = cp[j];
                    cp[j] = cp[j+1];
                    cp[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.arraycopy(cp, 0, numeros, 0, numeros.length);
    }


    public void sortShell(int[] arr) {
        int[] cp = Arrays.copyOf(arr, arr.length);
        int n = cp.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = cp[i];
                int j = i;

                while (j >= gap && cp[j - gap] > temp) {
                    cp[j] = cp[j - gap];
                    j -= gap;
                }

                cp[j] = temp;
            }
        }
        System.arraycopy(cp, 0, arr, 0, arr.length);
    }


    public void mergeSort(int[] arr) {
        int[] cp = Arrays.copyOf(arr, arr.length);

        if (cp.length <= 1) return;

        int[] aux = new int[cp.length];
        mergeSort(cp, aux, 0, cp.length - 1);

        System.arraycopy(cp, 0, arr, 0, arr.length);
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

        for (int p = ini; p <= fin; p++) {
            arr[p] = aux[p];
        }
    }
}