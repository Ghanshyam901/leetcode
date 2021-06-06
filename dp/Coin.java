import java.util.Arrays;

import javax.swing.text.html.parser.TagElement;

public class Coin{

    public static void print1D(int [] arr){
        for(int ele : arr){
            System.out.print(ele +" ");
        }
        System.out.println();
    }


public static int coinChangepermutaion_memo(int [] arr, int tar, int [] dp){


    if(tar == 0){
        return dp[tar] =1;

    }
    if(dp[tar] != -1){
        return dp[tar];
    }

    int count =0;
    for(int ele : arr){
        if(tar - ele >= 0){
                count += coinChangepermutaion_memo(arr,tar-ele, dp);
        }

    }
    return dp[tar] = count;

}

public static int coinChangepermutaion_dp(int [] arr, int Tar, int [] dp){


    for(int tar=0; tar <= Tar; tar++){
        if(tar == 0){
            dp[tar] = 1;
            continue;
        }
      
    
        // int count =0;
        for(int ele : arr){
            if(tar - ele >= 0){
                    dp[tar] += dp[tar-ele];
            }
    
        }
    }


    
    return dp[Tar] ;

}

    public static void coinChange(){
        int [] arr =  {2,3,7};
        int tar = 7;
        int  [] dp = new int[tar +1];
        Arrays.fill(dp,-1);
        System.out.println(coinChangepermutaion_dp(arr,tar,dp));
        print1D(dp);
    }

    public static void main(String[] args) {
        coinChange();

    }
}