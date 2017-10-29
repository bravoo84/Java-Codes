/*
Write a program to check the given number is palindrome or not?
Descritpion : A Palindrome number is a number that remains the same when its digits are reversed. Like 16461, for example: we take 121 and reverse it, after revers it is same as original number
*/

import java.util.Scanner;

class P{

public static void main(String args[])
{
int n,x,i,number;

boolean f=true;

Scanner sc= new Scanner(System.in);

number = sc.nextInt();

String str = Integer.toString(number);

String strArr[] = str.split("");

x = str.length();
n=x/2;
for(i=0;i<n;i++)
{
if(strArr[i].compareTo(strArr[--x])!=0)
{f=false;break;}
}

if(f==true)
System.out.print(str +" is palindrome ");

else
System.out.print( str+" is not a palindrome");
}
} 
