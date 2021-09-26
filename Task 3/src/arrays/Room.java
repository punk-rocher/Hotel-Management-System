package arrays;

public class Room {

    private String mainName;               // protected String mainName;
    int guestsInRoom;

    public Room() {
        mainName = "";

    }

    public void setName(String aName) {
        //  System.out.println("add name class method ");
        mainName = aName;
    }

    public String getName() {
        return mainName;
    }

}


