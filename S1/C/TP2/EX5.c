#include<stdio.h>

int main ()
{
    int note1;
    int note2;
    int note3;
    printf("Entrer trois notes\n");
    scanf("%d%d%d", &note1, &note2, &note3);
    if (note1 > note3 && note2 > note3)
        (printf("La moyenne des deux meilleurs notes est %d\n", (note1+note2)/2)
        );

    if (note1 > note3 && note3 > note2)
        (printf("La moyenne des deux meilleurs notes est %d\n", (note1+note3)/2)
        );

    if (note2 > note1 && note3 > note1)
        (printf("La moyenne des deux meilleurs notes est %d\n", (note2+note3)/2)
        );

    return 0;

}
