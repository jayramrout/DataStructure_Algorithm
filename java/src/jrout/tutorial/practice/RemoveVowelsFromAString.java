package jrout.tutorial.practice;

public class RemoveVowelsFromAString {
    public static void main(String[] args) {
        String aString = "hey I was about to leave the place";

        char [] vowels =  {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        for(char vowel : vowels){
            aString = aString.replace(String.valueOf(vowel),"");
        }
        System.out.println(aString);

        StringBuilder stringBuilder = new StringBuilder();
        /***************************/
        aString = "hey I was about to leave the place";
        String vowels_ = "aeiouAEIOU";
        char[] chars = aString.toCharArray();
        for(char ch : chars){
           if(vowels_.indexOf(ch) < 0) {
               stringBuilder.append(ch);
           }
        }
        System.out.println(stringBuilder.toString());
    }
}
