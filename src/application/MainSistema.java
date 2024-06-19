package application;

import presidiario.*;
import presidio.*;
import java.util.Scanner;
import java.util.Random;

public class MainSistema {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	public static void main(String[] args) {
		boolean run = true;
		ArvorePS arvPS = new ArvorePS();
		ArvorePR arvPR = new ArvorePR();
		
		do {
			run = Menu();
		} while (run);
	}
	
	public static Menu() {
		
	}
	
	public static int codPS() {
		return ran.nextInt(500001);
	}
	public static int codPR() {
		return ran.nextInt(101);
	}
}