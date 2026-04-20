package lab7;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private static PasswordMaker instance;
    private static int callCount = 0;

    private String name;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker("SingletonUser");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance() {
        callCount++;
        return instance;
    }

    public static int getCallingCounts() {
        return callCount;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}