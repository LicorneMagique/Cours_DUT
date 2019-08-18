#include<stdio.h>

int main( )
{

    int a=0;
    int b=1;
    printf("Entrer la longueur du rectangle :\n");
    scanf("%d", &a);
    printf("Entrer la largeur du rectangle :\n");
    scanf("%d", &b);
    printf("Le perimetre est %d et la surface est %d", (a+b)*2, a*b);
    return 0;

}
