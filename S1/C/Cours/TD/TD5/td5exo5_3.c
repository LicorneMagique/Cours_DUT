#include<stdio.h>

void echangeint(int *p, int * q)
{
 int aux;        
 aux=*p;
 *p=*q;
 *q=aux; 
}

void echangeshort(short *p, short * q)
{
 short aux;        
 aux=*p;
 *p=*q;
 *q=aux; 
}

void echangechar(char *p, char * q)
{
 char aux;        
 aux=*p;
 *p=*q;
 *q=aux; 
}


void echangedouble(double *p, double * q)
{
 double aux;        
 aux=*p;
 *p=*q;
 *q=aux; 
}


void echangeTout(void *p, void *q, int taille)
 {
     switch(taille) {
                   case 1 : echangechar(p,q);
                            break;       
                   case 2 : echangeshort(p,q);
                   	    break; 
                   case 4 : echangeint(p,q);
                            break;                                            
                   case 8 : echangedouble(p,q); 
     		  }
 }


int main()
{
 int type;
 printf("type des variables :\n 1. int \n 2. short \n 3. char \n 4. float \n 5. double \n");
 scanf("%d",&type);
 switch(type) {
                  case 1 :{  int a,b;
                             printf("\n a= ");
                             scanf("%d",&a);
                             printf("\n b= ");
                             scanf("%d",&b);
                             echangeTout(&a,&b,sizeof(a));
                             printf("apres : a=%d et b=%d\n",a,b); 
                             break; 
                          }
                  case 2 :{  short a,b;
                             printf("\n a= ");
                             scanf("%hd",&a);
                             printf("\n b= ");
                             scanf("%hd",&b);
                             echangeTout(&a,&b,sizeof(a));
                             printf("apres : a=%hd et b=%hd\n",a,b); 
                             break; 
                          }
                  case 3 :{  char a,b;
                             printf("\n a= ");
                             scanf(" %c",&a);
                             printf("\n b= ");
                             scanf(" %c",&b);
                             echangeTout(&a,&b,sizeof(a));
                             printf("apres : a=%c et b=%c\n",a,b); 
                             break; 
                          }
                  case 4 :{  float a,b;
                             printf("\n a= ");
                             scanf("%f",&a);
                             printf("\n b= ");
                             scanf("%f",&b);
                             printf("avant : a=%f et b=%f\n",a,b); 
                             echangeTout(&a,&b,sizeof(a));
                             printf("apres : a=%f et b=%f\n",a,b); 
                             break; 
                          }
                  case 5 :{  double a,b;
                             printf("\n a= ");
                             scanf("%lf",&a);
                             printf("\n b= ");
                             scanf("%lf",&b);
                             echangeTout(&a,&b,sizeof(a));
                             printf("apres : a=%lf et b=%lf\n",a,b); 
                             break; 
                          }
                  }
 //system("pause");
 return 0;   
}
