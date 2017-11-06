class Animal
{
	private int yearToLive; // note this variable is private
	private String bloodType;
	int number;
	Animal(int number)
	{
		this.number = number;
		System.out.println("I am a animal number : " + number );
	}
	
	protected void setyearToLive(int yearToLive) //setter can modify private variable because it is a protected method
	{
		this.yearToLive = yearToLive;
	}
	
	protected int getyearToLive() // getter return copy of the private variable and not its memory address
	{
		return this.yearToLive;
	}
	
	protected void setBlood( String bloodType )
	{
		this.bloodType = bloodType;
	}
	
	protected String getBlood()
	{
		return this.bloodType;
	}
	
}

class Mamal extends Animal
{

	private String bloodType;

	Mamal(int number)
	{
		super(number);
		/*this could be commented out but this is to show that constructer of parent class 
		will always be called*/
		
		System.out.println("I am a mamal number : " + number );
	}
	
	@Override
	protected void setBlood( String bloodType )
	{
		if(bloodType.equals("Warm") == true)
		{
			this.bloodType = bloodType;
		}
		else //this is encapsulation
		{
			System.out.println("Mamals can only be warm blooded. ");
			this.bloodType = null;
		}
	}

	@Override	
	protected String getBlood()
	{
		return this.bloodType;
	}
	
	void feedMilk()
	{
		System.out.println("I am  a mamal so I can feed my child breast milk. ");
	}
	
}


class InheritancePolyMorphismEncapsulation
{
	public static void main(String args[])
	{
		Animal animal1 = new Animal(1);
		/* Create an Animal 1 object and call the Animal class constructor */

		animal1.setyearToLive(100);
		System.out.println("Animal 1 lives for : " + animal1.getyearToLive() + " years ");
		/* Animal 1 lives a certain number of years */
		
		Mamal mamal0 = new Mamal(0);
		/*Create a Mamal 0 object and should call BOTH the Animal and Mamal class constructor*/
		
		mamal0.feedMilk();
		/*Mamal 0 can feed milk to it children using mamary glands */
		
		Mamal mamal1 =  new Mamal(1);
		/*Create a Mamal 1 object and should call BOTH the Animal and Mamal class constructor*/
		
		mamal1.setyearToLive(10);
		/* Mamal 1 lives a certain number of years so need not create a new method in
		mamal class but just call the one in Animals class */
		
		System.out.println("Mamal 1 with automatic method upcasting lives for : " + mamal1.getyearToLive() + " years ");
		/* The method is automatically getting upcasted here*/
		
		Animal dummy = (Animal)mamal1;
		System.out.println("Mamal 1 with manual method upcastinglives for : " + dummy.getyearToLive() + " years ");
		/* The method above is equaivalent to this but here we have type casted manually.
		But upcasting is done automatically by java so this is redundant but just shown to explain the concept */
		
		mamal1.feedMilk();
		/*Mamal 1 can feed milk to it children using mamary glands */
		
		Animal mamal2 =  new Mamal(2); //Upcasting 
		/*This is still a mamal object but its label is changed to Animal instead of animal*/

		mamal2.setyearToLive(10);
		
		System.out.println("Mamal 1 lives for : " + mamal2.getyearToLive() + " years ");
		/* The method is automatically getting upcasted here */		
		
		//mamal2.feedMilk();
		/*Why does the above line of code not work. Because remeber mamal2 still is a animal 
		and thus all methods of Mamal Class are hidden from it*/ 
		

		if(mamal2 instanceof Mamal ){ //checking if it is safe to downcast
			Mamal dum = (Mamal)mamal2; 	// downcast
			System.out.println("Since I am downcasted back to a mamal.");
			dum.feedMilk();
		}		
		
		Animal animal3 = new Animal(3);
		animal3.setBlood("Cold");
		
		System.out.println("Animal 3 has blood type : " + animal3.getBlood());
		
		Animal animal4 = new Animal(4);
		animal4.setBlood("Warm");
		
		System.out.println("Animal 4 has blood type : " + animal4.getBlood());		
		
		Mamal mamal3 = new Mamal(3);
		mamal3.setBlood("Cold");
		System.out.println("Mamal 3 has blood type : " + mamal3.getBlood());		
		System.out.println("Notice how animal 3 was repeated twice. This is because while numbering we did not assume mamals are also animals. ");
			
		Mamal mamal4 = new Mamal(4);
		mamal3.setBlood("Warm");
		System.out.println("Mamal 4 has blood type : " + mamal3.getBlood());		
				
		Animal animal5 = new Mamal(5);
		animal5.setBlood("Cold");
		System.out.println("Animal 5 has blood type : " + animal5.getBlood());		

		if(animal5 instanceof Mamal ){ //checking if it is safe to downcast
			Mamal dum2 = (Mamal)animal5; 	// downcast
			System.out.println("Mamal 5 has blood type : " + animal5.getBlood());		

		}		
		System.out.println("You just observed runtime polymorphism. ");
		/*This is JAVA Runtime polymorphism. Imagine what would occur if
		getBlood() from animal class was called*/
	}
	
	
}