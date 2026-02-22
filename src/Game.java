import java.util.*;

public class Game {

    static Scanner input = new Scanner(System.in);

    static int plotProgression = 0;
    static int damage = 0;
    static int turn = 0;

    //CHARACTER STATS
    static String finalStats = "";
    static String finalName = "";
    static int exp = 0;
    static int finalExp = 0;
    static int level = 0;
    static int ATK = 0;
    static int DEF = 0;
    static int HP = 0;
    static int MP = 0;
    static int ACC = 0;
    static int SPD = 0;
    static int SANITY = 0;

    static int characterClassStats[][] = {
            {200, 20, 100, 10, 20, 10, 50}, //GUARD STATS
            {100, 50, 50, 20, 30, 50, 50}, // MARKSMAN STATS
            {100, 30, 50, 100, 20, 30, 60}, //MAGICIAN STATS
            {150, 20, 80, 100, 20, 10, 100}, //SUPPORT STATS
            {100, 70, 50, 10, 20, 20, 50}, //SWORDSMAN STATS
            {70, 100, 20, 30, 50, 50, 50}, //ASSASSIN STATS
            {150, 70, 80, 10, 10, 10, 50}, //BRUTE STATS
            {0},     //MONEY
            {1, 0, 100}  //LVL MANAGEMENT
    };

    //ENEMY STATS
    static int enemyLevel = 0;
    static int enemyATK = 0;
    static int enemyDEF = 0;
    static int enemyHP = 0;
    static int enemyMP = 0;
    static int enemyACC = 0;
    static int enemySPD = 0;
    static int enemySANITY = 0;
    static String enemyClass = "";
    static String CLASS = "";
    static int enemyDamage = 0;

   static String entitiesList[][] = {
           {"Orc" , "Orc General" , "Orc King"},
           {"Wolf" , "Dire Wolf" , "Werewolf"},
           {"Goblin" , "Hobgoblin" , "Goblin King"},
           {"Elf" , "Druid" , "Forest Deity"},
           {"Slime"}
   };

   static int entityStats[][] = {
           //ORCS
           {100, 20, 20, 0, 20, 10, 0},
           {200, 50, 40, 0, 30, 20, 0},
           {500, 100, 80, 40, 30, 40, 100},

           //WOLF
           {75, 50, 20, 0, 30, 50, 0},
           {150, 100, 30, 0, 40, 70, 0},
           {200, 150, 40, 20, 70, 100, 0},

           //GOBLIN
           {150, 20, 20, 0, 20,30, 0},
           {300, 40, 40, 0, 30, 40, 0},
           {700, 70, 80, 40, 30, 60, 100},

           //ELF
           {200, 50, 80, 100, 40, 50, 400},
           {450, 120, 100, 350, 80, 80, 750},
           {1000, 300, 150, 600, 200, 120, 1000},

           //SLIME
           {50, 20, 10, 0, 10, 10, 0}
   };
   //================================================================
   // FUNCTION FOR ENEMY STATS COMPUTATION & PRINTING
   //================================================================
    public static void enemy(String enemy, int enemyLevel, int enemyNum) {

        enemyHP     = (entityStats[enemyNum][0] + (enemyLevel * 5));
        enemyATK    = entityStats[enemyNum][1] + (enemyLevel * 5);
        enemyDEF    = entityStats[enemyNum][2] + (enemyLevel * 5);
        enemyMP     = entityStats[enemyNum][3] + (enemyLevel * 5);
        enemySPD    = entityStats[enemyNum][4] + (enemyLevel * 5);
        enemyACC    = entityStats[enemyNum][5] + (enemyLevel * 5);
        enemySANITY = entityStats[enemyNum][6] + (enemyLevel * 5);

        String stats = """
            ENEMY STATS : %s  LVL - %d
            HP: %d | ATK: %d | DEF: %d | MANA: %d | SPD: %d | ACC: %d | SANITY: %d
            """.formatted(
                enemy,
                enemyLevel,
                enemyHP,
                enemyATK,
                enemyDEF,
                enemyMP,
                enemySPD,
                enemyACC,
                enemySANITY
        );

        System.out.println(stats);
    }

     //=============================================================================
     // DAMAGE CALCULATIONS
     //=============================================================================
    public static int calculateDamageToEnemy() {

            damage = ATK - (enemyDEF / 2);
            if (damage < 1) { damage = 1; }

        return damage;
    }

    public static int calculateDamage() {

         enemyDamage = enemyATK - (DEF / 2);
        if (enemyDamage < 1) { enemyDamage = 1; }

        return enemyDamage;
    }

     //=====================================================
     // FOR HIT CHANCE
     //=====================================================
    public static boolean checkHit() {
        double chance = (double) ATK / (ATK + enemySPD);
        return Math.random() < chance;

    }

    public static boolean checkHitForEnemy() {
        double chance = (double) enemyATK / (enemyATK + SPD);
        return Math.random() < chance;

    }

     //================================================
     // COMBAT MECHANICS
     //================================================
    public static void action() {
        if (checkHit()) {
            enemyHP -= calculateDamageToEnemy();
            System.out.println("HIT!");
        }

        else {
            System.out.println("MISS!");
        }
    }

    public static void actionEnemy() {
        if (checkHitForEnemy()) {
            HP -= calculateDamage();
            System.out.println("HIT!");
        }
        else {
            System.out.println("MISS!");
        }
    }

     //=======================================================
     // LEVEL-UP MECHANICS
     //========================================================
    public static void levelManagement(int expAdded) {
        exp += expAdded;
        if (exp >= finalExp) {
            level++;
            exp -= finalExp;
            finalExp += 50;

            switch (CLASS.toUpperCase()) {
                case "GUARD":
                    HP += 20;
                    ATK += 5;
                    DEF += 20;
                    MP += 5;
                    ACC += 5;
                    SPD += 10;
                    SANITY += 10;
                    break;
                case "MARKSMAN":
                    HP += 5;
                    ATK += 20;
                    DEF += 5;
                    MP += 10;
                    ACC += 25;
                    SPD += 10;
                    SANITY += 10;
                    break;
                case "MAGICIAN":
                    HP += 10;
                    ATK += 10;
                    DEF += 5;
                    MP += 20;
                    ACC += 5;
                    SPD += 5;
                    SANITY += 15;
                    break;
                case "SUPPORT":
                    HP += 10;
                    ATK += 5;
                    DEF += 5;
                    MP += 20;
                    ACC += 5;
                    SPD += 10;
                    SANITY += 25;
                    break;
                case "SWORDSMAN":
                    HP += 10;
                    ATK += 20;
                    DEF += 10;
                    MP += 5;
                    ACC += 5;
                    SPD += 5;
                    SANITY += 10;
                    break;
                case "ASSASSIN":
                    HP += 5;
                    ATK += 25;
                    DEF += 5;
                    MP += 5;
                    ACC += 25;
                    SPD += 25;
                    SANITY += 5;
                    break;
                case "BRUTE":
                    HP += 10;
                    ATK += 10;
                    DEF += 10;
                    MP += 5;
                    ACC += 10;
                    SPD += 10;
                    SANITY += 10;
                    break;
            }
        }

    }

     //=================================================================
     // CHARACTER STATS
     //=================================================================
    public static void stats(int characterClassNum, String characterClass) {
        String stats = """
                Character STATS : %s  LVL - %d (EXP: %d / %d)
                HP: %d | ATK: %d | DEF: %d | MANA: %d | SPD: %d | ACC: %d | SANITY: %d | MONEY: %d
                """.formatted(
                   characterClass,
                    characterClassStats[8][0],
                    characterClassStats[8][1],
                    characterClassStats[8][2],
                    characterClassStats[characterClassNum][0],
                    characterClassStats[characterClassNum][1],
                    characterClassStats[characterClassNum][2],
                    characterClassStats[characterClassNum][3],
                    characterClassStats[characterClassNum][4],
                    characterClassStats[characterClassNum][5],
                    characterClassStats[characterClassNum][6],
                    characterClassStats[7][0]

        );

        level =  characterClassStats[8][0];
        exp = characterClassStats[8][1];
        finalExp = characterClassStats[8][2];
        HP = characterClassStats[characterClassNum][0];
        ATK = characterClassStats[characterClassNum][1];
        DEF = characterClassStats[characterClassNum][2];
        MP = characterClassStats[characterClassNum][3];
        SPD = characterClassStats[characterClassNum][4];
        ACC = characterClassStats[characterClassNum][5];
        SANITY = characterClassStats[characterClassNum][6];
        CLASS =  characterClass.toUpperCase();
        finalStats += stats;


    }

     //============================================
     // TYPING EFFECT
     //============================================
    public static void typeWriter(String narration) {
        try {
            for (char c : narration.toCharArray()) {
                System.out.print(c);
                Thread.sleep(25);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     //====================================
     // RESULT OF THE BATTLE HANDLER
     //====================================
    public static void result() {
        if (HP < 0) {
            System.out.println("You lose.");
        }

        else if (enemyHP < 0) {
            System.out.println("You win!");
        }
    }

     //=========================
     // TUTORIAL
     //=========================
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

     //===================================================
     // PROLOGUE
     //====================================================
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
        input.nextLine();
        String name = input.nextLine();

        finalName = name;


        String narration2 = ("Hello, " + name + ". Welcome to Stellaris-4.");

        typeWriter(narration2);

        String narration3 = ("""
                You tried to speak another word but for some reason, no words came out of your mouth.
                
                FLOATING SCREEN: "Please refrain from speaking unless I asked you to do so."
                
                You feel irritated by her arrogant character, so you decided to smack her with your hand.
                
                """);

        typeWriter(narration3);

        String narration4 = ("""
                FLOATING SCREEN: "W-what the hell did you just do?" she said, her former AI-ish voice accent? Gone.
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
                
                Please choose your class. Make sure to spell it correctly. (NON-SENSITIVE CASE)
                """);



        while (true) {
            try {

                String characterClass = input.nextLine().trim().toLowerCase();


                if  (characterClass.equals("guard")) {
                    stats(0, "GUARD");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("marksman")) {
                    stats(1, "MARKSMAN");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("magician")) {
                    stats(2, "MAGICIAN");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("support")) {
                    stats(3, "SUPPORT");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("swordsman")) {
                    stats(4, "SWORDSMAN");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("assassin")) {
                    stats(5, "ASSASSIN");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else if (characterClass.equals("brute")) {
                    stats(6, "BRUTE");
                    System.out.println("Class picked successfully!");
                    break;
                }

                else {
                    System.err.println("Invalid character choice. Perhaps you spelled it wrong?");
                }
            }
            catch (Exception e) {
                System.err.println("Invalid character choice. Perhaps you spelled it wrong?");
            }
        }

        String narration5 = ("""
                As you pick your class, the floating screen suddenly flickered on its own. For a second, you got worried
                because it might be damaged when you hit it...
                
                But after a while, she spoke:
                
                FLOATING SCREEN: "Class successfully identified. You may go now.", she said in a dismissive manner.
                Then, a suddenly, a hole appeared below you, then you fell...
                
                Below you, a forest... seemingly stretching all the way to the horizon...
                
                You're accelerating fast, so if you hit the ground, surely you will die.
                
                YOU: AHHHHH I"M GONNA DIE!
                
                But, in your desperate attempt to survive, the floating screen once appeared in front of you.
                
                FLOATING SCREEN: "Relax, you won't die."
                
                INITIALIZING..................
                -------------------------------------------------
                Launching Elysia.exe..............................
                
                Those texts appeared on the floating screen console. It just look like a computer CMD back from your previous world.
                
                Elysia.exe force teleportation: (10, 24)
                
                In a blink of an eye, you landed. As if you just got teleported.
                
                The floating screen looked at you (you just felt her looking at you even tho she has no face)
                
                FLOATING SCREEN: "Scared? You should remember that sensation from now on! I am Elysia, your personal guide in this world!"
                """);
        plotProgression += 10;
        typeWriter(narration5);

    }

     //======================================================
     // PART 1
     //======================================================
    public static void partOne() {
        String narration1 = ("n/Look! Enemy Appeared! Let's take it down!");
        typeWriter(narration1);

        enemy("Wolf" , 2 , 3);

        System.out.println("""
                Your stats:
                """);

        System.out.println(finalStats);

        while (HP > 0 && enemyHP > 0) {

            System.out.println("""
                    What would you like to do? (Choose a number to move)
                    
                    1. ATTACK!
                    2. USE SKILL! (LOCKED)
                    3. CONSUME ITEM! (LOCKED)
                    """);

            try {
                int move = input.nextInt();

                if (move == 1 || turn == 0) {
                    action();
                    System.out.println("ENEMY HP: " + enemyHP);
                    turn += 1;
                } else {
                    System.out.println("Invalid move!");
                }
            } catch (Exception e) {
                System.out.println("Invalid move!");
            }

            if (turn == 1) {
                System.out.println("Wolf used its basic attack!");
                actionEnemy();
                System.out.println("CURRENT HP: " + HP);
                turn -= 1;
            }

            result();


        }



    }

     //====================================================
     // MAIN CLASS
     //====================================================
    public static void main(String[] args) {
        Greetings();

        if (plotProgression == 10) {
           partOne();
        }
    }
}