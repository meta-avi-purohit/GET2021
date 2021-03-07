public class Cage {
	private Animal animals[];
	private final int capacity;

	Cage(int capacity) {
		this.animals = new Animal[capacity];
		this.capacity = capacity;
	}

	public boolean addAnimalCage(Animal animal) {
		boolean flag = false;
		for (int i = 0; i < capacity; i++) {
			if (animals[i] == null) {
				animals[i] = animal;
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Animal[] getAnimals() {
		return animals;
	}
	public boolean removeAnimalCage(int number) {
		for (int i = 0; i < capacity; i++) {
			if(animals[i] != null){
				if(animals[i].getNumber() == number){
					animals[i] = null;
					return true;
				}
			}
			
		}
		return false;
	}
}

class ZooMammal {
	private Cage cages[];
	private int cageCapacity;
	private boolean hasCanteen;
	private boolean hasPark;
	
	public ZooMammal(int cages,int cageCapacity, boolean hasCanteen,boolean hasPark) {
		this.cages = new Cage[cages];
		this.cageCapacity = cageCapacity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	public Cage[] getCages() {
		return cages;
	}
	public boolean isHasPark() {
		return hasPark;
	}
	public boolean addAnimal(Mammal animal) {
		boolean addOrNot = false;
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] == null) {
				cages[i] = new Cage(cageCapacity);
				addOrNot = cages[i].addAnimalCage( animal);
				if(addOrNot == true)
					break;
			} else {
				addOrNot = cages[i].addAnimalCage( animal);
				if(addOrNot == true)
					break;
			}
		}
		return addOrNot;
	}
	public boolean removeAnimal(int number) {
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] != null) {
				if (cages[i].removeAnimalCage(number) == true) {
					return true;
				}
			}
		}
		return false;
	}
}
class ZooReptile {
	private Cage cages[];
	private int cageCapacity;
	private boolean hasCanteen;
	private boolean hasPark;
	
	public ZooReptile(int cages,int cageCapacity, boolean hasCanteen,boolean hasPark) {
		this.cages = new Cage[cages];
		this.cageCapacity = cageCapacity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	public Cage[] getCages() {
		return cages;
	}
	public boolean isHasPark() {
		return hasPark;
	}
	public boolean addAnimal(Animal animal) {
		boolean addOrNot = false;
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] == null) {
				cages[i] = new Cage(cageCapacity);
				addOrNot = cages[i].addAnimalCage( animal);
				if(addOrNot == true)
					break;
			} else {
				addOrNot = cages[i].addAnimalCage( animal);
				if(addOrNot == true)
					break;
			}
		}
		return addOrNot;
	}
	public boolean removeAnimal(int number) {
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] != null) {
				if (cages[i].removeAnimalCage(number) == true) {
					return true;
				}
			}
		}
		return false;
	}
}

class ZooBird {
	private Cage cages[];
	private int cageCapacity;
	private boolean hasCanteen;
	private boolean hasPark;
	
	public ZooBird(int cages,int cageCapacity, boolean hasCanteen,boolean hasPark) {
		this.cages = new Cage[cages];
		this.cageCapacity = cageCapacity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	public Cage[] getCages() {
		return cages;
	}
	public boolean isHasPark() {
		return hasPark;
	}
	public boolean addAnimal(Bird animal) {
		boolean addOrNot = false;
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] == null) {
				cages[i] = new Cage(cageCapacity);
				addOrNot = cages[i].addAnimalCage(animal);
				if(addOrNot == true)
					break;
			} else {
				addOrNot = cages[i].addAnimalCage( animal);
				if(addOrNot == true)
					break;
			}
		}
		return addOrNot;
	}
	public boolean removeAnimal(int number) {
		for (int i = 0; i < cages.length; i++) {
			if(cages[i] != null) {
				if (cages[i].removeAnimalCage(number) == true) {
					return true;
				}
			}
		}
		return false;
	}
}