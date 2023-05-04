
public class Wick extends Character{
	
	String name = "John Wick";
	String desc = "From Epic Games' Smash Hit 'Fortnite'";
	String quest = "Hire an assassin to fight you";
	String preBattle = "You pick up the phone and dial 1-800-KILL. \"Give me one of your finest hitmen. What? Who should their target be? Me.\""
			+ "\nWithing seconds, an assassin does a cool combat roll toward you. \"I've come for everything they said I couldn't have, even you.\"";
	String move1 = "Pencil Shank";
	String move2 = "Neck Snap";
	String move1Desc = "Stabbing spree! Keeps attacking (5 dmg) until John Wick misses. (30% chance)";
	String move2Desc = "Anticlimactic Finisher. Could instantly kill an enemy, chance increases as enemy's HP gets low.";
	int hp = 60;
	int maxhp = 60;
	
	public String getName()
	{
		return name;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getQuest()
	{
		return quest;
	}
	
	public String getPreBattle()
	{
		return preBattle;
	}
	
	public String getMove1()
	{
		return move1;
	}
	
	public String getMove2()
	{
		return move2;
	}
	
	public String getMove1Desc()
	{
		return move1Desc;
	}
	
	public String getMove2Desc()
	{
		return move2Desc;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public int getMaxHP()
	{
		return maxhp;
	}
	
	public void loseHP(int i)
	{
		hp -= i;
	}
	
	public void healMax()
	{
		hp = maxhp;
	}
	
	public void changeQuest(String s)
	{
		quest = s;
	}
	
	public void move1Exec(Character player, Character enemy)
	{
		int dmg = 0;
		System.out.println(player.getName() + " brandishes a pencil!");
		Game.sleep(1000);
		for (int i = 3; i >= 3;)
		{
			i = (int) (Math.random()*10);
			if (i < 3)
			{
				System.out.println("miss");
				Game.sleep(500);
			}
			else
			{
				System.out.println("stab");
				dmg +=5;
				Game.sleep(500);
			}
		}
		System.out.println(enemy.getName() + " gets shanked for " + dmg + " dmg!");
		enemy.loseHP(dmg);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int c = (int) (Math.random()*(enemy.getHP()/10));
		int d = (int) (Math.random()*(enemy.getHP()/10));
		if (c == d)
		{
			System.out.println(player.getName() + " snaps " + enemy.getName() + "'s neck!");
			enemy.loseHP(enemy.getHP());
		}
		else
		{
			System.out.println(player.getName() + " only manages to turn " + enemy.getName() + "'s head.");
		}
	}
}
