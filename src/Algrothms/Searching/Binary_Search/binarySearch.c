#include <stdlib.h>

int * binarySearch(int* a, int q, int n){
	if(n <= 1){
		if((*a) == q){
			return a;
		}else{
			return NULL;
		}
	}
	int* pivot = a+(n/2);

	if((*pivot) == q){
		return pivot;
	}else if(q > (*pivot)){
		binarySearch(pivot, q, n/2);
	}else{
		binarySearch(a, q, n/2);
	}

	return NULL;

}
