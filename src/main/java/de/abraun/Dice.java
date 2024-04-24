package de.abraun;

import java.util.Random;

public class Dice {

    public enum DiceFace {
        W4(4), W6(6), W8(8), W10(10), W12(12), W20(20), W30(30), W100(100);
        private final int faces;

        DiceFace(int faces) {
            this.faces = faces;
        }

        public int getFaces() {
            return faces;
        }
    }

    private DiceFace diceFace = DiceFace.W6;
    private final Random dice = new Random();
    private int value = 0;

    Dice(DiceFace diceFace){
        this.diceFace = diceFace;
    }

    public int roll(){
        this.value = dice.nextInt(diceFace.getFaces()) ;
        return ++this.value;
    }

    public int getValue(){
        return this.value;
    }

    public DiceFace getDiceFace(){
        return this.diceFace;
    }

}
