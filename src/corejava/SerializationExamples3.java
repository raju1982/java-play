package corejava;

import java.io.*;

class Actor {
	String name;

	Actor() {
		System.out.println("Actor constructor");
		name = "Default";
	}
}

class Hero extends Actor implements Serializable {
	String danceType;

	Hero() {
		System.out.println("Hero constructor");
		danceType = "Default";
	}
}

public class SerializationExamples3 {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FileOutputStream fileStream = new FileOutputStream("Hero.ser");
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

		Hero hero = new Hero();
		hero.danceType = "Ganganam";
		hero.name = "Hero1";

		// Before -> DanceType :Ganganam Name:Hero1
		System.out.println("Before -> DanceType :" + hero.danceType + " Name:"
				+ hero.name);

		objectStream.writeObject(hero);
		objectStream.close();

		FileInputStream fileInputStream = new FileInputStream("Hero.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(
				fileInputStream);
		hero = (Hero) objectInputStream.readObject();
		objectInputStream.close();

		// When subclass is serializable and superclass is not, the state of
		// subclass variables is retained. However, for the super class,
		// initialization
		// constructors and initializers are run again.
		// After -> DanceType :Ganganam Name:Default
		System.out.println("After -> DanceType :" + hero.danceType + " Name:"
				+ hero.name);
	}
}