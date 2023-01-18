import java.util.Random;

public class Die {
    int value;

    public Die(){
        // roll through images
        value = (int)(Math.random() * 6) + 1;

    }   
    public int value(){
        return value;
    }
}

// two in front of you (bottom middle) and two further away (top middle)