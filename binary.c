#include<stdio.h>
int main(){
    int arr[10],n,mid,start,last,key;
    printf("enter the number of element");
    scanf("%d",&n);
    printf("enter the elements");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    printf("unsorted array is :");
    for(int i=0;i<n;i++){
        printf("  %d",arr[i]);
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
              if(arr[j]>arr[j+1]){
                      int temp=arr[j];
                      arr[j]=arr[j+1];
                      arr[j+1]=temp;
               }
          }
     }
    printf("\nsorted array is :");
    for(int i=0;i<n;i++){
        printf("   %d",arr[i]);
    }
    printf("\nenter the key element to be found");
    scanf("%d",&key);
    start=0;
    last=n-1;
    mid=(start+last)/2;
    
   
    while(start<=last){
         
         if(arr[mid]==key){
            printf("key element found at %d",mid);
            return 1;
          }else if(arr[mid]>key){
            last=n-1;
          }else{
             start=n+1;
          }
       } 

}
