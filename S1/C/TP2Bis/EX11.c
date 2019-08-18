#include<stdio.h>
#include<math.h>

int main()
{
    float a, b, c;
    printf("Entrer les nombres a, b et c d'une equation du second degre du type ax^2+bx+c=0\n");
    scanf("%f%f%f", &a, &b, &c);
    if (b*b-4*a*c < 0)
        (printf ("Il n'y a pas de solution a cette equation"));
    if (b*b-4*a*c == 0)
        (printf("Il n'y a qu'une seule solution : %f", -b/(2*a)));
    if (b*b-4*a*c > 0) (printf ("Il y a deux solutions : x1=%f et x2=%f", (-b-sqrt(b*b-4*a*c))/(2*a), (-b+sqrt(b*b-4*a*c))/(2*a)));
    return 0;
}
