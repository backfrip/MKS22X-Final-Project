package object;

import java.util.*;

public class Stats {
    private int maxHealth, maxEnergy, ATK, DEX, INT;
    private Scanner scan;
    
    public Stats(String str){
    	setStats(str);
    }

    public Stats (int mH, int mE, int a, int d, int i) {
	setMaxHealth(mH);
	setMaxEnergy(mE);
	setATK(a);
	setDEX(d);
	setINT(i);
    }
    
    public void setStats(String filename){
    	scan = new Scanner("")
    }

    public int getMaxHealth() {
	return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
	this.maxHealth = maxHealth;
    }

    public int getMaxEnergy() {
	return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
	this.maxEnergy = maxEnergy;
    }

    public int getATK() {
	return ATK;
    }

    public void setATK(int aTK) {
	ATK = aTK;
    }

    public int getDEX() {
	return DEX;
    }

    public void setDEX(int dEX) {
	DEX = dEX;
    }

    public int getINT() {
	return INT;
    }

    public void setINT(int iNT) {
	INT = iNT;
    }
    
    
}
