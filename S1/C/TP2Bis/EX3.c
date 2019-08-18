#include<stdio.h>


int bisex (int annee)
/*
:entree annee : int
:precondition 1512<=annee<=3999
:postcondition : retourne 1 si l'annee est bisextile ou 0 sinon
*/
{
    if (annee%4==0 && annee%100!=0 || annee%400==0) return 1;
    else return 0;
}

int main ()
{
    assert(bisex(1512) == 1 );
    assert(bisex(1513) == 0 );
    assert(bisex(2000) == 1 );
    assert(bisex(2001) == 0 );

    int annee=0;
    while (annee < 1512 || annee > 3999)
    {
        printf("Entrer une annee entre 1512 et 3999\n");
        scanf("%d", &annee);
    }
    if (bisex(annee)) printf("L'annee est bissextile");
    else printf("L'annee n'est pas bissextile");

    return 0;
}
