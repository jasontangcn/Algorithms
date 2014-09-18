package com.fairchild.algo.sort;


/*
 * QuickSort nlog2n	n2	log2n
 * MergeSort nlog2n nlog2n O(1)
 * =
 */
public class SortUtil {
	public static void quickSort(int[] data, int low, int high) {
		if(low < high) {
			int i = low, j = high;
			int k = data[low];
			while(i < j) {
				while(i < j && data[j] > k) j--;
				if(i < j) data[i++] = data[j];
				while(i < j && data[i] <= k) i++;
				if(i < j) data[j--] = data[i];
			}
			data[i] = k;
			quickSort(data, low, i-1);
			quickSort(data, i + 1, high);
		}
	}
}
