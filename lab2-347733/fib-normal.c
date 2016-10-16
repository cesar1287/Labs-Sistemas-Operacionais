#include <stdio.h>
#include <stdlib.h>

int main() {
	
	int num1,num2,fib0=0,fib1=1,aux,x;
	char fib[3];		

	printf("Digite o intervalo que quer a sequência de fibonacci - fib num1 num2\n");
	scanf("%s %d %d", fib,&num1,&num2);
	
	if(num1==1){
		printf("%d,",fib0);
	}
	if(num2==2){
		printf("%d\n",fib1);
	}else if(num2>2 && num1<=2){
		printf("%d,",fib1);
	}

	fib0=1;
	fib1=1;

	for(x=3;x<=num2;x++){
		aux = fib0;
		fib0 = fib1;
		fib1 = fib0+aux;
		if(num2==x){
			printf("%d\n",fib0);
		}else if(x>=num1){
			printf("%d,",fib0);
		}
	}

	return 0;
}
