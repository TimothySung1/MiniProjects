package pe3;

import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
	
	public static double round(double num) {
		return Math.round(num * 100) / 100.0;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		String rivalPokemon;
		String yourPokemon;
		double hp = round(random.nextInt(20) + 40);
		
		System.out.print("Enter your Pokemon's nickname: ");
		yourPokemon = scanner.next().trim();
		System.out.print("Enter your rival Pokemon's nickname: ");
		rivalPokemon = scanner.next().trim();
		
		System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n",
				rivalPokemon, hp);
		
		int turns = 0;
		
		do {
			AttackType attack = AttackType.values()[random.nextInt(3)];
			double totalDmg = 0;
			switch (attack) {
			case SCRATCH:
				int scratches = random.nextInt(3) + 1;
				double dmg = round(random.nextDouble() * 5 + 1);
				totalDmg = scratches * dmg;
			case SURF:
				totalDmg = round(random.nextDouble() * 9 + 2);
			case TACKLE:
				totalDmg = round(random.nextDouble() * 2 + 7);
			}
			hp -= totalDmg;
			hp = Math.max(0, hp);
			System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.\n"
					, yourPokemon, attack, totalDmg, hp);
			turns++;
		} while (hp > 0);
		System.out.printf("%s fainted after %d turns!\n", rivalPokemon, turns);
		double prize = round(random.nextDouble() * 1200 + 1200);
		System.out.printf("You have earned $%.2f!", prize);
	}
}
