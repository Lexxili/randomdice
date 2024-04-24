package de.abraun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceCup {
    List<Dice> diceCup = new ArrayList<>();

    DiceCup(){}

    DiceCup(Dice.DiceFace diceFace, int ammountOfDices){
        addDices(diceFace, ammountOfDices);
    }

    public void addDices(Dice.DiceFace diceFace, int ammountOfDices){
        if (ammountOfDices <= 0){ return; }

        for (int counter = 0; counter < ammountOfDices; counter++) {
            diceCup.add(new Dice(diceFace));
        }
    }

    public void roll(){
        if ((diceCup.isEmpty())){
            return;
        }
        for (Dice dice:diceCup){
            dice.roll();
        }
        printDices();
    }

    public void removeAll(){
        diceCup = new ArrayList<>();
    }

    public void removeAll(Dice.DiceFace diceFaceToRemove){

        for (Dice dice: diceCup){
            if (dice.getDiceFace() == diceFaceToRemove){
                diceCup.remove(dice);
            }
        }
    }

    public void printDices(){
        printDicesOptimized(false);
    }

    public void printDicesOptimized(boolean withZeros){
        StringBuilder output = new StringBuilder("Wurfergebnis:\n");

        Map<Dice.DiceFace, List<Integer>> diceMap = new HashMap<>();
        //Converts DiceList in DiceMap to print
        for (Dice dice:diceCup){
            if(diceMap.containsKey(dice.getDiceFace())){
                diceMap.get(dice.getDiceFace()).add(dice.getValue());
            } else {
                diceMap.put(dice.getDiceFace(), new ArrayList<>());
                diceMap.get(dice.getDiceFace()).add(dice.getValue());
            }
        }

        for (Dice.DiceFace face : Dice.DiceFace.values()){
            if(withZeros & !diceMap.containsKey(face)){
                output.append("W" + face + " = 0\n");
            }else if (!withZeros & !diceMap.containsKey(face)){
            }else{
                output.append(face + " = ");
                for (Integer value: diceMap.get(face)){
                    output.append(value + ", ");
                }
                output.delete(output.length()-2, output.length()-1);
                output.append("\n");

            }
        }
        System.out.println(output);
    }
}
