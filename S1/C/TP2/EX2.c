#include<stdio.h>


int main ()
{
    long nb, nb2=nb;
    int i;
    printf("Saisir un nombre entier\n");
    scanf("%d", &nb);
    if (nb <= 34)
    {
        for (i=1; i<nb; i++) nb2=nb2*i;
        printf("La factorielle de ce nombre est %d", nb2);
    }
    else printf("erreur");

    return 0;
}
