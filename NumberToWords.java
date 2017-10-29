/*Given a number, you have to write it in words*/
import java.io.*;
import java.util.*;
class NumberToWords
{
    public static void main(String[] args)throws IOException
    {
       DataInputStream in=new DataInputStream(System.in);
        int t,l,x,y;String s,ans;
String l19[]={"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
        String l90[]={"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        //System.out.println("Enter input:");
        t=Integer.parseInt(in.readLine());
        while(t>0)
            {ans="";int c=12;
            s=in.readLine();l=s.length();int n[]=new int[13];
             for(int i=l-1;i>=0;i--,c--)
                 {
                 n[c]=s.charAt(i)-48;
             }y=0;
             for(int i=++c;i<13;i++)
                 {
                     switch(i)
                     {
                         case 0:if(n[i]==0)break;ans=ans+l19[n[i]]+"Trillion ";break;
                         case 1:
                         case 7:
                         case 4:
                         case 10:if(n[i]==0)break;ans=ans+l19[n[i]]+"Hundred ";y=n[i];break;
                         case 2:
                         case 5:
                         case 8:
                         case 11:x=n[i]*10+n[i+1];y=y*100+x;if(y==0)break;if(x<20)ans=ans+l19[x];else ans=ans+l90[n[i]]+l19[n[i+1]];i++;break;
                         case 3:
                         case 6:
                         case 9:
                         case 12:y=n[i];if(y==0)break;ans=ans+l19[y];break;
                     }
                 if(i-1==2&&y!=0){ans=ans+"Billion ";y=0;}
                 if(i-1==5&&y!=0){ans=ans+"Million ";y=0;}
                 if(i-1==8&&y!=0){ans=ans+"Thousand ";y=0;}
                 }
             System.out.println(ans.trim());
            t--;
        }
    }
}
