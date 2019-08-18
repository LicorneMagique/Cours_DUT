#include<stdio.h>

int main ()
{
    int annee=0;

    while (annee < 1512 || annee > 3999)
    {
        printf("Entrer une annee entre 1512 et 3999\n");
        scanf("%d", &annee);
    }
    if (annee%4==0 && annee%100!=0 || annee%400==0) printf("L'annee est bissextile");
    else
    {
        printf("L'annee n'est pas bissextile");
    }
    return 0;


}
