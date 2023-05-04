
public class Thanos extends Character{

	String name = "Thanos";
	String desc = "Thicc Purple Man";
	String quest = "Take the party to fight raw power";
	String preBattle = "Hopefully your party is strong in strategies to combat the brute strength of this man."
			+ "\nHe's destroyed half the universe, and he'll destroy you, too if you're not prepared.";
	String move1 = "null";
	String move2 = "null";
	String move1Desc = "null";
	String move2Desc = "null";
	int hp = 200;
	int maxhp = 200;
	
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
		int move = (int) (Math.random()*3);
		if (move <= 1)
		{
			if (!player.getQuest().equals("no snap"))
			{
				System.out.println(player.getName() + " snaps their fingers and " + enemy.getName() + "'s hp has been halved!");
				enemy.loseHP(enemy.getHP()/2);
			}
			else
			{
				System.out.println(player.getName() + " tries to snap, but cannot due to hand injury!");
			}
		}
		else
		{
			System.out.println(player.getName() + " temporarily becomes " + enemy.getName() + "!");
			Game.sleep(1000);
			int chance = (int) (Math.random()*2);
			if (chance == 0)
			{
				enemy.move1Exec(player, enemy);
			}
			else enemy.move2Exec(player, enemy);
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int move = (int) (Math.random()*3);
		if (move <= 1)
		{
			System.out.println(player.getName() + " hits " + enemy.getName() + " with the THANOS CAR for 30 dmg!");
			enemy.loseHP(30);
		}
		else
		{
			enemy.loseHP((enemy.getHP()-enemy.getMaxHP()));
			enemy.loseHP((int) (Math.random()*(enemy.getMaxHP()+1)));
			System.out.println(player.getName() + " reconstructs " + enemy.getName() + "'s bodily particles! They now have " + enemy.getHP() + " hp.");
		}
	}
}
