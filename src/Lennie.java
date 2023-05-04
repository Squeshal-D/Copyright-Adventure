
public class Lennie extends Character {

	String name = "Lennie Small";
	String desc = "Pro Rabbit Tender";
	String quest = "Go into that big ol barn over there";
	String preBattle = "The huge barn door slowly opens and you peek inside. By the light through the door you can see the figure of a large man"
			+ "\npetting a small rodent. \"You're lookin' pretty soft.\" He drops the lifeless rodent and lumbers toward you.";
	String move1 = "Hair Pull";
	String move2 = "Hand Crusher";
	String move1Desc = "Lennie can't resist! Gets stronger as Lennie's hp drops (0 to 40 dmg).";
	String move2Desc = "Gonna need a glove fulla vaseline after this one. Does more dmg on characters with low MaxHP (0 dmg at 100 Max HP).";
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
		int dmg = (player.getMaxHP()/2) - (player.getHP()/2);
		System.out.println(player.getName() + " pulls on " + enemy.getName() + "'s hair for " + dmg + " dmg!");
		enemy.loseHP(dmg);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		int dmg = 50 - (enemy.getMaxHP()/2);
		if (dmg < 0)
		{
			dmg = 0;
		}
		if (enemy.getQuest().equals("Take the party to fight raw power"))
		{
			System.out.println(enemy.getName() + " suffers a hand injury and can no longer snap!");
			enemy.changeQuest("no snap");
		}
		else
		{
			System.out.println(player.getName() + " crushes " + enemy.getName() + "'s hand for " + dmg + " dmg!");
			enemy.loseHP(dmg);
		}
	}
	
}
