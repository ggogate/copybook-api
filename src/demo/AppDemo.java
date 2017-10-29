package demo;

public class AppDemo {

	public static void main(String[] args) {
		CopyBook c = new CopyBook("resources/SAMPLE.CBL");
		c.parse();
		for(Field f:c.showTree()){			
			System.out.println(f.getLevel() + " " + f.getName() + " " + f.getStartPos() + " " + f.getEndPos() + " " + f.getLength());
		}
	}

}
