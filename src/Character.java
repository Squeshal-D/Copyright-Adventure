
public class Character {

	String name;
	String desc;
	String quest;
	String preBattle;
	String move1;
	String move2;
	String move1Desc;
	String move2Desc;
	int hp;
	int maxhp;
	
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
	
	public void changeMove2Desc(String s)
	{
		move2Desc = s;
	}
	
	public void move1Exec(Character player, Character enemy)
	{
		int dmg = 15 + (int) (Math.random()*11);
		System.out.println(player.getName() + " punches " + enemy.getName() + " for " + dmg + " dmg!");
		enemy.loseHP(dmg);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int chance = (int) (Math.random()*2);
		
		for (int i = 0; i<Game.party.size(); i++)
		{
			if (Game.party.get(i).getQuest().equals("Visit CVCHS"))
			{
				chance = 2;
			}
		}
		if (enemy.getQuest().equals("Visit CVCHS"))
		{
			chance = 3;
		}
		if (!Game.bStatus)
		{
			System.out.println(player.getName() + " vapes knowing that there's no chance of being disturbed.");
		}
		else if (chance == 3)
		{
			System.out.println("What have you done.");
			Game.sleep(1500);
			System.out.println(player.getName() + " gets sent to the shadow realm by " + enemy.getName() + " for 9999 dmg!?");
			player.loseHP(9999);
			Game.sleep(2000);
			System.out.println("Remember kids, Mr. Bowers says that vaping is bad for you and can cause lung damage or something.");
			Game.sleep(3000);
			System.out.println("Now back to Justin's senior project.");
		}
		else if (chance == 2)
		{
			System.out.println("Bowers sees the pen and becomes enraged! He disciplines " + enemy.getName() + " for 30 dmg!");
			enemy.loseHP(30);
		}
		else if (chance == 1)
		{
			System.out.println("Bowers senses the vape and springs out of nowhere! He annihilates " + enemy.getName() + " for 30 dmg!");
			enemy.loseHP(30);
		}
		else 
		{
			System.out.println(player.getName() + " vapes undisturbed. " + enemy.getName() + " is jealous.");
		}
	}
	
	
	
	
	
	
	public void create(String n, String d, String q, String m1, String m1d, String m2, String m2d, int h)
	{
		name = n;
		desc = d;
		quest = q;
		move1 = m1;
		move1Desc = m1d;
		move2 = m2;
		move2Desc = m2d;
		maxhp = h;
		hp = h;
	}
	
	
	
	
	
	
	
	
	
}
