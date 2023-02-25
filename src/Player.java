public class Player {
    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private boolean alive;
    private int dM;
    private int dN;
    private int healCount;

    Player(int attack, int defense, int maxHealth, int dM, int dN) {
        setAttack(attack);
        setDefense(defense);
        setMaxHealth(maxHealth);
        this.health = maxHealth;

        this.dM = dM;
        this.dN = dN;
        alive = true;
        healCount = 0;
    }

    public boolean heal() {
        if (healCount < 3) {
            healCount++;
            if (health + maxHealth * 0.5 >= maxHealth)
                health = maxHealth;
            else
                health += (maxHealth * 0.5);
            return true;
        }
        return false;
    }

    public void hit(Monster a) {
        if (!a.isAlive()) {
            System.out.println(a.getClass().getSimpleName() + " already dead");
            return;
        }
        int modifier = this.attack - a.getDefense() + 1;
        System.out.println("mod: " + modifier);
        int cube;
        boolean makeHit = false;


        int i = 0;
        do {
            System.out.println("i: " + i);
            cube = rand(1, 6);
            System.out.println("Cube: " + cube);
            if (cube == 5 || cube == 6) {
                makeHit = true;
                break;
            }
            i++;
        } while (i <= modifier);

        if (makeHit) {
            int r = rand(dM, dN);
            int tmp = a.getHealth() - r;
            a.setHealth(Math.max(tmp, 0));
            System.out.println("hit: " + r);
            if (a.getHealth() == 0) {
                a.setAlive(false);
                System.out.println(this.getClass().getSimpleName() + " has won");
            }
        }
    }

    private int rand(int start, int end) {
        return start + (int)(Math.random() * ((end - start) + 1));
    }






    public int getHealCount() {
        return healCount;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setAttack(int attack) {
        if (attack < 1 || attack > 20) {
            System.out.println("Не верное задана атака (диапазон 1-20)");
            System.out.println("Будет выбрано случайное значение");
            this.attack = rand(1, 20);
            return;
        }
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefense(int defense) {
        if (defense < 1 || defense > 20) {
            System.out.println("Не верное задана защита (диапазон 1-20)");
            System.out.println("Будет выбрано случайное значение");
            this.defense = rand(1, 20);
            return;
        }
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setHealth(int health) {
        if (health < 0) {
            System.out.println("Не верно задано здоровье");
            return;
        }
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    private void setMaxHealth(int maxHealth) {
        if (maxHealth < 0) {
            System.out.println("Не верно задано здоровье");
            System.out.println("Будет выбрано случайное значение");
            this.maxHealth = rand(5, 20);
            return;
        }
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

}
