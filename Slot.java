public class Slot{

    int result; 
    
    public Slot(){
    initiate();
    }

    public void initiate(){
     result = (int)(Math.random() * 6) + 1; 
    }
    public int getSlotResults(){
        return result; 
    }
        
}

    