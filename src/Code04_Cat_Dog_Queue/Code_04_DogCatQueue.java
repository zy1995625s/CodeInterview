package Code04_Cat_Dog_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Code_04_DogCatQueue{
	public static class Pet{
		private String type;
		
		public Pet() {}
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
			
	public static class PetNode{
		private Pet pet;
		private long nth;
			
		public PetNode() {}
		public PetNode(Pet pet, long nth) {
			this.pet = pet;
			this.nth = nth;
		}
			
		public Pet getPet() {
			return this.pet;
		}
		public long getNth() {
			return this.nth;
		}
	}
	
	public static class DogCatQueue{
		private Queue<PetNode> dogQ;
		private Queue<PetNode> catQ;
		private long nth;
		
		public DogCatQueue() {
			this.dogQ = new LinkedList<PetNode>();
			this.catQ = new LinkedList<PetNode>();
		}
		
		public void add(Pet pet) {
			if(pet.getPetType().equals("dog")) {
				this.dogQ.add(new PetNode(pet, this.nth+1));
			} else if(pet.getPetType().equals("cat")) {
				this.catQ.add(new PetNode(pet, this.nth+1));
			} else {
				throw new RuntimeException("err, not dog or cat");
			}
		}
		
		public Pet pollAll() {
			if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
				if(this.dogQ.peek().getNth() < this.catQ.peek().getNth()) {
					return this.dogQ.poll().getPet();
				} else {
					return this.catQ.poll().getPet();
				}
			} else if(!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			} else if(!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			} else {
				throw new RuntimeException("err, the queue is empty!");
			}
		}
		
		public Dog pollDog() {
			if(!this.isDogEmpty()) {
				return (Dog) this.dogQ.poll().getPet();
			} else {
				throw new RuntimeException("err, the dog queue is empty!");
			}
		}
		
		public Cat pollCat() {
			if(!this.isCatEmpty()) {
				return (Cat) this.catQ.poll().getPet();
			} else {
				throw new RuntimeException("err, the cat queue is empty!");
			}
		}
		
		public boolean isDogEmpty() {
			return this.dogQ.isEmpty();
		}
		
		public boolean isCatEmpty() {
			return this.catQ.isEmpty();
		}
	}
}