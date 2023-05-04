
public class Blart extends Character{

	String name = "Paul Blart";
	String desc = "Mall Cop";
	String quest = "Take a trip to the mall";
	String preBattle = "Many of the people in the mall don't seem to be positively responding to you trying to pick a fight."
			+ "\nIt's no wonder you've been reported. Then you see him. \"I swore an oath to protect this mall.\"";
	String move1 = "Segway Slam";
	String move2 = "Headbutt";
	String move1Desc = "An allout rollout. 50/50 to hit (40 dmg), 50/50 to recoil (20 dmg).";
	String move2Desc = "\"Nobody wins with a headbutt.\" Deals 25 dmg to the enemy and inflicts 15 self dmg.";
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
		int chance = (int) (Math.random()*4);
		if (chance == 0)
		{
			System.out.println(player.getName() + " slams their Segway into " + enemy.getName() + " successfully for 40 dmg...");
			Game.sleep(1500);
			System.out.println("and stays on!");
			enemy.loseHP(40);
		}
		else if (chance == 1)
		{
			System.out.println(player.getName() + " slams their Segway into " + enemy.getName() + " successfully for 40 dmg...");
			Game.sleep(1500);
			System.out.println("but falls off for 20 dmg!");
			enemy.loseHP(40);
			player.loseHP(20);
		}
		else if (chance == 2)
		{
			System.out.println(player.getName() + " flies past " + enemy.getName() + " on their Segway...");
			Game.sleep(1500);
			System.out.println("but stays on!");
		}
		else
		{
			System.out.println(player.getName() + " flies past " + enemy.getName() + " on their Segway...");
			Game.sleep(1500);
			System.out.println("and falls off for 20 dmg!");
			player.loseHP(20);
		}
		
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		System.out.println(player.getName() + " headbutts " + enemy.getName() + " for 25 dmg, but recieves 15 dmg in recoil!");
		enemy.loseHP(25);
		player.loseHP(15);
	}
	
	
	
	
}
