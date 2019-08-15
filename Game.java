import java.util.Scanner;


/**
 @author Matt Haefele
 @version 1.0
*/

public class Game{
    private static String[] classes = {"pyromancer", "rogue" , "arcanist", "cleric", "warrior"};
    private static String[] alignments = {"lawful", "neutral", "choatic"};
    private static boolean debug = false;


    public static void main(String[] args){
	if(args[0] != null){
	    debug = true;
	}
        Player player = new Player();
	player.setName(init());
	player.setUserClass(classSelection());
	if(player.getClass().equals("pyromancer")){
            player.setWeapon(pyromancerStart());
        }
	if(debug == true){
	    System.out.println(player.getWeapon());
	}
	alignment(player);
    }

    public static String init (){
        Scanner input = new Scanner(System.in);
	print("You awaken in a dimly lit apothecary...\n");
	continuePrompt();
	print(" 'Ahh... you're awake.' A hunched aged man mutters gazing into a dully cackling fire. 'I suppose I should ask you your name, if you can recollect it.'\n ");
	print("Enter a name : \n");
	String name = input.nextLine();
	return name;
   }//end init

    public static void continuePrompt(){
	Scanner input = new Scanner(System.in);
	System.out.println("Press enter to continue");
	String continueOn = input.nextLine();
    }//end continue method

    public static void print(String element){
        System.out.println(element);
    }//end print reduction

    public static String classSelection(){
	print("Before I discovered you...who were you?\n");
	int formatter = 1;
	for(int i = 0; i < classes.length; i++){
            System.out.printf(" %d) %s \n", formatter++ , classes[i].toUpperCase());
	}
	print("Select a class\n");
	Scanner input = new Scanner(System.in);
	int number = input.nextInt();
	String choice = classes[number-1];
	return choice;
    }//end class selection

    public static void alignment(Player player){
        print("You were robbed? Or caught up with the law? Tell me what happened...\n");
	Scanner input = new Scanner(System.in);
	print("1) Say Nothing");
	print("2) Claim to be law-abiding");
	print("3) Break eye contact with the caretaker\n");
	int choice = input.nextInt();
	if(choice == 1){
	    player.setAlignment("neutral");
	}
	else if(choice == 2){
	    player.setAlignment("lawful");
	}
	else{
            player.setAlignment("choatic");
	}
	print("Doesn't matter. What matters is your survived.");
	
    }
    
    public static boolean leaveTown(){
        print("Are you ready to leave this area?");
	print("1)Yes\n2)No\n");
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	if(choice == 1){
	    return true;
	}
	return false;
    }

    public static Palantir pyromancerStart(){
        print("Ahhh... a pyromancer..Surely you are familiar with the weaponry the Gruul firecasters use? The palantir? Here... take mine, you wont be able to conjure anything of use without it");
	//add more lore
	Palantir palantir = new Palantir(100, "Pyromancy Orb", "Palantir", 5);
	return palantir;
    }




}
