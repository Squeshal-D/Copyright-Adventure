
public class Derrek extends Character{
	
	String name = "Derrek";
	String desc = "Sharks Fan";
	String quest = "Go to Derrek's house";
	String preBattle = "You go up to Derrek's house and knock on the door. Derrek's mom answers the door. She is very nice, and you ask her if Derrek is home."
			+ "\nShe invites you in and gives you some hot cocoa. You are rudely interrupted by Derrek, though. You put down the cocoa and tell Derrek's mom, "
			+ "\n\"Sorry, but I'm going to have to kick your son's bootay.\"";
	String move1 = "Baseball Smash";
	String move2 = "Airplane Smash";
	String move1Desc = "A joke Derrek and I have. Does 15 damage and finishes an enemy that's 30 hp or lower.";
	String move2Desc = "Watch yo jet! Deals 25 damage, but there's a 20% chance Derrek crashes the plane...";
	int hp = 50;
	int maxhp = 50;
	
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
		if (enemy.getHP() > 30)
		{
			System.out.println(player.getName() + " swings the bat at " + enemy.getName() + " for 15 dmg!");
			enemy.loseHP(15);
		}
		else
		{
			System.out.println(player.getName() + " swings the bat at " + enemy.getName() + " and takes off their head! Eww...");
			enemy.loseHP(enemy.getHP());
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int c = (int) (Math.random()*5);
		System.out.println(player.getName() + " clips " + enemy.getName() + " with a freaking airplane for 25 dmg!");
		enemy.loseHP(25);
		Game.sleep(1000);
		if (c == 4)
		{
			System.out.println(player.getName() + " crashes the plane in a blaze of glory!");
			player.loseHP(player.getHP());
		}
		else
		{
			System.out.println(player.getName() + " lands the plane safely!");
		}
	}
}
