#include<stdio.h>

int main()
{
    int Nb1=5;
    int *Pt1 = &Nb1;
    printf("Valeur de Nb1 : %d\n"
           "Valeur de Pt1 : %p\n"
           "Valeur de Pt1+1 : %p\n"
           "Valeur de *Pt1 : %d\n"
           "Valeur de *Pt1+1 : %d\n"
           "Valeur de *(Pt1+1) : %d\n", 
           Nb1, Pt1, Pt1+1, *Pt1, *Pt1+1, *(Pt1+1));
    
    double Nb2=5.3;
    double *Pt2 = &Nb2;
    printf("Valeur de Nb2 : %lf\n"
           "Valeur de Pt2 : %p\n"
           "Valeur de Pt2+1 : %p\n"
           "Valeur de *Pt2 : %lf\n"
           "Valeur de *Pt2+1 : %lf\n"
           "Valeur de *(Pt2+1) : %lf\n", 
           Nb2, Pt2, Pt2+1, *Pt2, *Pt2+1, *(Pt2+1));
    
    return 0;
}

