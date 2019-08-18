#include<stdio.h>

void date(int nbDate)
/*
ff
ff
ff
ff
*/
{
    int jour, mois, annee;
    annee=nbDate%100;
    mois=(nbDate/100)%100;
    jour=(nbDate/100)/100;
    printf("%02d ", jour);
    switch(mois)
            {
            case 1 :
                printf("janvier");
                break;
            case 2 :
                printf("fevrier");
                break;
            case 3 :
                printf("mars");
                break;
            case 4 :
                printf("avril");
                break;
            case 5 :
                printf("mai");
                break;
            case 6 :
                printf("juin");
                break;
            case 7 :
                printf("juillet");
                break;
            case 8 :
                printf("aout");
                break;
            case 9 :
                printf("septembre");
                break;
            case 10 :
                printf("octobre");
                break;
            case 11 :
                printf("novembre");
                break;
            case 12 :
                printf("decembre");
                break;
            }
    printf(" 19%02d", annee);
}

int main()
{

    int nbDate;
    printf("Entrer une date sous la forme JJMMAA\n");
    scanf("%d", &nbDate);
    date(nbDate);

    return 0;
}
