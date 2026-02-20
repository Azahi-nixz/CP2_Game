import java.util.*;

public class Game {

    static Scanner input = new Scanner(System.in);

    public static void Greetings() {
        System.out.println("""
    Welcome, destined one! You are chosen to partake to a new adventure in the 
    world of Stellaris-4. But such adventure requires preparation. 
    With that, would you like to partake in a tutorial? (RECOMMENDED FOR BEGINNERS!)
    Y/N
    """);

        while (true) {
            try {
                char choice = input.next().charAt(0);

                if (choice == 'N') {
                    mainMenu();
                    break;
                }


                else if (choice == 'Y') {
                    Tutorial();
                    break;
                }

                else {
                    System.err.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Invalid choice! Please try again.");;
            }
        }
    }

    public static void mainMenu() {
        String narration = ("""
                You died in such a boring manner, and as a compensation, you will be reincarnated in 
                another world.
                
                You woke up in a seemingly bright place, odd yet you don't feel any dangers. Just peace.
                
                Isn't it nice?
                
                But no its not. Instead of meeting a goddess to send you out to your adventure, you have been
                greeted by a floating screen.
                """);

        typeWriter(narration);

        String narration1 = ("""
                FLOATING SCREEN: "Hello human, what's your name?" she said in a rather AI-ish manner.
                """);

        typeWriter(narration1);

        System.out.println("Your name: ");
        String name = input.nextLine();

        String narration2 = ("Hello, " + name + ". Welcome to Stellaris-4.");

        typeWriter(narration2);

        String narration3 = ("""
                You tried to speak another word but for some reason, no words came out of your mouth.
                
                FLOATING SCREEN: "Please refrain from speaking unless I asked you to do so."
                
                You feel irritated by her arrogant character, so you decided to smack her with your hand.
                
                """);

        typeWriter(narration3);

        String narration4 = ("""
                FLOATING SCREEN: W-what the hell did you just do? she said, her former AI-ish voice accent? Gone.
                She now sounds like a hololive vtuber who's annoyed by her fans.
                
                But you still can't speak anything, so you just made a silly teasing face to rile her up.
                
                J-Just choose your class already and go out!
                
                And then, a console displayed in front of you. Showing some characters that seems like those characters in the
                RPG games you used to play when you're still alive.
                """);

        typeWriter(narration4);

        System.out.println("""
                GUARD - excels on tanking damage.
                MARKSMAN - excels on long range combat.
                MAGICIAN - primarily uses magic for combat.
                SUPPORT - excels on giving buff and HP regeneration.
                SWORDSMAN - excels on short to mid range combat. Primarily uses sword or any similar weapon.
                ASSASSIN - excels in stealth, surprise attacks.
                BRUTE - excels in hand to hand combat.
                """);

        String characterClass = input.next();

        while (true) {
            try {
                characterClass = characterClass.toLowerCase();

                if  (characterClass.equals("guard")) {
                    //
                    break;
                }

                else if (characterClass.equals("marksman")) {
                    //
                    break;
                }

                else if (characterClass.equals("magician")) {
                    //
                    break;
                }

                else if (characterClass.equals("support")) {
                    //
                    break;
                }

                else if (characterClass.equals("swordsman")) {
                    //
                    break;
                }

                else if (characterClass.equals("asassin")) {
                    //
                    break;
                }

                else if (characterClass.equals("brute")) {
                    //
                    break;
                }

                else {
                    System.err.println("Invalid character choice. Please try again.");
                }
            }
            catch (Exception e) {
                System.err.println("Invalid character choice. Please try again.");
            }
        }








    }

    public static void Tutorial() {
        System.out.println("""
                Welcome to the tutorial! Here, you will learn all basic knowledge about
                this game.
                """);

        System.out.println("""
                STATS:
                There are 7 main stats here in this game:
                HP - your life points
                ATK - your attack
                DEF - your defense (attack - def = total damage)
                MANA - its basically skill points
                SPD - how fast you move and evade
                ACC - accuracy (how sharp your eyes is)
                SANITY - skill points too but special
                You don't get it? Don't worry, as you progress the game,
                you will slowly get the hang out of it!
                """);


        System.out.println("""
                This is a console game so expect this structure sample:
                
                [YOUR LEVEL]
                
                HP - 100/100   DEF - 20    SPD - 5    SANITY - 20/20
                ATK - 50   MANA - 20/20   ACC - 50   MONEY - 2000
                
                [EQUIPMENTS HERE]
                
                [NARRATION HERE]
                
                [MOVE HERE]
                
                Again, don't worry, playing the actual game will help 
                you figure this out better.
                """);

        System.out.println("""
                Buffs, skills, items, and combat exist here, but you will learn about that in-game.
                """);


        System.out.println("Proceed to main menu now? Y/N");


        while (true) {
            try {
                char choice = input.next().charAt(0);

                if (choice == 'Y') {
                    mainMenu();
                } else if (choice == 'N') {
                    Tutorial();
                    System.out.println("Proceed to main menu now? Y/N");
                } else {
                    System.err.println("Invalid choice! Please try again. Remember to use capital letters!");
                }
            } catch (Exception e) {
                System.err.println("Invalid choice! Please try again.");
                ;
            }

        }

    }

    public static void typeWriter(String narration) {
        try {
            for (char c : narration.toCharArray()) {
                System.out.print(c);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Greetings();
    }
}