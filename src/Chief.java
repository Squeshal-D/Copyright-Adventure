
public class Chief extends Character{
	
	String name = "Master Chief";
	String desc = "AKA Halo";
	String quest = "Hijack a space vessel";
	String preBattle = "Hijacking a space vessel would surely cause the government to send special forces to stop you, and they do!"
			+ "\nAs soon as the armored warrior approaches you, he informs you that what you are doing is 'illegal' and that he needs a weapon.";
	String move1 = "Assault Rifle";
	String move2 = "Spartan Laser";
	String move1Desc = "Low dmg, inaccurate, but iconic! Each of the 32 bullets have a 50% chance of hitting.";
	String move2Desc = "Very bad-A w*rd. Takes a turn to charge, but does 40 dmg.";
	int hp = 100;
	int maxhp = 100;
	
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
		boolean tm = false;
		for (int i = 0; i<Game.party.size(); i++)
		{
			if (Game.party.get(i).getQuest().equals("Hijack a space vessel"))
			{
				tm = true;
			}
		}
		if (!tm)
		{
			move2Desc = "Very bad-A w*rd. Takes a turn to charge, but does 40 dmg.";
		}
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
		int dmg = 0;
		for (int i = 0; i<32; i++)
		{
			dmg += (int) (Math.random()*2);
		}
		System.out.println(player.getName() + " unloads their assault rifle on " + enemy.getName() + " and hits " + dmg + " shots!");
		enemy.loseHP(dmg);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		if (player.getMove2Desc().equals("Very bad-A w*rd. Takes a turn to charge, but does 40 dmg."))
		{
			System.out.println(player.getName() + " charges the spartan laser!");
			player.changeMove2Desc("ccc");
		}
		else
		{
			System.out.println(player.getName() + " fires the spartan laser at " + enemy.getName() + " for 40 dmg!");
			enemy.loseHP(40);
			if (player.getMove2Desc().equals("ccc"));
			{
				player.changeMove2Desc("Very bad-A w*rd. Takes a turn to charge, but does 40 dmg.");
			}
		}
	}
}
