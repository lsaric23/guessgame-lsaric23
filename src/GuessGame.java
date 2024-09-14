package SOLUTIONS.src;

import java.util.concurrent.ThreadLocalRandom;

public class GuessGame {
    static String[] countries = {"Albania", "Australia", "Argentina", "Bahamas", "Belgium", "BiH", "Brazil",
            "Bulgaria", "Chile", "Croatia", "Canada", "Colombia", "Cuba", "Cyprus", "Denmark", "Dominican Republic",
            "Egypt", "Ecuador", "Estonia", "Finland", "France", "Germany", "Ghana", "Greece", "Hungary", "India",
            "Iran", "Jordan", "Kenya", "Latvia", "Luxembourg", "Madagascar", "Malta", "Mexico", "Montenegro",
            "Morocco", "Nepal", "Netherlands", "New Zealand", "North Korea", "Norway", "Panama", "Pakistan",
            "Paraguay", "Qatar", "Romania", "San Marino", "Samoa", "Singapore", "Sudan", "Tanzania", "Uganda",
            "Venezuela", "Vietnam", "Slovenia", "Poland", "Slovakia", "United States of America", "United Kingdom",
            "Ukraine", "Uganda", "Yemen", "Laos", "Russia"};

    public GuessGame() {}

    public static String randomPickCountry(){
        int randomNumber = ThreadLocalRandom.current().nextInt(0,countries.length);
        return countries[randomNumber];
    }

    public static boolean checkGuess(String playerGuess, String countryToGuess) {
        return playerGuess.equalsIgnoreCase(countryToGuess);
    }

    private static int randomChar(String country) {
        int size = country.length();
        return ThreadLocalRandom.current().nextInt(1,size-1);
    }

    public static void printGuessFields(String guess){
        if(guess.length()>3) {
            int randomIndex = randomChar(guess);
            for (int i = 0; i < guess.length(); i++) {
                if (i == 0 || i == guess.length() - 1 || i == randomIndex || guess.charAt(i) == ' ') {
                    System.out.print(guess.charAt(i));
                } else {
                    System.out.print('_');
                }
            }
        }else{
            System.out.println(guess.charAt(0) + "_"+ guess.charAt(guess.length()-1));
        }
        System.out.println();
    }
}
