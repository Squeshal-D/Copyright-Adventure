
public class Washington extends Character {

	String name = "George Washington";
	String desc = "The Father of Our Country";
	String quest = "Break into the Whitehouse";
	String preBattle = "You get past securty like a watermelon knife going through a stick of butter that has been in the oven for 5 hours."
			+ "\nYou're expecting to see Trump aren't you? You're surprised to see another man in the Oval Office. \"What have they done to my country? Look at this debt!\"";
	String move1 = "Cherry Chop";
	String move2 = "Musket Blast";
	String move1Desc = "The bigger they are... The more damage you do! Damage increases with the opponent's max HP. (10 - 50 dmg)";
	String move2Desc = "(ready!) Go Minuteman mode. 40 dmg, but needs to reload after each shot.";
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
		move2Desc = "(ready!) Go Minuteman mode. 40 dmg, but needs to reload after each shot.";
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
		int dmg = 0;
		if (enemy.getMaxHP() <= 50)
		{
			dmg = 10;
		}
		else if (enemy.getMaxHP() <= 60)
		{
			dmg = 15;
		}
		else if (enemy.getMaxHP() <= 80)
		{
			dmg = 30;
		}
		else if (enemy.getMaxHP() <= 100)
		{
			dmg = 40;
		}
		else dmg = 50;
		System.out.println(player.getName() + " swings the axe on " + enemy.getName() + " for " + dmg + " dmg!");
		enemy.loseHP(dmg);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		if (player.getMove2Desc().equals("(reload) Go Minuteman mode. 40 dmg, but needs to reload after each shot."))
		{
			System.out.println(player.getName() + " reloads the musket.");
			player.changeMove2Desc("(ready!) Go Minuteman mode. 40 dmg, but needs to reload after each shot.");
		}
		else
		{
			if (enemy.getQuest().equals("Go into that big ol barn over there"))
			{
				System.out.println(player.getName() + " calmed Lennie down.");
				Game.sleep(2000);
				if (Game.party.size() > 1)
				{
					System.out.println(player.getName() + " turns to the party and says, \"There's something I have to do.\"");
					Game.sleep(3000);
				}
				System.out.println(player.getName() + " and Lennie go down to the river and sit down.");
				Game.sleep(2000);
				System.out.println("\"Tell me about the rabbits, " + player.getName() + ",\" said Lennie.");
				Game.sleep(3000);
				System.out.println("\"Well, we gonna get a little place. We'll have a cow...\"");
				Game.sleep(2000);
				System.out.println(player.getName() + " raises the musket with quivering hands.");
				Game.sleep(2000);
				System.out.println("Lennie continued, \"an' down the flat we'll have a... little piece alfalfa... For the rabbits!\"");
				Game.sleep(3000);
				System.out.println("\"For the rabbits...\" " + player.getName() + " repeated.");
				Game.sleep(2000);
				System.out.println("\"And I get to tend the rabbits. An' live on the fatta the lan'!\"");
				Game.sleep(2000);
				System.out.println(player.getName() + " aims the musket where the spine and skull are joined.");
				Game.sleep(3000);
				System.out.println("\"When we gonna do it, " + player.getName() + "?\" asked Lennie.");
				Game.sleep(2000);
				System.out.println("\"Gonna do it soon.\"");
				Game.sleep(2000);
				System.out.println(player.getName() + " pulled the trigger. The crash of the shot rolled up and down the hills.");
				Game.sleep(5000);
				player.changeMove2Desc("(reload) Go Minuteman mode. 40 dmg, but needs to reload after each shot.");
				enemy.loseHP(enemy.getHP());
			}
			else
			{
				System.out.println(player.getName() + " fires a musket at " + enemy.getName() + " for 40 dmg!");
				if (player.getMove2Desc().equals("(ready!) Go Minuteman mode. 40 dmg, but needs to reload after each shot."))
				{
					player.changeMove2Desc("(reload) Go Minuteman mode. 40 dmg, but needs to reload after each shot.");
				}
				enemy.loseHP(40);
			}
		}
	}
	
}
