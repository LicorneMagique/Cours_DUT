#include<stdio.h>

void factorielle (unsigned long nb);

int main ()
{
    unsigned long nb=-1;
    printf("Saisir un nombre entier\n");
    scanf("%d", &nb);
    if (nb != -1) factorielle(nb);
    else printf("erreur");
    return 0;
}

void factorielle (unsigned long nb)
/*
:entree m : int
:precondition : m>=0
:postcondition
*/

{
    int i;
    unsigned long nb2=nb;
    for (i=1; i<nb; i++) nb2=nb2*i;
    printf("La factorielle de ce nombre est %u", nb2);
}
