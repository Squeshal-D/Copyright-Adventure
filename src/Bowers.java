
public class Bowers extends Character {

	String name = "John Bowers";
	String desc = "Disher of Discipline";
	String quest = "Visit CVCHS";
	String preBattle = "You've arrived in the senior lot. Something isn't right. The gate is closed. You look at the time."
			+ "\nWould anyone be willing to fight at 8:01? You turn around when, \"HEY! I've caught you!\"";
	String move1 = "Ambush";
	String move2 = "Words of Encouragement";
	String move1Desc = "You can never expect it. 15 dmg, doubled if the opponent has full HP";
	String move2Desc = "Word Diarrhea. 20% chance to make the opponent leave, otherwise they heal fully.";
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
		if (hp <= 0)
		{
			Game.bStatus = false;
		}
	}
	
	public void healMax()
	{
		hp = maxhp;
		Game.bStatus = true;
	}
	
	public void changeQuest(String s)
	{
		quest = s;
	}
	
	public void move1Exec(Character player, Character enemy)
	{
		if (enemy.getHP() == enemy.getMaxHP())
		{
			System.out.println("Surprise! " + player.getName() + " ambushed " + enemy.getName() + " when they weren't expecting it for 30 dmg!");
			enemy.loseHP(30);
		}
		else
		{
			System.out.println(player.getName() + " ambushed " + enemy.getName() + ". They weren't surprised, but got a fat spank for 15 dmg.");
			enemy.loseHP(15);
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int c = (int) (Math.random()*5);
		System.out.println(player.getName() + " spread words of encouragement.");
		Game.sleep(1000);
		if (c == 4)
		{
			if (enemy.getMaxHP() >= 150)
			{
				System.out.println(enemy.getName() + " takes 100 dmg because it would be cheap to kill a boss/miniboss so easily!");
				enemy.loseHP(100);
			}
			else
			{
				System.out.println(enemy.getName() + " couldn't stand the cheesy dialogue and just left.");
				enemy.loseHP(enemy.getHP());
			}
		}
		else
		{
			System.out.println(enemy.getName() + " was inspired deeply and healed fully.");
			enemy.healMax();
		}
	
	}
	
}
