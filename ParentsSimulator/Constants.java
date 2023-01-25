import greenfoot.GreenfootSound;

/**
 * This class is a place to store the static or final object and variables, which 
 * can make sure the switch between worlds can be smooth and to protect some values.
 * 
 * backgroundMusic
 * Music by <a href="https://pixabay.com/users/23117649-23117649/?utm_source=link-attributi
 * on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=7741">23117649</a> from
 * <a href="https://pixabay.com//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_c
 * ampaign=music&amp;utm_content=7741">Pixabay</a>
 * 
 * @author Yixin Cai
 * @version 2023-01-23
 */
public class Constants  
{
    public static String[][] activityNames = {
        { "Alphabet", "Speak", "Walk" },
        { "Art", "Math", "Music", "PE", "Science" },
        { "AdvFunc", "Band", "CS", "English", "Business" }
    };
    
    public static int[][][] activityPoints = {
        { {1,0,1,0}, {0,2,0,0}, {1,0,0,1} },
        { {0,0,1,2}, {3,0,0,0}, {0,2,0,1}, {0,2,0,1}, {1,0,2,0} },
        { {4,0,0,0}, {0,0,2,2}, {1,0,1,2}, {0,2,2,0}, {0,3,0,1} }
    };
    
    /**
    public static final GreenfootImage[][] effectImages = {
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        },
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        },
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        }
    };
    */
    
    public static String[][] randomChoiceQuestions = {
        { 
            "While at a family dinner, your mom points out that Pipo\n is getting too chubby. How do you respond?",
            "You bring your child to a fortune teller. They tell you\n that depending on what object the baby chooses, their\n future can be told."
        },
        { 
            "While going on a stroll, you pass by a homeless man\n asking for food. With Pipo holding onto your hand and\n looking at the man, what would you do?",
            "While at a restaurant with Pipo, you experience horrible\n service and the food doesn't taste good. How do you\n react when the bill comes?"
        },
        { 
            "After you pick up Pipo from school, the homeroom teacher\n mentions that Pipo is very quiet and not socializing\n too much during recess. What do you do?",
            "One day, Pipo’s uncle, Bipo, asks if you could host a\n play-date with his child, Bobo. Bobo is very mean\n and aggressive. What do you do?"
        }
    };
    
    public static String[][][] randomChoiceAnswers = {
        {
            { 
                "It’s good that babies are chubby, that makes them cute!",
                "Pipo needs a lot of food for his growth and development",
                "I understand, I will make sure he doesn’t overeat"
            },
            {
                "Pipo chooses a $5 bill",
                "Pipo chooses a paintbrush",
                "Pipo chooses a calculator"
            }
        },
        {
            {
                "Give the man food, money, or water",
                "Ignore the man and proceed with your life",
                "Tell Pipo that he has to work hard in life"
            },
            {
                "Angrily - You yell at the waiter and refuse to pay",
                "Calmly - You pay for your food and never go back again",
                "Somewhat unhappily but calmly - You and Pipo leave after\n paying but you tell Pipo to never settle for the bare minimum"
            }
        },
        {
            {
                "Tell Pipo to open up more and to try making more friends",
                "Accept Pipo for who they are and do nothing (maybe they’re an introvert)",
                "Yell at Pipo for never talking and force him to make new friends"
            },
            {
                "Say yes and watch the play-date carefully (knowing that\n Bipo is there and may not like you scolding Bobo)",
                "Make an excuse and say that you and Pipo are going to be\n busy all week, even though Pipo knows you are lying",
                "Say no and suggest for them to get-together in the near\n future, even though Pipo wants to meet Bobo"
            }
        }
    };
    
    public static int[][][][] randomChoiceResults = {
        { { {0,1,0,1}, {1,0,1,0}, {0,-1,-1,0} }, { {1,0,0,1}, {0,1,0,1}, {1,0,1,0} } },
        { { {0,2,2,0}, {0,-1,-1,0}, {2,-1,1,0} }, { {0,-2,-1,0}, {1,1,1,0}, {1,1,0,2} } },
        { { {0,3,1,2}, {1,1,2,1}, {-1,-2,-2,-1} }, { {1,2,-3,0}, {2,2,0,-3}, {0,-1,-1,-2} } },
    };
    
    
    // I know the most recommended format is wav, but its size is too big about 38MB.
    // Therfore, I use mp3 format to reduce the size to 6 MB.
    public static final GreenfootSound backgroundSound = new GreenfootSound("main.mp3");
    public static final GreenfootSound pixelSound = new GreenfootSound("pixel.mp3");
    public static final GreenfootSound chessSound = new GreenfootSound("chess.mp3");
    public static final GreenfootSound memorySound = new GreenfootSound("memory.mp3");
    public static final GreenfootSound successSound = new GreenfootSound("success.wav");
    public static final GreenfootSound failSound = new GreenfootSound("fail.wav");
}
