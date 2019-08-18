#include<stdio.h>

int len_char(char chaine[])
{
    int i=0;
    while(chaine[i]!='\0') i++;
    return i;
}

char* copie(char ch1[], char ch2[])
{
    int i, taille=len_char(ch2);
    for(i=0; i<taille; i++) ch1[i]=ch2[i];
    return ch1;
}

int main()
{
    char chaine1[100], chaine2[100];
    printf("Entrer une ligne de moins de 100 caracteres :\n");
    fgets(chaine2, 100, stdin);
    printf("%s\n", copie(chaine1, chaine2));
    return 0;
}
