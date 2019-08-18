#include<stdio.h>

int main ()
{
    int nb, i;
    printf("Entrer le premier rang\n");
    scanf("%d", &nb);
    printf("Voici les 10 premiers termes de la suite 1 :\n");
    for (i=0; i<10; i++)
    {
        printf("U%d=%d\n", nb+i, 3*(nb+i)+5);
    }
    printf("Voici les 10 premiers termes de la suite 2 :\n");
    for (i=0; i<10; i++) printf("U%d=%d\n", nb+i, (3*(nb+i)*(nb+i)+5)*((nb+i)*(nb+i)*(nb+i)+1));
    return 0;

}
