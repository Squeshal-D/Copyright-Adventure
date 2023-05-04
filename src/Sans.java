
public class Sans extends Character{
	
	String name = "Sans Undertale";
	String desc = "Silly Skeleton";
	String quest = "Take the party to fight ded meme. (Or is it?)";
	String preBattle = "You are about to have a bad time.";
	String move1 = "null";
	String move2 = "null";
	String move1Desc = "null";
	String move2Desc = "null";
	int hp = 1;
	int maxhp = 1;
	
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
		int move = (int) (Math.random()*2);
		if (move == 0)
		{
			int dmg = (int) (Math.random()*51);
			System.out.println(player.getName() + " whacks " + enemy.getName() + " with a bone for " + dmg + " frames!");
			enemy.loseHP(dmg);
		}
		else
		{
			int i = (int) (Math.random()*Game.party.size());
			Character victim = Game.party.get(i);
			System.out.println(player.getName() + " rapidly changes the direction of gravity!");
			Game.sleep(1000);
			if (victim == enemy)
			{
				System.out.println(enemy.getName() + " doesn't collide with anyone!");
			}
			else
			{
				System.out.println(enemy.getName() + " collides with " + victim.getName() + " and both take 15 dmg!");
				victim.loseHP(15);
				enemy.loseHP(15);
				if (victim.getHP() <= 0)
				{
					Game.sleep(1000);
					System.out.println("\nOh no!" + victim.getName() + " has passed away...");
					Game.party.remove(victim);
				}
			}
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int move = (int) (Math.random()*3);
		if (move == 0 && !player.getQuest().equals("free turn"))
		{
			System.out.println(player.getName() + " breaks the fourth wall!");
			Game.sleep(1000);
			System.out.println("\"Hey, I'm speaking for Justin when I say thanks for playing my game! Enjoy this free turn.\"");
			Game.sleep(1000);
			player.changeQuest("free turn");
		}
		else
		{
			System.out.println(player.getName() + " censored this line of text so you don't know what he did! (Maybe check on your party)");
			int chance = (int) (Math.random()*3);
			if (chance == 0)
			{
				int dmg = 10 + (int) (Math.random()*21);
				int i = (int) (Math.random()*Game.party.size());
				Character victim = Game.party.get(i);
				victim.loseHP(dmg);
				if (victim.getHP() <= 0 && victim != enemy)
				{
					Game.party.remove(victim);
				}
			}
			else if (chance == 1)
			{
				for (int i = 0; i<Game.party.size(); i++)
				{
					int c = (int) (Math.random()*2);
					if (c == 0)
					{
						Game.party.get(i).healMax();
					}
					else
					{
						Game.party.get(i).loseHP(15);
					}
					if (Game.party.get(i).getHP() <= 0 && Game.party.get(i) != enemy)
					{
						Game.party.remove(i);
					}
				}
			}
		}
	}
	
}
