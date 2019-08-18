#include<stdio.h>

int main()
{

    int date;
    int jour;
    int mois;
    int annee;
    printf("Entrer une date en nombre\n");
    scanf("%d", &date);
    annee=date%100;
    mois=(date/100)%100;
    jour=(date/100)/100;
    printf("%02d-%02d-20%02d", jour, mois, annee);
    return 0;

}
