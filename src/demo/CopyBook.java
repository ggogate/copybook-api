package demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CopyBook {

	private String path;
	private CharEncoding encoding;
	private int lineNumber;
	private List<Field> fields;
	private int recordPointer;
	public List<Field> getFields() {
		return fields;
		
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public CharEncoding getEncoding() {
		return encoding;
	}
	public void setEncoding(CharEncoding encoding) {
		this.encoding = encoding;
	}
	
	public CopyBook(){
		fields = new ArrayList<Field>();
	}
	public CopyBook(String path) {		
		this.path = path;
		fields = new ArrayList<Field>();
	}

	public void parse() {
		// Read the copybook file and generate the layout tree
		File file = new File(path);
		Scanner input = null;		
		String[] tokens = null;
		
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				lineNumber++;
			    String nextLine = input.nextLine();
			    if(nextLine.charAt(7) == '*'){
			    	//ignore Cobol comments
			    	continue;
			    }else{
			    	//System.out.println(nextLine);
			    	//tokens = nextLine.split("\\s");
			    	//tokens = nextLine.split(" ");
			    	tokens = nextLine.split("[ ]+");			    	
			    }
			    parseLine(tokens);
			    
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		input.close();
		
	}

	private void parseLine(String[] tokens) {
		Field field = new Field();
		
		// Check for group level fields
		if("PIC".equals(tokens[3])){
			// check pic clause
			String pic = tokens[4];
			if(pic.contains("X") || pic.contains("A")){ // String
				if(pic.contains("(") && pic.contains(")")){
					int beginParanthesis = pic.indexOf('(');
					int endParanthesis = pic.indexOf(')');
					String number =  pic.substring(beginParanthesis + 1, endParanthesis);
					field.setLength(Integer.parseInt(number));
					field.setStartPos(recordPointer);
					field.setEndPos(field.getStartPos() + field.getLength());
				}else{
					if(pic.endsWith(".")){ // if period is present
						field.setLength(pic.length()-1);
					}else{
						field.setLength(pic.length());	
					}
					
					field.setStartPos(recordPointer);
					field.setEndPos(field.getStartPos() + field.getLength());					
				}
				recordPointer = field.getEndPos();

			}else if(pic.contains("9")){ // Number
				if(pic.contains("S")){ // Signed
					
				}
				if(pic.contains("V9")){ // Decimal
					
				}
				if("COMP".equals(tokens[4])){
					field.setLength(0);
				}else if("COMP-3".equals(tokens[4])){
					field.setLength(0);
				}
			}
			// set as a field
			try{
				field.setLevel(Integer.parseInt(tokens[1].trim()));
				field.setName(tokens[2]);
				field.setPictureClause(tokens[4]);
				fields.add(field);
			}catch(Exception e){
				System.out.println("Error parsing line " + lineNumber + ": "+ Arrays.asList(tokens).toString());
			}
		}else{
			// check sub fields			
		}
		
		// Check for arrays
		for(String token:tokens){
			if (token.equals("OCCURS")){
				// this is an array
			}
		}
	}
	public List<Field> showTree() {
		return fields;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String read(){
		return null;
	}

}
