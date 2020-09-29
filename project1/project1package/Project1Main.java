package project1package;

public class Project1Main {

	public static void main(String[] args) {

		// test creating list from scratch
		Infected s1 = new Infected();
		
		Infected s2 = new Infected();
	
		ContactTracer myClass = new ContactTracer();
		System.out.println(myClass);
		myClass.addInfected(s1);
		myClass.addInfected(s2);

	
	   

		System.out.println(myClass);
		System.out.println();
		System.out.println();
		System.out.println();









		System.out.println("CODE STARTS GOING DOWN FROM HERE");
		Infected s4 = new Infected();
		//	        System.out.println(s2);
		ContactTracer lsit1 = new ContactTracer("LIST1","./project1/data.txt");
		System.out.println("\ntest reading text file");
		System.out.println(list1);
		list1.addInfected(s4);   



		System.out.println("\ntest combined data from file and data added manually");
		System.out.println(list1);        
		list1.writeFile("./project1/dataWriteTest.txt");

		ContactTracer testWrite = new ContactTracer("Test Write","./project1/dataWriteTest.txt");
		System.out.println("\ntest reading just created file");
		System.out.println(testWrite);




	}

}

