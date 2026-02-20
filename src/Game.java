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

                if (choice == 'Y') {
                    mainMenu();
                    break;
                }


                else if (choice == 'N') {
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
        System.out.println();
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
                
                HP - 100/100   DEF - 20    SPD - 5    SANITY - 20/20
                ATK - 50   MANA - 20/20   ACC - 50   MONEY - 2000
                
                [SKILLS HERE]
                
                [BUFFS HERE]
                
                [NARRATION HERE]
                
                [MOVE HERE]
                
                Again, don't worry, playing the actual game will help 
                you figure this out better.
                """);

        System.out.println("""
                Buffs, skills, and combat exist here, but you will learn about that in-game.
                """);

        System.out.println("Proceed to main menu now? Y/N");


        while (true) {
            try {
                char choice = input.next().charAt(0);

                if (choice == 'Y') {
                    mainMenu();
                    break;
                } else if (choice == 'N') {
                    Tutorial();
                    System.out.println("Proceed to main menu now? Y/N");
                } else {
                    System.err.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Invalid choice! Please try again.");
                ;
            }

        }

    }

    public static void main(String[] args) {
        Greetings();
    }
}