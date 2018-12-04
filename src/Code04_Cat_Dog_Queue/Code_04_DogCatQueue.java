package Code04_Cat_Dog_Queue;

public class Code_04_DogCatQueue {
	public static class Pet{
		private String type;

		public Pet(String type) {
			this.type = type;
		}
		
		public String getPetType() {
			return this.type;
		}
	}
	public static class Dog extends Pet{
		public Dog() {
			super("Dog");
		}
	}
	
	public static class Cat extends Pet{
		public Cat() {
			super("Cat");
		}
	}
	
	public static class PetEnterQueue{
		private Pet pet;
		private long count;
	}
}
