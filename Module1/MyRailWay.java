package Labs06;

public class MyRailWay {

	public static void main(String[] args) {
		Rail r1 = new Rail(140);
		Rail r2 = new Rail(90);
		Rail r3 = new Rail(200);
		Train t1 = new Train ("Thomas",35, 10, r1);
		Train t2 = new Train ("Percy", 40, 20, r2);
		Train t3 = new Train ("Busan", r3);

		//t1.setPosition(90);
		t1.move(20);
		t2.move(15);
		t3.move(29);
		System.out.println(t1.getName() + " " + t1.getPosition());
		System.out.println(t2.getName() + " " + t2.getPosition());
		System.out.println(t3.getName() + " " + t3.getPosition());
		
		Train.strike();
		System.out.println(Train.getOnStrike());
		Train.breakStrike();
		System.out.println(Train.getOnStrike());
		

	}
}
	class Rail {
		private int length;
		
		public Rail(int length) {
			this.length = length;
		}
		public int getLength() {
			return this.length;
		}
	}

class Train {
	private String name;
	private int topSpeed;
	private int position;
	private Rail rail;
	private static boolean onStrike = false;
	
	public static boolean getOnStrike(){
		return Train.onStrike;
	}
	public static void strike() {
		Train.onStrike = true;
		
	}
	public static void breakStrike() {
		Train.onStrike = false;
	}

	
	public Train(String name, int topSpeed, int position, Rail rail) {
		this.name = name;
		this.topSpeed = topSpeed;
		this.position = position;
		this.rail = rail;
	}
	public Train(String name, Rail rail) {
		this(name, 30, 50, rail);
	}
	

	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		if(this.position ==0)
			System.out.println("In the shed!");
		if(this.position == this.rail.getLength())
			System.out.println("At the buffers!");
		return this.position;
		
	}
	public void setPosition(int position) {
		this.position = position;
		if (position <= this.rail.getLength())
		this.position = position;
		else
			this.position = this.rail.getLength();
		if(position <0)
			this.position = 0;
		
	}
	void move(int amount) {
		if(amount > this.topSpeed)
		amount = this.topSpeed;
		if(amount < this.topSpeed * (-1))
			amount = this.topSpeed * (-1);
		this.setPosition(this.position + amount);
	}
}

