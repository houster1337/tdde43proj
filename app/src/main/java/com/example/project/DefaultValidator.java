package com.example.project;

public class DefaultValidator implements Validator{


    private int grade;
    private int MINIMUM_LENGTH_OF_PASSWORD = 8;

    @Override
    public int validate(String pw) {
            boolean len = false;
            boolean uc = false;
            boolean lc = false;
            boolean num = false;

            if(pw.length() > MINIMUM_LENGTH_OF_PASSWORD) {
                System.out.println(pw);
                len = true;
            }
                System.out.println("len");
                for(int i = 0; i<pw.length(); i++){
                    char a = pw.charAt(i);
                    if(Character.isUpperCase(a)) {
                        System.out.println("uc");
                        uc = true;
                    }
                    if(Character.isDigit(a)){
                        num = true;
                        System.out.println("num");
                    }
                    if(Character.isLowerCase(a)){
                        lc = true;
                    }
                }


            if (len && uc && num && lc){
                grade = 4;
            } else if(len && uc && lc || len && num && lc || num && uc && lc){
                grade = 3;
            } else if(len || uc || num) {
                grade = 2;
            }else{
                grade = 1;
            }
            return grade;
    }
}
