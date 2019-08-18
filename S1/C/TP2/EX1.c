#include<stdio.h>

int main ()
{
    int nb=0, i;
    printf("Entrer un entier positif\n");
    scanf("%d", &nb);
    while (nb >= 0)
    {
        for (i=0; i<=10; i++) printf("%dx%d=%d\n", nb, i, nb*i);
        scanf("%d", &nb);
    }
    return 0;
}
