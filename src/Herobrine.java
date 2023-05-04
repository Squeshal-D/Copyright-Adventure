
public class Herobrine extends Character {

	String name = "Herobrine";
	String desc = "Minecraft Boogeyman";
	String quest = "Take the party to fight pure chaos";
	String preBattle = "Truly one of the most mysterious figures out there. Some swear he exists, while others would swear otherwise."
			+ "\nYou're not only about to find out that he's real. You're about to find out the true meaning of chaos.";
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
		int move = (int) (Math.random()*2);
		if (move == 0)
		{
			int dmg = 10 + (int) (Math.random()*21);
			System.out.println(player.getName() + " spawns a creeper behind " + enemy.getName() +" who gets blown up for " + dmg + " dmg!");
			enemy.loseHP(dmg);
		}
		else
		{
			Character victim = Game.party.get((int) (Math.random()*Game.party.size()));
			System.out.println(player.getName() + " griefed a random party member! " + victim.getName() + " takes 25 dmg!");
			victim.loseHP(25);
			if (victim.getHP() <= 0 && victim != enemy)
			{
				Game.sleep(1000);
				System.out.println("\nOh no! " + victim.getName() + " has passed away...");
				Game.party.remove(victim);
			}
		}
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int move = (int) (Math.random()*2);
		if (move == 0)
		{
			System.out.println(player.getName() + " sets the TNT loose! The whole party takes 5 dmg each!");
			for (int i = 0; i<Game.party.size(); i++)
			{
				Game.party.get(i).loseHP(5);
				if (Game.party.get(i).getHP() <= 0 && Game.party.get(i) != enemy)
				{
					Game.sleep(1000);
					System.out.println("\nOh no! " + Game.party.get(i).getName() + " has passed away...");
					Game.party.remove(i);
					i--;
				}
			}
		}
		else
		{
			int c = (int) (Math.random()*2);
			System.out.println(player.getName() + " noclips into " + enemy.getName() + " and possesses them!");
			Game.sleep(1000);
			Character victim = Game.party.get((int) (Math.random()*Game.party.size()));
			if (c == 0)
			{
				enemy.move1Exec(enemy, victim);
			}
			else enemy.move2Exec(enemy, victim);
			if (victim.getHP()<=0 && victim != enemy)
			{
				Game.sleep(1000);
				System.out.println("\nOh no! " + victim.getName() + " has passed away...");
				Game.party.remove(victim);
			}
		}
	}
}
