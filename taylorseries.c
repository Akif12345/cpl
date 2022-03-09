#include<stdio.h>
#include<math.h>
#define PI  3.14
void main()
{
float sum,degree,term,n,d,x;
int i;
printf("enter degree\n");
scanf("%f",&degree);
x=degree*(PI/180);
sum=0;
n=x;
d=1.0;
i=1;
do
{
term=n/d;
sum=sum+term;
n=-n*x*x;
i=i+2;
d=d*i*(i-1);
}while(fabs(term)>=0.00001);
printf("using built-in libarary function sin(%f)=%f\n",degree,sin(x));
printf("The computer value of sin(%f)=%f",degree,sum);
}
