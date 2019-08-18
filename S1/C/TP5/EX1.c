#include<stdio.h>

int main()
{
    char caractere='a';
    int entier=1;
    double doububule=3.1415926535897932384626;
    
    printf("La taille du caractere est %d, celle d'un entier est %d et celle du double est %d\n", sizeof(&caractere), sizeof(&entier), sizeof(&doububule));
    
    return 0;
}

