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

char* conca(char ch1[], char ch2[])
{
    int i, taille1=len_char(ch1), taille2=len_char(ch2);
    for(i=0; i<taille2; i++) ch1[taille1-1+i]=ch2[i];
    return ch1;
}

int main()
{
    char chaine1[200], chaine2[100];
    printf("Entrer la chaine 1 :\n");
    fgets(chaine1, 100, stdin);
    printf("Entrer la chaine 2 :\n");
    fgets(chaine2, 100, stdin);
    printf("affichage de ch1 : %s\n", conca(chaine1, chaine2));
    return 0;
}
