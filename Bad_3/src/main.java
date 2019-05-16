package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int index = 0;
        String FirstStr = "";
        String SecondStr = "";
        char Symbol = '+';

        Pattern pattern = Pattern.compile("\\d+(\\+|\\-|\\*|\\/)\\d+");




        Matcher matcher = pattern.matcher(input);

        if ( matcher.matches() ){
            for (int i = 0; i < input.length(); i++){
                if (input.charAt(i)== '+' | input.charAt(i)== '-' |
                        input.charAt(i)== '/' | input.charAt(i)== '*'){
                    index = i;
                    Symbol = input.charAt(i);
                    break;
                }
            }

            for (int i = 0; i < index; i++){
                FirstStr += input.charAt(i);
            }

            for (int i = index+1; i < input.length(); i++){
                SecondStr += input.charAt(i);
            }

            float FirstInt = Float.parseFloat(FirstStr);
            float SecondInt = Float.parseFloat(SecondStr);
            System.out.print(GetRes(FirstInt, SecondInt, Symbol));
        }
        else{
            System.out.print("некорректно");
        }
    }

    private static double GetRes(float firstInt, float secondInt, char symbol) {
        switch (symbol){
            case '-': return firstInt-secondInt;
            case '*': return firstInt*secondInt;
            case '/': return firstInt/secondInt;
        }
        return firstInt+secondInt;
    }


}
