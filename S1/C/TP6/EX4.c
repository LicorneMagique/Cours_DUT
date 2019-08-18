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

void* retourne(char ch[])
{
    int i, taille=len_char(ch), temp;
    for(i=0; i<(taille-1)/2; i++)
    {
        temp=ch[i];
        ch[i]=ch[taille-1-i];
        ch[taille-1-i]=temp;
    }
    return ch;
}

int main()
{
    char chaine[200];
    printf("Entrer la chaine :\n");
    fgets(chaine, 100, stdin);
    printf("%s", retourne(chaine));
    return 0;
}
