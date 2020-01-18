import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CaveExplore {

	/**
	 * Player: Health Name Attack damage
	 * 
	 * Enemies: Array of string that holds multiple enemies Max health = 75 Max
	 * damage
	 * 
	 * Game: Potions for player Weapons for player? Monster can drop a potion
	 */
	// System.out.println(rand.nextInt(8) + 1); Prints a number from 1 - 8 both
	// inclusive
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		// Weapons
		int weaponDamage = 25;
		int weaponLoopy = 0;

		// Player attributes
		int playerHealth = 100;
		int maxPlayerDamage = 50;
		int damage = 0;
		int potion = 20;
		int numPotions = 3;

		// Enemies
		ArrayList<String> enemies = new ArrayList<String>();
		enemies.add("Reaper");
		enemies.add("Skeleton");
		enemies.add("Ninja");
		enemies.add("Mr.Hit");

		// Enemy health attributes
		int maxEnemyHealth = 75;
		int maxEnemyDamage = 25;

		System.out.println("* Welcome to Cave Explorers! *");
		System.out.println("> Enter a name for your character");
		// Users name
		String player = scan.next();
		System.out.println("* Welcome " + player + "! *");

		// Game runs while there is an enemy to fight
		GAME: while (enemies.size() > 0) {

			// Randomizes the health of an enemy, based on the maxEnemyHealth(75)
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			// Obtaining an random enemy from the ArrayList
			String enemy = enemies.get(rand.nextInt(enemies.size()));
			// Remove the random enemy from the ArrayList
			enemies.remove(enemy);

			System.out.println("--------------------------------------------------");
			System.out.println("> * A wild " + enemy + " has appeared *");
			System.out.println("--------------------------------------------------");

			System.out.println("\t> " + enemy + " has " + enemyHealth + " health");
			System.out.println("\t> " + player + " has " + playerHealth + " health");

			// Game runs while the enemy we're fighting has health
			while (enemyHealth > 0) {

				// Player damage
				damage = rand.nextInt(maxPlayerDamage);
				System.out.println("> " + player + " has a damage of " + damage);
				// Enemy damage
				int enemyDamage = rand.nextInt(maxEnemyDamage);

				System.out.println("* Chose an option below *");
				System.out.println("1) Attack Enemy (Enemy can attack back)");
				System.out.println("2) Drink A Potion");
				System.out.println("3) Choose A Weapon + Attack");
				System.out.println("--------------------------------------------------");

				if (playerHealth < 1) {
					System.out.println("\t> You are too weak to continue, your time to go has come =(");
					break;
				}

				int choice = scan.nextInt();
				if (choice == 1) {
					playerHealth -= enemyDamage;
					enemyHealth -= damage;
					System.out.println(player + "'s damage done " + damage);
					System.out.println(enemy + "'s damage done " + enemyDamage);
					System.out.println("\t> " + player + "'s health " + playerHealth);
					System.out.println("\t> " + enemy + "'s health " + enemyHealth);

				} else if (choice == 2) {
					playerHealth += potion;
					System.out.println("You have drank a potion");
					System.out.println("Your health is now " + playerHealth);
					--numPotions;
					System.out.println("You have " + numPotions + " potions remaining");

				} else if (choice == 3) {
					if (weaponLoopy < 3) {
						System.out.println("Weapon loopy " + weaponLoopy);
						damage += weaponDamage;
						System.out.println("Player damage done " + damage);
						enemyHealth -= damage;

						System.out.println("\t> " + player + "'s health " + playerHealth);
						System.out.println("\t> " + enemy + "'s health " + enemyHealth);

					} else {
						System.out.println("You have no weapons left");

					}

					++weaponLoopy;

				} else {
					System.out.println("* Please enter a valid choice. *");
					choice = scan.nextInt();
				}

			} // End of second while loop

		} // End of main while loop

		if (playerHealth < 1) {
			System.out.println("\t>You have died in battle ");
		} else {
			System.out.println("You have defeated every enemy! Congrats Champ");
		}
		System.out.println("--------------------------------------------------");
		System.out.println("* Thank you very much for playing Cave Explorers! *");
	}

}
