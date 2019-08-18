#include<stdio.h>

int main()
{
    int temps, heure, minute, seconde;
    printf("Saisir l'heure sous la fome HHMMSS\n");
    scanf("%d", &temps);
    seconde=temps%100;
    minute=(temps/100)%100;
    heure=(temps/100)/100;

    printf("%02d:%02d:%02d\n", heure, minute, seconde);

    seconde+=1;
    if (seconde == 60)
    {
        seconde = 0;
        minute++;
    }

    if (minute == 60)
    {
        minute = 0;
        heure++;
    }

    if (heure == 24)
        heure = 0;


    printf("%02d:%02d:%02d\n", heure, minute, seconde);
    return 0;
}
