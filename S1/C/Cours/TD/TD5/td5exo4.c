#include<stdio.h>

void echange(int *p, int *q)
{
 int z;
 z=*p;
 *p=*q;
 *q=z;    
}


int main()
{
 int a=3, b=5;
 printf("avant : a=%d et b=%d\n",a,b);
 echange(&a,&b);
 printf("apres : a=%d et b=%d\n",a,b);
 //system("pause");
 return 0;   
}
