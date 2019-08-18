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

void sapin1()
{
    int i;
    char tab[]="tagada tsointsoin";
    int taille=len_char(tab);
    for(i=0; i<=(taille-1)/2; i++)
    {
        printf("%s\n", tab);
        tab[i]=' ';
        tab[taille-1-i]=' ';
    }
}

void sapin2()
{
    int i;
    char tab[]="tagada tsointsoin";
    int taille=len_char(tab);
    for(i=0; i<=(taille-1)/2; i++)
    {
        printf("%s\n", tab);
        tab[i]=' ';
        tab[taille-1-i]=' ';
    }
}

int main()
{
    sapin1();
    return 0;
}
