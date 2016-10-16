#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>

void *filho(void *n);
int *vetor;

int fibonacci(int num){
	if(num==1 || num==2){
		return num;
	}else{
		return fibonacci(num-1) + fibonacci(num-2);
	}
} 

void *filho(void *n){
	int num_ele = atoi(n), i;
	
	vetor = malloc(num_ele * sizeof(int));	
	
	for(i=0; i < num_ele; i++ ){
		vetor[i] = fibonacci(i+1);
	
	}
	
	pthread_exit(0);
}
	
int main(int argc , char *argv[]){

	pthread_t tid;
	pthread_attr_t atr;
	
	if(argc != 2){
		printf("Digite a quantidade de elementos que deseja calcular:\n");
		exit(0);
	}else{
		pthread_attr_init(&atr);
		pthread_create(&tid, &atr,filho, argv[1]);
		 
		pthread_join(tid , NULL);
		
		int num_ele = atoi(argv[1]), i;
		
		for(i=0; i < num_ele; i++ ){
			printf("%d ", vetor[i]);
		}
	
		printf("\n");
	}
	return 0;
}
