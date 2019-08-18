#include<stdio.h>

int main()
{
 int Nb1=3, *Pt1=&Nb1; // Pt1 pointe vers Nb1
 double Nb2=3.567, *Pt2=&Nb2; // Pt2 pointe vers Nb2
 printf("Nb1=%d\n Pt1=%p\n Pt1+1=%p\n *Pt1=%d\n *Pt1+1=%d\n *(Pt1+1)=%d\n",Nb1,Pt1,Pt1+1,*Pt1,*Pt1+1,*(Pt1+1));
 // Pt1 = adresse de Nb1
 // Pt1 + 1 = valeur de Pt1 + 1*(taille de l'objet pointé), (Pt1 étant un pointeur vers un int, l'objet pointé est un int)
 // *Pt1 = Nb1
 // *Pt1 + 1 = Nb1 + 1
 // *(Pt1 + 1) = valeur de l'int (la suite binaire représentée sur 4 octets) à l'adresse (Pt1 + 1)
 printf("Nb2=%lf\n Pt2=%p\n Pt2+1=%p\n *Pt2=%lf\n *Pt2+1=%lf\n *(Pt2+1)=%lf\n",Nb2,Pt2,Pt2+1,*Pt2,*Pt2+1,*(Pt2+1));
 // Pt2 = adresse de Nb2
 // Pt2 + 1 = valeur de Pt2 + 1*(taille de l'objet pointé), (Pt2 étant un pointeur vers un double, l'objet pointé est un double)
 // *Pt2 = Nb2
 // *Pt2 + 1 = Nb2 + 1
 // *(Pt2 + 1) = valeur du double (la suite binaire représentée sur 8 octets) à l'adresse (Pt2 + 1)
 //system("pause");
 return 0;   
}
