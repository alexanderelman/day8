package edu.acc.java3.elfunc;

public class DieBean implements java.io.Serializable {
	public int roll(int size) {
		return 1 + (int)(Math.random() * size);
	}
}