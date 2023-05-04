import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Game {
	
	static Scanner userIn = new Scanner(System.in);
	//Loading game characters. Starting position in pool written to right.
	Blart blart = new Blart(); //0
	Shrek shrek = new Shrek(); //1
	Bowers bowers = new Bowers(); //2
	public static boolean bStatus = true;
	Lennie lennie = new Lennie(); //3
	Washington washington = new Washington(); //4
	Wick wick = new Wick(); //5
	Chief chief = new Chief(); //6
	Derrek derrek = new Derrek(); //7
	Ramsay ramsay = new Ramsay(); //8
	
	Thanos thanos = new Thanos(); //1m
	Sans sans = new Sans(); //2m
	int sansHP = 8; //amount of hits it takes to kill sans
	Herobrine herobrine = new Herobrine(); //3m
	
	HitSat hitsat = new HitSat();
	
	//Declares list of potential random encounters.
	ArrayList<Character> pool = new ArrayList<Character>();
	//Characters that are chosen to appear in the next encounter.
	ArrayList<Character> options = new ArrayList<Character>();
	//Mini bosses.
	ArrayList<Character> miniBoss = new ArrayList<Character>();
	
	
	Character user = new Character();
	public static ArrayList<Character> party = new ArrayList<Character>();
	
	public static int intCheck(Scanner i) //checks an input to see if it's an integer
	{
		try
		{
			return i.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input. Try again.");
			i.next();
			return intCheck(i);
		}
	}
	
	public void createOptions() //creates the choices the player encounters when choosing where to go
	{
		for (int i = 0; i<options.size(); i++) //puts unchosen options back into the pool
		{
			pool.add(options.get(i));
		}
		options.clear();
		for (int i = 0; i<3 && i<pool.size() + options.size(); i++) //puts random characters from the pool into the options
		{
			int n = (int) (Math.random()*pool.size());
			options.add(pool.get(n));
			pool.remove(n);
		}
	}
	
	public void start()
	{
		System.out.println("\n\n\n\n\nWelcome to an adventure that I will never be able to legally release."
				+ "\nGive me your name.");
		
		String username = userIn.nextLine();
		
		System.out.println("What a dumb name. Give me a description about yourself."
				+ "\nex: student, nice guy, dog lover, etc");
		
		String userdesc = userIn.nextLine();
		
		user.create(username, userdesc, "null", "Punch", "How normal. Does 15 - 25 dmg.", "Juul", 
				"A sophomore classic. 50/50 chance of a Bowers attack. (30 dmg)", 50);
		
		party.add(user);
		//for bug testing only
		/*
		party.add(blart);
		party.add(shrek);
		party.add(bowers);
		party.add(lennie);
		party.add(washington);
		party.add(wick);
		party.add(chief);
		party.add(derrek);
		party.add(ramsay);
		*/
		//
		///*
		pool.add(blart);
		pool.add(shrek);
		pool.add(bowers);
		pool.add(lennie);
		pool.add(washington);
		pool.add(wick);
		pool.add(chief);
		pool.add(derrek);
		pool.add(ramsay);
		miniBoss.add(thanos);
		miniBoss.add(sans);
		miniBoss.add(herobrine);
		//*/
		
		System.out.println("Prepare to embark on your epicc quest...\n");
		Game.sleep(1000);
	}
	
	public void firstZ()
	{
		//Scanner userIn = new Scanner(System.in);
		System.out.println("There comes a time in every man's life when they must embark on an epic quest to defeat numerous people."
				+ "\nToday, " + user.getName() + " begins their quest. The " + user.getDesc() 
				+ " walks outside their house. They consider their options.\n");
		
		createOptions();
		//battle(user, hitsat); //for testing characters
		
		for (int i=0; i<options.size(); i++)
		{
			System.out.println((i+1) + ". " + options.get(i).getQuest());
		}
		
		int c = 0;
		
		while (c <= 0 || c > options.size())
			{
				c = (intCheck(userIn));
				if (c<=0 || c>options.size())
				{
					System.out.println("Invalid input. Try again.");
				}
			}
				
		System.out.println("\n" + options.get(c-1).getPreBattle()
				+ "\nInput anything to continue.");
		
		userIn.next();
		
		System.out.println("\nWho will fight?"); //lets you change party member before the fight.
		for (int i = 0; i<party.size(); i++)
		{
			System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
					+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
		}
		
		int p = 0;
		
		while (p < 1 || p > party.size())
		{
			p = (intCheck(userIn));
			if (p < 1 || p > party.size())
			{
				System.out.println("Invalid input. Try again.");
			}
		}
		
		battle(party.get(p-1), options.get(c-1));
		
	}
	
	public void middleZ()
	{
		
		createOptions();
		
		if (options.size() == 0) //all characters are beat. move to mini bosses.
		{
			if (miniBoss.size() == 3)
			{
				System.out.println("\nAll beings worthy of a fight on earth have been defeated and recruited to support your cause.");
				sleep(5000);
				System.out.println("You are not satisfied, though. You know what you must do. You must fight... him...");
				sleep(5000);
				System.out.println("You and your warriors rest to prepare for the final battle. Everyone is fully healed.");
				for (int i = 0; i < party.size(); i++)
				{
					party.get(i).healMax();
				}
				sleep(5000);
				System.out.println("You've ascended to the grand entrance of his dwelling place. Three powerful guards protect the entrance.\n");
				sleep(3000);
			}
			else if (miniBoss.size() == 0) //all minibosses are beat. move to final boss.
			{
				finalZ();
			}
			miniZ();
		}
		
		System.out.println("\nWhat an exhilarating battle! You're not done yet, though. There are still opponents to be conquered."
				+ "\nWhere will you go next?");
		
		for (int i=0; i<options.size(); i++)
		{
			System.out.println((i+1) + ". " + options.get(i).getQuest());
		}
		
		int c = 0;
		
		while (c <= 0 || c > options.size())
			{
				c = (intCheck(userIn));
				if (c<=0 || c>options.size())
				{
					System.out.println("Invalid input. Try again.");
				}
			}
				
		System.out.println("\n" + options.get(c-1).getPreBattle()
				+ "\nInput anything to continue.");
		
		userIn.next();
		
		System.out.println("\nWho will fight?"); //lets you change party member before the fight.
		for (int i = 0; i<party.size(); i++)
		{
			System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
					+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
		}
		
		int p = 0;
		
		while (p < 1 || p > party.size())
		{
			p = (intCheck(userIn));
			if (p < 1 || p > party.size())
			{
				System.out.println("Invalid input. Try again.");
			}
		}
		
		battle(party.get(p-1), options.get(c-1));
		
	}
	
	public void miniZ()
	{
		sleep(2000);
		System.out.println("\nWhom will you take your party to fight?");
		for (int i = 0; i<miniBoss.size(); i++)
		{
			System.out.println((i+1) + ". " + miniBoss.get(i).getQuest());
		}
		int c = 0;
			
		while (c <= 0 || c > miniBoss.size())
			{
				c = (intCheck(userIn));
				if (c<=0 || c>miniBoss.size())
				{
					System.out.println("Invalid input. Try again.");
				}
			}
		////
		System.out.println("\n" + miniBoss.get(c-1).getPreBattle()
				+ "\nInput anything to continue.");
		
		userIn.next();
		
		System.out.println("\nWho will fight?"); //lets you change party member before the fight.
		for (int i = 0; i<party.size(); i++)
		{
			System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
					+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
		}
		
		int p = 0;
		
		while (p < 1 || p > party.size())
		{
			p = (intCheck(userIn));
			if (p < 1 || p > party.size())
			{
				System.out.println("Invalid input. Try again.");
			}
		}
		
		battle(party.get(p-1), miniBoss.get(c-1));
	}
	
	public void finalZ()
	{
		if (hitsat.getHP() <= 0)
		{
			System.out.println("You won good job.");
			System.exit(0);
		}
		sleep(2000);
		System.out.println("\nThe three guards have been defeated. The gate is wide open. Your party heals with their new confidence.");
		for (int i = 0; i < party.size(); i++)
		{
			party.get(i).healMax();
		}
		sleep(5000);
		System.out.println("The grand scale of the palace is realized when the party walks in.");
		sleep(5000);
		System.out.println("At the end of the giant room is a throne of fire. Your opponent watches the party walk in from the throne.");
		sleep(5000);
		System.out.println("\"So, you've come to defeat me? Mwahaha, the day I am defeated is the day I post cringe!\"");
		sleep(5000);
		System.out.println("\"But enough trashtalk... Show me what you've got!\"\nInput anything to continue.");
		userIn.next();
		
		System.out.println("\nWho will fight?"); //lets you change party member before the fight.
		for (int i = 0; i<party.size(); i++)
		{
			System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
					+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
		}
		
		int p = 0;
		
		while (p < 1 || p > party.size())
		{
			p = (intCheck(userIn));
			if (p < 1 || p > party.size())
			{
				System.out.println("Invalid input. Try again.");
			}
		}
		
		battle(party.get(p-1), hitsat);
	}
	
	public void battle(Character player, Character enemy) //everything that will occur in a battle / start of a new turn cycle
	{
		int action = battleChoice(player, enemy);
		if (action == 1) //player chooses fight
		{
			fight(player, enemy);
			if (enemy.getHP() <= 0) //enemy is dead
			{
				System.out.println("\n" + enemy.getName() + " has been defeated!");
				Game.sleep(1000);
				if (player.getQuest().equals("Hijack a space vessel"))
				{
					player.changeMove2Desc("Very bad-A w*rd. Takes a turn to charge, but does 40 dmg.");
				}
				for (int i = 0; i < options.size(); i++)
				{
					if (enemy == options.get(i))
					{
						System.out.println(enemy.getName() + " has joined your party!");
						enemy.healMax();
						options.remove(enemy);
						party.add(enemy);
						Game.sleep(1000);
					}
				}
				miniBoss.remove(enemy);
				
				if (player.getHP() <= 0) // player is ALSO dead
				{
					System.out.print(player.getName() + " died though lol.");
					party.remove(player);
					Game.sleep(1000);
				}
				//System.out.print(enemy.getHP());
				middleZ();
			}
			else if (player.getHP() <= 0) //player kills himself
			{
				System.out.println(player.getName() + " dies before " + enemy.getName() + " can attack.");
				party.remove(player);
				if (party.size() > 0) //at least one person is left
				{
					int c = 0;
					Game.sleep(1000);
					System.out.println("\nWho will continue the fight? " + enemy.getName() + " (" + enemy.getHP() + "/" + enemy.getMaxHP() + ")"
							+ " - " + enemy.getDesc());
					for (int i = 0; i<party.size(); i++)
					{
						System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
								+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
					}
					while (c<1 || c>party.size()) //checks input
					{
						c = intCheck(userIn);
						if (c<1 || c>party.size())
						{
							System.out.println("Invalid input. Try again.");
						}
					}
					battle(party.get(c-1), enemy); //continues battle with new member
				}
				else
				{
					Game.sleep(1000);
					System.out.println("You are out of warriors. Your quest if over.");
					Game.sleep(1000);
					System.out.println("\nGAME OVER");
					System.exit(0);
				}
				
			}
			else //enemy attacks
			{
				int enemyAttack = (int) (Math.random()*2);
				if (enemyAttack == 0)
				{
					enemy.move1Exec(enemy, player);
				}
				else enemy.move2Exec(enemy, player);
			}
			sleep(1000);
			if (player.getHP() <=0) //player is dead
			{
				System.out.println("\nOh no! " + player.getName() + " has passed away...");
				party.remove(player);
				if (enemy.getHP() <= 0)
				{
					Game.sleep(1000);
					System.out.println("HOWEVER...");
					Game.sleep(500);
					for (int i = 0; i < options.size(); i++)
					{
						if (enemy == options.get(i))
						{
							System.out.println(enemy.getName() + " was defeated and joins the party!");
							enemy.healMax();
							options.remove(enemy);
							party.add(enemy);
							Game.sleep(1000);
							middleZ();
						}
					}
					System.out.println(enemy.getName() + " was defeated!");
					miniBoss.remove(enemy);
					Game.sleep(1000);
					middleZ();
				}
				else if (party.size() > 0) //at least one person is left
				{
					int c = 0;
					Game.sleep(1000);
					System.out.println("\nWho will continue the fight? " + enemy.getName() + " (" + enemy.getHP() + "/" + enemy.getMaxHP() + ")"
							+ " - " + enemy.getDesc());
					for (int i = 0; i<party.size(); i++)
					{
						System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
								+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
					}
					while (c<1 || c>party.size()) //checks input
					{
						c = intCheck(userIn);
						if (c<1 || c>party.size())
						{
							System.out.println("Invalid input. Try again.");
						}
					}
					battle(party.get(c-1), enemy); //continues battle with new member
				}
				else //game over
				{
					System.out.println("You are out of warriors. Your quest if over.");
					Game.sleep(1000);
					System.out.println("\nGAME OVER");
					System.exit(0);
				}
			}
			else if (enemy.getHP() <= 0)
			{
				if (player.getQuest().equals("Hijack a space vessel"))
				{
					player.changeMove2Desc("Very bad-A w*rd. Takes a turn to charge, but does 40 dmg.");
				}
				System.out.println("\n" + enemy.getName() + " defeated himself!");
				Game.sleep(1000);
				for (int i = 0; i < options.size(); i++)
				{
					if (enemy == options.get(i))
					{
						System.out.println(enemy.getName() + " has joined your party!");
						enemy.healMax();
						Game.sleep(1000);
						options.remove(enemy);
						party.add(enemy);
						middleZ();
					}
				}
				miniBoss.remove(enemy);
				middleZ();
			}
			battle(player, enemy);
		}
		else
		{
			System.out.println("Who will fight? " + enemy.getName() + " (" + enemy.getHP() + "/" + enemy.getMaxHP() + ")"
					+ " - " + enemy.getDesc());
			for (int i = 0; i<party.size(); i++)
			{
				System.out.println(i+1 + ". " + party.get(i).getName() + " (" + party.get(i).getHP() 
						+ "/" + party.get(i).getMaxHP() + ") - " + party.get(i).getDesc());
			}
			System.out.println(party.size() + 1 + ". Go back");
			
			int p = 0;
			
			while (p < 1 || p > party.size() + 1)
			{
				p = (intCheck(userIn));
				if (p < 1 || p > party.size() + 1)
				{
					System.out.println("Invalid input. Try again.");
				}
			}
			
			if (p == party.size() + 1)
			{
				battle(player, enemy);
			}
			
			else
			{
				if (player == party.get(p-1))
				{
					battle(player, enemy);
				}
				else
				{
					System.out.println(party.get(p-1).getName() + " enters the battle!");
					sleep(1000);
					player = party.get(p-1);
					int enemyAttack = (int) (Math.random()*2);
					if (enemyAttack == 0)
					{
						enemy.move1Exec(enemy, player);
					}
					else enemy.move2Exec(enemy, player);
					Game.sleep(1000);
					battle(player, enemy);
				}
			}
		}
		
	}

	public int battleChoice(Character player, Character enemy) //player chooses whether to fight or exchange member
	{
			int c = 0;
			
			display(player, enemy);
			
			if (player.getMove2Desc().equals("ccc"))
			{
				return 1;
			}
			
			else
			{
				System.out.println("\n1. FIGHT!"
								+ "\n2. Party");
			
					while (c<1 || c>2)
					{
						c = intCheck(userIn);
						if (c<1 || c>2)
						{
							System.out.println("Invalid input. Try again.");
						}
					}
				return c;
			}
	}
	
	public void fight(Character player, Character enemy) //player attacks the enemy
	{
		int a = 0;
		
		if (player.getMove2Desc().equals("ccc"))
		{
			sleep(2000);
			a = 2;
		}
		else
		{
			System.out.println("\nSelect a move."
					+ "\n1. " + player.getMove1() + " - " + player.getMove1Desc()
					+ "\n2. " + player.getMove2() + " - " + player.getMove2Desc()
					+ "\n3. Go back");
			
			while (a<1 || a>3) //checks input
			{
				a = intCheck(userIn);
				if (a<1 || a>3)
				{
					System.out.println("Invalid input. Try again.");
				}
			}
		}
		System.out.println();
		if (a == 1) //player uses move 1
		{
			if (enemy.getPreBattle().equals("You are about to have a bad time.") && sansHP > 0)
			{
				sansFight(enemy);
			}
			else
			{
				player.move1Exec(player, enemy);
				sleep(1000);
			}
		}
		
		else if (a == 2) //player uses move 2
		{
			if (enemy.getPreBattle().equals("You are about to have a bad time.") && sansHP > 0 && !player.getQuest().equals("Enter the kitchen"))
			{
				sansFight(enemy);
			}
			else
			{
				player.move2Exec(player, enemy);
				sleep(1000);
			}
		}
		
		else battle(player, enemy); //player chooses to go back
	}
	
	public void display(Character player, Character enemy) //text based visualization of the battlefield
	{
		System.out.println("\n" + enemy.getName() + " (" + enemy.getHP() + "/" + enemy.getMaxHP() + ")"
				+ "\n\n\n"
				+ player.getName() + " (" + player.getHP() + "/" + player.getMaxHP() + ")");
	}
	
	public static void sleep (int t)
	{
		try 
		{
			Thread.sleep(t);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void sansFight(Character s)
	{
		System.out.println(s.getName() + " dodges the attack!");
		sleep(1000);
		if (sansHP >= 7)
		{
			System.out.println(s.getName() + " is going strong!");
			sleep(1000);
			sansHP--;
		}
		else if (sansHP == 6)
		{
			System.out.println(s.getName() + " is no longer smiling.");
			sleep(1000);
			sansHP--;
		}
		else if (sansHP == 5)
		{
			System.out.println(s.getName() + "'s expression grows worrisome.");
			sleep(1000);
			sansHP--;
		}
		else if (sansHP == 4)
		{
			System.out.println(s.getName() + " is visibly sweating.");
			sleep(1000);
			sansHP--;
		}
		else if (sansHP >=2)
		{
			System.out.println(s.getName() + " can't do this much longer.");
			sleep(1000);
			sansHP--;
		}
		else if (sansHP == 1)
		{
			System.out.println(s.getName() + " stops to catch his breath.");
			sleep(1000);
			sansHP--;
		}
	}
}








