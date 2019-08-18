#include<stdio.h>

int main()
{
 printf("taille d un pointeur vers un :\n -caractere = %d\n -entier = %d\n -double = %d\n",sizeof(char*),sizeof(int*), sizeof(double*));
 /* Affiche la taille des pointeurs vers les char, int, double (en fait, la taille d'une adresse) qui est toujours la même sur une machine donnée*/
 //system("pause");
 return 0;   
}
