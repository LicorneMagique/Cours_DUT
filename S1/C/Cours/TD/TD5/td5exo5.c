#include<stdio.h>

void echangeTout(void *p, void *q, int type)
 {
     switch(type) {
                  case 1 :{  int aux,*p2,*q2;
                             p2=(int*)p;
                             q2=(int*)q;
                             aux=*p2;
                             *p2=*q2;
                             *q2=aux; 
                             break; 
                          }
                  case 2 :{  short aux,*p2,*q2;
                             p2=(short*)p;
                             q2=(short*)q;
                             aux=*p2;
                             *p2=*q2;
                             *q2=aux; 
                             break; 
                          }
                  case 3 :{  char aux,*p2,*q2;
                             p2=(char*)p;
                             q2=(char*)q;
                             aux=*p2;
                             *p2=*q2;
                             *q2=aux; 
                             break;
                          }
                  case 4 :{  float aux,*p2,*q2;
                             p2=(float*)p;
                             q2=(float*)q;
                             aux=*p2;
                             *p2=*q2;
                             *q2=aux; 
                             break;
                          }
                  case 5 :{  double aux,*p2,*q2;
                             p2=(double*)p;
                             q2=(double*)q;
                             aux=*p2;
                             *p2=*q2;
                             *q2=aux; 
                             break;
                          }
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
                             echangeTout(&a,&b,1);
                             printf("apres : a=%d et b=%d\n",a,b); 
                             break; 
                          }
                  case 2 :{  short a,b;
                             printf("\n a= ");
                             scanf("%hd",&a);
                             printf("\n b= ");
                             scanf("%hd",&b);
                             echangeTout(&a,&b,2);
                             printf("apres : a=%hd et b=%hd\n",a,b); 
                             break; 
                          }
                  case 3 :{  char a,b;
                             printf("\n a= ");
                             scanf(" %c",&a);
                             printf("\n b= ");
                             scanf(" %c",&b);
                             echangeTout(&a,&b,3);
                             printf("apres : a=%c et b=%c\n",a,b); 
                             break; 
                          }
                  case 4 :{  float a,b;
                             printf("\n a= ");
                             scanf("%f",&a);
                             printf("\n b= ");
                             scanf("%f",&b);
                             echangeTout(&a,&b,4);
                             printf("apres : a=%f et b=%f\n",a,b); 
                             break; 
                          }
                  case 5 :{  double a,b;
                             printf("\n a= ");
                             scanf("%lf",&a);
                             printf("\n b= ");
                             scanf("%lf",&b);
                             echangeTout(&a,&b,5);
                             printf("apres : a=%lf et b=%lf\n",a,b); 
                             break; 
                          }
                  }
 //system("pause");
 return 0;   
}
