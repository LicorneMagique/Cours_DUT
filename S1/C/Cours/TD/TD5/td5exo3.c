#include<stdio.h>

int main()
{
 int Nb=3, *Pt=&Nb;
 printf("Nb=%d\n",Nb);
 printf("Pt++=%p\n",Pt++); // Valeur de l'expression (Pt++) qui est egale a celle de (Pt = &Nb) avant l'execution de l'instruction-expression
 Pt=&Nb;
 printf("++Pt=%p\n",++Pt); // Valeur de l'expression (++Pt) qui est egale a celle de (Pt) apres l'execution de l'instruction-expression, donc Pt+1
 Pt=&Nb;
 printf("*(Pt++)=%d\n",*(Pt++)); // Valeur de l'int a l'adresse (Pt++) (donc a l'adresse (&Nb)) 
 Pt=&Nb;
 printf("*(++Pt)=%d\n",*(++Pt)); // Valeur de l'int a l'adresse (++Pt) (donc a l'adresse (&Nb+1)) 
 Pt=&Nb;
 printf("*Pt++=%d\n",*Pt++); // Interpretee comme (*Pt)++ : Valeur de l'expression (*Pt)++ (donc Nb) 
 Pt=&Nb;
 printf("*++Pt=%d\n",*++Pt); // Interpretee comme *(++Pt) : Valeur de l'int a l'adresse (++Pt) (donc a l'adresse (&Nb+1)) 
 Pt=&Nb;
 printf("++*Pt=%d\n",++*Pt); // Interpretee comme ++(*Pt) : Valeur de l'expression ++(*Pt) (donc (Nb+1)) 
 //system("pause");
 return 0;   
}
