

public class Shrek extends Character {

	String name = "Shrek";
	String desc = "Dreamwork's All Star";
	String quest = "Go hunt in the swamp";
	String preBattle = "Swamps are dangerous places. What makes this swamp even more dangerous, though, is that it is HIS swamp."
			+ "\n\"Oh hello there! Shrek here, and I'm ticked off!\"";
	String move1 = "Shrek Superslam";
	String move2 = "Onion Onslaught";
	String move1Desc = "Wombo Combo. Base 5 dmg, adds an extra 5 dmg per party member.";
	String move2Desc = "O n i o n. Throw 5 onions dealing 6 dmg each with 50% accuracy.";
	int hp = 80;
	int maxhp = 80;
	
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
		int allies = 0;
		int dmg = 0;
		boolean opponent = true;
		for (int i = 0; i<Game.party.size(); i++)
		{
			if (Game.party.get(i).getQuest().equals("Go hunt in the swamp") && player.getQuest().equals("Go hunt in the swamp"))
			{
				opponent = false;
			}
		}
		if (opponent)
		{
			allies = (int) (Math.random()*5);
			dmg = 5 + (allies*5);
			System.out.println(player.getName() + " calls " + allies + " allies and executes a Wombo Combo for " + dmg + " dmg!");
			enemy.loseHP(dmg);
		}
		else
		{
			dmg = 5 * Game.party.size();
			System.out.println(player.getName() + " calls " + (Game.party.size()-1) + " allies and executes a Wombo Combo on " + enemy.getName()
			+ " for " + dmg + " dmg!");
			enemy.loseHP(dmg);
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int c = 0;
		int h = 0;
		System.out.println(player.getName() + " unloads a barrage of onions!");
		Game.sleep(1000);
		for (int i = 0; i<5; i++)
		{
			c = (int) (Math.random()*2); 
			if (c == 0)
			{
				System.out.println("miss");
			}
			else
			{
				System.out.println("hit");
				enemy.loseHP(6);
				h += 6;
			}
			Game.sleep(500);
		}
		System.out.println(enemy.getName() + " got pelted for a total of " + h + " dmg!");
	}
	
}
