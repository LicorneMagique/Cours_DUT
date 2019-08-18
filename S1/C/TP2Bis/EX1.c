#include<stdio.h>


void tab_mult (int nb)
/*
:entree : nb de type int
:preconditions : nb=>0
:postconditions : afficher la table de multiplication de nb
*/
{
    int i;
    for (i=0; i<=10; i++) printf("%dx%d=%d\n", nb, i, nb*i);
}


int main ()
{
    int nb=0;
    printf("Entrer un entier positif\n");
    scanf("%d", &nb);
    return 0;
}
