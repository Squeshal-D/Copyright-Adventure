
public class HitSat extends Character{

	String name = "Hitler Satan";
	String desc = "The Worst Guy Ever Made";
	String quest = "null";
	String preBattle = "null";
	String move1 = "null";
	String move2 = "null";
	String move1Desc = "null";
	String move2Desc = "null";
	int hp = 500;
	int maxhp = 500;
	
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
		int chance = (int) (Math.random()*3);
		boolean pp = false;
		if (player.getMove2Desc().equals("not null"))
		{
			System.out.println(player.getName() + " firse the nazi laser of doom at " + enemy.getName() + " for 60 dmg!");
			enemy.loseHP(60);
			player.changeMove2Desc("null");
		}
		else if (chance == 0)
		{
			System.out.print(player.getName() + " rips the devil's lettuce! ");
			for (int i = 0; i<Game.party.size(); i++)
			{
				if (Game.party.get(i).getQuest().equals("Visit CVCHS"))
				{
					System.out.println(Game.party.get(i).getName() + " disapproves and slaps " + player.getName() + " for 5 dmg!");
					player.loseHP(5);
					pp = true;
				}
			}
			if (!pp)
			{
				int c = (int) (Math.random()*2);
				if (c == 0)
				{
					System.out.println("Fancy seeing you here, Demon Bowers! " + enemy.getName() + " gets rekt for 40 dmg!");
					enemy.loseHP(40);
				}
				else
				{
					System.out.println("Nothing happened!");
				}
				
			}
		}
		else if (chance == 1)
		{
			int c = 0;
			int h = 0;
			System.out.println(player.getName() + " fires their laser eyes!");
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
					enemy.loseHP(10);
					h += 10;
				}
				Game.sleep(500);
			}
			System.out.println(enemy.getName() + " got lasered for a total of " + h + " dmg!");
		}
		else
		{
			int dmg = 30 + (int) (Math.random()*21);
			System.out.println(player.getName() + " nazi punches " + enemy.getName() + " for " + dmg + " dmg!");
			enemy.loseHP(dmg);
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int chance = (int) (Math.random()*3);
		if (player.getMove2Desc().equals("not null"))
		{
			System.out.println(player.getName() + " firse the nazi laser of doom at " + enemy.getName() + " for 60 dmg!");
			enemy.loseHP(60);
			player.changeMove2Desc("null");
		}
		else if (chance == 0)
		{
			System.out.println(player.getName() + " charges the nazi laser of doom!");
			player.changeMove2Desc("not null");
		}
		else if (chance == 1)
		{
			System.out.println(player.getName() + " demon headbutts " + enemy.getName() + " for 50 dmg, but recieves 20 dmg in recoil!");
			enemy.loseHP(50);
			player.loseHP(20);
		}
		else
		{
			int c = (int) (Math.random()*2);
			System.out.println(player.getName() + " spread words of discouragement.");
			Game.sleep(1000);
			if (c == 0)
			{
					System.out.println(enemy.getName() + " cried to death.");
					enemy.loseHP(enemy.getHP());
			}
			else
			{
				System.out.println(enemy.getName() + " was fueled with anger and healed fully.");
				enemy.healMax();
			}
		}
	}
}
