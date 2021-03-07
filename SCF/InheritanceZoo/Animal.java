class Animal {

	private static int timeStamp = 1;
	private int number;
	private int age;
	private int weight;
	private String name;

	Animal(int age, int weight, String name) {
		this.age = age;
		this.weight = weight;
		this.name = name;
		this.number = timeStamp++;
	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

}

class Mammal extends Animal {
	Mammal(int age, int weight, String name) {
		super(age, weight, name);
	}
}

class Reptile extends Animal {

	Reptile(int age, int weight, String name) {
		super(age, weight, name);
	}
}

class Bird extends Animal {
	Bird(int age, int weight, String name) {
		super(age, weight, name);
	}
}

class Lion extends Mammal {
	Lion(int age, int weight, String name) {
		super(age, weight, name);
	}

	private String sound = "roars";

	public String getSound() {
		return this.sound;
	}
}

class Crocodile extends Reptile {
	private String sound = "bellow";

	Crocodile(int age, int weight, String name) {
		super(age, weight, name);
	}

	public String getSound() {
		return this.sound;
	}
}

class Peacock extends Bird {
	private String sound = "scream";

	Peacock(int age, int weight, String name) {
		super(age, weight, name);
	}

	public String getSound() {
		return this.sound;
	}
}

class Tiger extends Mammal {
	private String sound = "growl";

	Tiger(int age, int weight, String name) {
		super(age, weight, name);
	}

	public String getSound() {
		return this.sound;
	}
}

class Snake extends Reptile {
	private String sound = "hiss";

	Snake(int age, int weight, String name) {
		super(age, weight, name);
	}

	public String getSound() {
		return this.sound;
	}
}