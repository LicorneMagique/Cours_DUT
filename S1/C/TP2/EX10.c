#include<stdio.h>

int main()
{

    int date, jour, mois, annee;
    printf("Entrer une date sous la forme JJMMAA\n");
    scanf("%d", &date);
    annee=date%100;
    mois=(date/100)%100;
    jour=(date/100)/100;
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
    return 0;
}
