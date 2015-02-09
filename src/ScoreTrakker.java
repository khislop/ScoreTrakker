import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	public void loadDataFromFile(String infile) throws FileNotFoundException{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(infile);
		Scanner fin = new Scanner(reader);
		while(fin.hasNext()){
			students.add(new Student(fin.nextLine(),Integer.parseInt(fin.nextLine())));
		}
		fin.close();
	}
	
	public void printInOrder(){
		Collections.sort(students);
		for(Student e : students){
			System.out.println(e.toString());
		}
	}
	
	public void processFiles() throws FileNotFoundException{
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker sk = new ScoreTrakker();
		sk.processFiles();
	}
}
