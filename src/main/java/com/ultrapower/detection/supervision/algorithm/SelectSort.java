package com.ultrapower.detection.supervision.algorithm;

public class SelectSort {

	public static void main(String[] args) {
		
		
	}
	
	/**
	 * 选择排序
	 * 每次把最小的元素放到前面，
	 * @param a
	 */
	public void selectSort(int[] a) {
		int n = a.length;
		for (int k=0;k<n-1;k++) {
			int min = k;
			for (int i=k+1;i<n;i++) {
				if (a[i]<a[min])
					min = i;
			}
			if (k!=min) {
				int temp = a[k];
				a[k] = a[min];
				a[min] = temp;
			}
		}
	}

}
