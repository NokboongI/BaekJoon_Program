#include <iostream>
#include<cstdio>
int main(){

    int a, b;
    scanf("%d %d",&a, &b );

    unsigned long long dp[201][201];

    for (int i =0; i<a+1;i++){
        dp[0][i] = 1;
    }
    for (int i =0; i<b;i++){
        dp[i][0] = 1;
    }

    for(int i = 1; i<b;i++){
        for(int j = 1; j<a+1;j++){

            dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;



        }
    }/*
    for (int i =0; i<b;i++){
        for (int j =0; j<a+1;j++){
            std::cout<<dp[i][j]<<' ';
        }
        std::cout<<'\n';
    }*/
    std::cout<<dp[b-1][a]/*%1000000000*/;


    return 0;
}