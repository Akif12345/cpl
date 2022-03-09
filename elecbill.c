#include<stdio.h>
int main(){
    char name[20];
    printf("Enter name");  
    scanf("%s",name);
    float charge,units,total;
    printf("Enter no. of units consumed:");
    scanf("%f",&units);
    charge=0;
    total=0;
    if(units>0&& units<=200)
    {
     charge=0.8*units;
     }
     else if(units>200 && units<=300)
     {
     charge=0.8*200 + 0.9*(units-200);
     }
     else 
     {
     charge=0.8*200 + 0.9*100 + 1*(units-300);
     }
     total= charge+100; 
     if(total>400)
     {
      total=total + (0.15*total);
      
      }
      printf("NAME: %s \n",name);
      printf("UNITS:%f \n",units);
      printf("ELECTRICITY BILL:%f",total);
}
