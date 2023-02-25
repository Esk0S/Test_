

public class Main {
    public static void main(String[] args) {


        // healTest
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//        m.heal();
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//
//        m.setHealth(4);
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//        m.heal();
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//
//        m.setHealth(3);
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//        m.heal();
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//
//        m.setHealth(2);
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
//        m.heal();
//        System.out.println("health: " + m.getHealth() + " heal count: " + m.getHealCount());
        Monster m = new Monster(13, 7, 20, 1, 6);
        Player a = new Player(6, 9, 20, 1, 6);

        for (int i = 0; i < 100; i++) {
            if (!m.isAlive() || !a.isAlive()) {
                break;
            }
            m.hit(a);
            System.out.println("Player health: " + a.getHealth());
            if (1 + (int)(Math.random() * ((3 - 1) + 1)) == 1) {
                if (!m.heal()) {
                    System.out.println("healing is over for Monster");
                }
                System.out.println("Monster healed");
            }
            a.hit(m);
            System.out.println("Monster health: " + m.getHealth());
            if (1 + (int)(Math.random() * ((3 - 1) + 1)) == 1) {
                if (!a.heal()) {
                    System.out.println("healing is over for Player");
                }
                System.out.println("Player healed");
            }
        }


    }
}