/**
 *  This class is the main class of an extension of World of Zuul, taking place 
 *  in Raritan Valley Community College.
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling, David J. Barnes and Ali Khan
 * @version 2019.04.08
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room backRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, TestingCenter, Studentlounge
        , Bathroom, Garden, parkinglot, ArtCenter, ScienceBuilding, WestBuilding
        ,Planetarium, Library, Closet;
        //Declare item references
        Item space, 
        outsidei,outsidei2, 
        theateri,theateri2,
        pubi2, pubi,
        labi2, labi,
        officei2, officei,
        testi,testi2,
        studi,studi2,
        bathi,bathi2,
        gardi,gardi2,
        parki,parki2,
        arti,arti2,
        sciencei,sciencei2,
        westi,westi2,
        plani,plani2,
        libi,libi2,
        closeti,closeti2;
        
        //Create items
        space = new Item("It's quite spacious in here.","",0);
        
        outsidei = new Item("There is a welcome sign."," Welcome to RVCC",0);
        outsidei2 = new Item("There's also a car parked outside","The car is a 2017 blue Honda Accord",5000);
        
        theateri = new Item("A TV Monitor is mounted onto the wall.","The monitor is a Sony Bravia 60inch",500);
        theateri2 = new Item("There's a couch in here","The couch looks quite comfy. There's a tv remote on the armrest.",600);

        pubi = new Item("A vending machine is against the wall.","The vending machine contains $1.50 soda bottles", 1000);
        pubi2 = new Item("There's a microwave in here too","Someone left their lunch in there...wouldn't want that to go to waste..", 100);

        labi = new Item("There's a microscope plugged in on the table","A heart valve histology slide is placed in",200);
        labi2 = new Item("There's an eyeball model on the desk.","Looks like someone was studying it.",200);

        officei = new Item("Someone left their desktop monitor on."," It seems like someone was coding java on it", 300);
        officei2 = new Item("There's a name plaque here."," It reads Professor Crosbie.", 300);
        
        parki = new Item("There's a motorcycle parked outside."," It's a kawasaki Versys-X.", 0);
        parki2 = new Item("Someone dropped a dollar."," It's fake...", 10);
        
        gardi = new Item("There are gardening tools on the floor."," They're covered in moist fertile soil.", 200);
        gardi2 = new Item("There's a flower bed","It's mostly daisies. ", 0);
        
        testi = new Item("Someone left their test monitor on."," They scored a 95. Nice!", 0);
        testi2 = new Item("Someone left their calculator."," It's a scientific calculator.", 300);
        
        closeti = new Item("It's the janitor's uniform."," The name tag reads John", 300);
        closeti2 = new Item("There's a netgear router here."," This might belong to the CISY department.", 50);
        
        studi = new Item("There's a vending machine here."," It's got everything from fruit snacks to cookies!", 1000);
        studi2 = new Item("There's a notebook here."," It's a sign in sheet.", 50);
        
        westi = new Item("There's a switch rack here."," All the cables are unplugged.", 400);
        westi2 = new Item("Someone left a raspberry pie."," This looks like Professor Wooddall's", 50);
        
        arti = new Item("There are paintings on the table."," They're abstracts of all sorts of color.", 200);
        arti2 = new Item("There are color pencils on the shelf.","They look brand new.", 30);
        
        sciencei = new Item("There's a bench here."," Looks comfortable.", 300);
        sciencei2 = new Item("Across is a diagram of a cell."," Mitochondria are the powerhouse of a cell.", 100);
        
        plani = new Item("There are planet models."," There's earth!", 500);
        plani2 = new Item("There's a telescope."," It's a 14inch Celestron telescope.", 300);
        
        bathi = new Item("There are soaps on the countertop."," Bar soaps are unusual for a public restroom..", 20);
        bathi2 = new Item("There's one stall.."," Someone's using it.", 300);
        
        libi = new Item("There's a bookshelf."," It's filled completely with computer books.", 300);
        libi2 = new Item("it's quite spacious here",".", 0);
        // create the rooms
        outside = new Room("You're outside the main entrance of the university",outsidei,outsidei2);
        theater = new Room("You're in a lecture theater",theateri,theateri2);
        pub = new Room("You're in the campus pub",pubi,pubi2);
        lab = new Room("You're in a computing lab",labi,labi2);
        office = new Room("You're in the computing admin office",officei,officei2);
        parkinglot = new Room("You're in the parkinglot",parki,parki2);
        Garden = new Room("You've found yourself in a garden",gardi,gardi2);
        ArtCenter = new Room("It's the art center.",arti,arti2);
        WestBuilding = new Room("It's west building.",westi,westi2);
        ScienceBuilding = new Room("It's science building.",sciencei,sciencei2);
        Library = new Room("You've found the library.",libi,libi2);
        Studentlounge = new Room("You're in the student lounge.",studi,studi2);
        TestingCenter = new Room("You're in the testing center.",testi,testi2);
        Bathroom = new Room("You're in the bathroom.",bathi,bathi2);
        Closet = new Room("You're in a closet...the wind closed the door and it's locked!",closeti,closeti2);
        Planetarium = new Room("You're in the planetarium",plani,plani2);
         
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", pub);
        outside.setExit("west", pub);
        outside.setExit("north", parkinglot);
        
        theater.setExit("north",Planetarium);
        theater.setExit("west", outside);
        theater.setExit("east", Bathroom);
        
        Bathroom.setExit("west",theater);
        
        
        lab.setExit("east", pub );
        lab.setExit("south", office);
        lab.setExit("west",ScienceBuilding);
        
        pub.setExit("north", outside);
        pub.setExit("east", Studentlounge);
        pub.setExit("south", Library);
        pub.setExit("west", lab);
        
        Studentlounge.setExit("west",pub);
        
        ScienceBuilding.setExit("north", ArtCenter);
        ScienceBuilding.setExit("east", lab);
        ScienceBuilding.setExit("south", WestBuilding);
        
        office.setExit("west", WestBuilding);
        office.setExit("east", Library);
        
        Library.setExit("north",pub);
        Library.setExit("south",TestingCenter);
        Library.setExit("east",Closet);
        Library.setExit("west", office);
        
        TestingCenter.setExit("north",Library);
        
        Planetarium.setExit("south",theater);
        
        WestBuilding.setExit("north",ScienceBuilding);
        WestBuilding.setExit("east", office);
        
        ArtCenter.setExit("east",Garden);
        ArtCenter.setExit("south", ScienceBuilding);
        
        Garden.setExit("west",ArtCenter);
        Garden.setExit("east",parkinglot);
        
        parkinglot.setExit("west",Garden);
        parkinglot.setExit("south",outside);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Raritan Valley Community College");
        System.out.println("Explore the campus by looking around and see what you find.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getShortDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;
            
            case BACK:
                backRoom(command);
                break;
                
            case EAT:
                eat(command);
                break;
                
            case LOOK:    
                look(command);
                break;
                
            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void look(Command command) 
    {
        System.out.println(currentRoom.getLongDescription());
        parser.showCommands();
    }
    /**
     * Print out what you ate.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void eat(Command command) 
    {
        System.out.println("You ate an apple");
        System.out.println(currentRoom.getShortDescription());
        parser.showCommands();
    }
     
    private void backRoom(Command command){
        if(command.hasSecondWord()){
            //if a second word is inputted
            System.out.println("A direction isn't required");}
         else{
            
        currentRoom = backRoom;
        System.out.println(currentRoom.getShortDescription());
       }
    }
    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There's no way!");
        }
        else {
            backRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
