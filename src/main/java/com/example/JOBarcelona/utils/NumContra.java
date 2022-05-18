package com.example.JOBarcelona.utils;


public class NumContra {
    public static void main(String[] args) {
    String numString="6668014432879854274079851790721257797144758322315908160396257811764037237817632071521432200871554290742929910593433240445888801654119365080363356052330830046095157579514014558463078285911814024728965016135886601981690748037476461291163877376";

    char[] numStringArray=numString.toCharArray();//pasa a array char

    int sumTotal=0;

    for(int i=0;i<numStringArray.length;i++) {
//            String numS=Character.toString(numStringArray[i]);//pasa a string
//            int numv=Integer.parseInt(numS);//pasem a int
        //sumTotal+=numv;//anem suman
        int numC=Character.getNumericValue(numStringArray[i]);//passar de char a int
        sumTotal+=numC;
        }
        System.out.println(sumTotal);

}
}
