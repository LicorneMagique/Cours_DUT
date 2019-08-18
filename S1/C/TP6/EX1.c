#include<stdio.h>

int len_char(char chaine[])
{
    int i=0;
    while(chaine[i]!='\0') i++;
    return i;
}

int main()
{
    char chaine[100];
    printf("Entrer une ligne de moins de 100 caracteres :\n");
    fgets(chaine, 100, stdin);
    printf("La chaine fait %d caracteres.\n", len_char(chaine));
    return 0;
}
