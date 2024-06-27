package game;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    public static int round = 0;

    public static void startGame(){
        Boss boss = new Boss(2300, 50, "Boss");

        Witcher witcher = new Witcher(500, 10, "Witcher");
        Magic magic = new Magic(350, 15, "Magic");
        Hacker hacker = new Hacker(320, 5, "Hacker");
        Reaper reaper = new Reaper(800, 5, "Reaper");
        Ludoman ludoman = new Ludoman(350, 5, "Ludoman");
        Spitfire spitfire = new Spitfire(500, 5, "Spitfire");
        Hero[] heroes = {witcher, magic, hacker, reaper, ludoman, spitfire};

        System.out.println("------------- Start game Assemble  -------------");
        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)){
            round(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss thanos, Hero[] heroes){
        if (thanos.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                return false;
            }
        }
        System.out.println("Boss won!!!");
        return true;
    }

    private static void round(Boss boss, Hero[] heroes){
        round++;
        boss.chooseDefence();
        System.out.println("-------------ROUND " + round + " -------------");
        boss.attackBoss(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getSuperAbilityEnum() != boss.getDefence()){
                heroes[i].attackHero(boss);
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

}
