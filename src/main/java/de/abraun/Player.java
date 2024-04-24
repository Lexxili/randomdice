package de.abraun;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        System.out.println("Herzlich willkommen zu ihrem Würfelbecher!\n");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        DiceCup diceCup = new DiceCup();

        do{
            System.out.println("\nWas möchten sie machen?");
            System.out.println("1. Würfel hinzufügen.");
            System.out.println("2. Würfeln.");
            System.out.println("3. Würfel entfernen.\n");
            System.out.println("0. Beenden.\n");
            choice = scanner.nextInt();

            switch (choice){
                case 0: return;
                case 1: addDices(scanner, diceCup); break;
                case 2: diceCup.roll(); break;
                case 3: remove(scanner, diceCup);
            }
        }while(true);
    }

    private static void addDices(Scanner scanner, DiceCup diceCup){
        int faces = 0;
        do {
            System.out.println("\nWelche Augenzahl sollen Ihre Würfel haben? ( 4, 6, 8, 10, 12, 20, 30, 100)");
            faces = scanner.nextInt();
        }while(faces != 4 && faces != 6 && faces != 8 && faces != 10 && faces != 12 && faces != 20 && faces != 30 && faces != 100  );

        System.out.println("Wie viele Würfel möchten sie hinzufügen?");
        int ammount = scanner.nextInt();

        diceCup.addDices(convertFaces(faces), ammount);
    }

    private static Dice.DiceFace convertFaces(int faces) {
        switch (faces){
            case 4: return Dice.DiceFace.W4;
            case 6: return Dice.DiceFace.W6;
            case 8: return Dice.DiceFace.W8;
            case 10: return Dice.DiceFace.W10;
            case 12: return Dice.DiceFace.W12;
            case 20: return Dice.DiceFace.W20;
            case 30: return Dice.DiceFace.W30;
            case 100: return Dice.DiceFace.W100;
        }
        return Dice.DiceFace.W6;
    }

    private static void remove(Scanner scanner, DiceCup diceCup){
        int faces = 0;
        do {
            System.out.println("\nWelche Würfel möchten sie entfernen?");
            System.out.println("Bitte geben sie die Augemzahl an.");
            System.out.println("Wenn sie alle entfernen möchten, bitte geben sie 0 ein,");
            faces = scanner.nextInt();
        }while (faces != 0 && faces != 4 && faces != 6 && faces != 8 && faces != 10 && faces != 12 && faces != 20 && faces != 30 && faces != 100  );

        if (faces == 0){
            diceCup.removeAll();
        } else {
            diceCup.removeAll(convertFaces(faces));
        }
    }
}
