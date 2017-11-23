import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

/*citations	
http://www.java2novice.com/java-file-io-operations/file-list-from-folder/
http://www.codejava.net/java-se/file-io/list-files-and-directories-recursively-in-a-directory
https://coderanch.com/t/405709/java/Colon-loop foreach loops
*/

public class HW8Q1 {
	
	public static void main(String[] args) throws Exception{
		File write = new java.io.File("dir_tree.txt"); //file 
		PrintWriter output = new java.io.PrintWriter(write); //write to file
     
		writecontents("C:/Users/[put username here]/Desktop/java", 0, output); //changed username for privacy reasons

		output.close();
	}
	
	
    private static void writecontents(String path, int level, PrintWriter writeout){
        File directory = new File(path);
        File[] filearr = directory.listFiles();
		
		for(File f : filearr){
			
			for(int i = 0; i < level; i ++){
				writeout.print("\t"); //level control tabbing
			}
			
			if(f.isDirectory()){
				writeout.println("+-- " + f.getName());
				
				writecontents(f.getAbsolutePath(), level + 1, writeout); 
			} 
			else{
				writeout.println("|-- " + f.getName());
			}
		}
    }
	
}

	