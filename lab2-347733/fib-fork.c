#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int num1,num2;
char fib[3];

int calcularFibonacci(int y){
	int fib0=0,fib1=1,aux,x;
	if(y==1){
		return fib0;
	}
	if(y==2){
		return fib1;
	}

	if(y>=3){
		fib0=1;
		fib1=1;
	}

	for(x=3;x<=num2;x++){
		aux = fib0;
		fib0 = fib1;
		fib1 = fib0+aux;
		if(x==y){
			return fib0;
		}
	}
}

int main(){
	
	pid_t pid;		

	printf("Digite o intervalo que quer a sequência de fibonacci - fib num1 num2\n");
	scanf("%s %d %d", fib,&num1,&num2);

	int cont=num1, cont1=0;
	int result[(num2-num1)+1];
	int j;
	
	while(cont<=num2){
		pid = fork();

		if(pid<0){
			fprintf(stderr, "falha na execução do Fork");
			return -1;
		}else if(pid==0){
			result[cont1] = calcularFibonacci(cont);
			cont++;
			cont1++;
		}else{
			wait(NULL);
			return 0;
		}
	}

	for(j=0;j<cont1;j++){
		if(j+1==cont1){
			printf("%d\n", result[j]);
		}else{
			printf("%d,", result[j]);
		}
	}
	
}
