package object;

import java.io.*;
import java.util.*;

import main.OurGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Stats {
    private int maxHealth, maxEnergy, ATK, DEX, INT, exp;
    private Scanner scan;
    private FileHandle data;

    public Stats() {

    }

    public Stats(String str) {
	loadStats(str);
    }

    public Stats(int mH, int mE, int a, int d, int i) {
	setMaxHealth(mH);
	setMaxEnergy(mE);
	setATK(a);
	setDEX(d);
	setINT(i);
    }

    public void loadStats(String name) {
	data = Gdx.files.internal("resource/data/PlayerStats.txt");
	String text = data.readString();
	String[] text2 = text.split("\n");
	for (int x = 0; x < text2.length; x++) {
	    text2[x] = text2[x].substring(0, text2[x].length() - 1);
	}
	setMaxHealth(Integer.parseInt(text2[1]));
	setMaxEnergy(Integer.parseInt(text2[2]));
	setATK(Integer.parseInt(text2[3]));
	setINT(Integer.parseInt(text2[4]));
	setDEX(Integer.parseInt(text2[5]));
	setExp(Integer.parseInt(text2[6]));


    }

    public void saveGame(String name) {
	data = Gdx.files.internal("resource/data/PlayerStats.txt");
	String newStats = name + "\n" + getMaxHealth() + "\n" + getMaxEnergy()
		+ "\n" + getATK() + "\n" + getINT() + "\n" + getDEX() + "\n"
		+ getExp();
	data.writeString(newStats, false);
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

    public int getExp() {
	return exp;
    }

    public void setExp(int exp) {
	this.exp = exp;
    }

}
