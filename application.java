import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class application {
	public class Operations {

		//Bubble sort to sort file in ascending order
		protected static String[] sort_sub(String array[], int size){
			String temp = "";
			for(int i=0; i<size; i++){
				for(int j=1; j<(size-i); j++){
					if(array[j-1].compareToIgnoreCase(array[j])>0){
						temp = array[j-1];
						array[j-1]=array[j];
						array[j]=temp;
					}
				}
			}
			return array;
		}
		

		
		//File listing function
		protected static void listFiles() {
			
			int fileCount = 0;
		    ArrayList<String> filenames = new ArrayList<String>();
		
			File directoryPath = new File(System.getProperty("user.dir"));
			File[] listOfFiles = directoryPath.listFiles();
			fileCount = listOfFiles.length;
			
			
			System.out.println("Files in ascending order: ");
			for (int i = 0; i < fileCount; i++) {
			  if (listOfFiles[i].isFile()) {
			    filenames.add(listOfFiles[i].getName());
			  } 
			}
			
			String[] str = new String[filenames.size()];
			 
		    for (int i = 0; i < filenames.size(); i++) {
		        str[i] = filenames.get(i);
		    }
			
		    String[] sorted_filenames = sort_sub(str, str.length);
			
			for(String currentFile: sorted_filenames) {
				System.out.println(currentFile);
			}

		}
		
		//File delete function
		protected static void deleteFile(String fileToBeDeleted) {
			
			File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeDeleted );
			
			if(file.exists()) {
				if ( file.delete() ) {
					System.out.println(" File deleted successfully!");
				}
			} else {
				System.out.println("File wasn't deleted (File Not Found)");
			}
		}
		
		//File search function
		protected static void searchFile(String fileToBeSearched) {
		        
			File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeSearched );
			
			//Check whether file whether file exists or not.
			//If yes then display  message
			if(file.exists()) {
				System.out.println("File found!");
			} else {
				System.out.println("Sorry, File Not Found");
			}	PrintWriter pw;  
	        try {  
	            pw = new PrintWriter(fileToBeSearched); //may throw exception   
	            pw.println("saved");  
	        }  
	        // providing the checked exception handler  
	        catch (FileNotFoundException e) {  
	              
	            System.out.println(e);  
	        } 
		}

		//File creation function
		protected static void createFile (String fileToBeCreated) {
			File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeCreated );
			
			try {
				if (file.createNewFile() ) {
					System.out.println("File is Created Successfully!");
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int ch=0, choice=0;
		Scanner sc =new Scanner(System.in);
		
		System.out.println("\t********\n");
		System.out.println("\t Welcome to LockedMe. \n");
		System.out.println("\t********\n");
		System.out.println(" Developer\t: SAMAN SHRESTHA \n");
		
		while(true)
		{
			System.out.println("Please choose one of the following options :");
			System.out.println("1. List of Current Files Present in Ascending order");
			System.out.println("2. Here are some User Enabled Operations");
			System.out.println("3. Close The Application");
			try{    
				ch = sc.nextInt();
			}
			catch(Exception e)  
             {  
              System.out.println("Null Exception occurred");  
             }         
			
			switch(ch)
			{
			case 1: //List function feature the list all files in ascending order.
				Operations.listFiles();
				break;
			case 2:
				
					System.out.println("Please choose one of the following options :");
					System.out.println("1. Add a File");
					System.out.println("2. Delete a File");
					System.out.println("3. Search for a File");
					try{    
						 choice = sc.nextInt();
					}
					catch(Exception e)  
	                  {  
	                   System.out.println("Null Exception occurred");  
	                  }          
					switch(choice)
					{
					case 1:
						//Creation of a file takes place
						System.out.println("Input the name of a file to be created: ");
						String fileCreate = sc.next();
						
						// Calling the function to create the file
						Operations.createFile(fileCreate);
						break;
						
					case 2:
						//deletion of a file takes place
						System.out.print("Input the name of a file to be deleted: ");
						String fileDelete = sc.next();
						
						// Calling the function to delete the file
						Operations.deleteFile(fileDelete);
						break;
					case 3:
						//Search for a file takes place
						System.out.println("Input the name of a file to be searched: ");
						String fileSearch = sc.next();
						
						// Calling the function to search the file
						Operations.searchFile(fileSearch);
						break;
						
				default:
						//In the case of invalid input execute this
						System.out.println("\n Invalid Input,Re-do the process\n");
						break;
				}
			
					break;
			case 3:
				
				//Exiting the application
				sc.close();
				System.out.println("\n It was good to have U !");
				System.exit(1);
				break;
			
			default:
				//In the case of invalid input execute this
				System.out.println("\n\n Invalid Input, Select in the range of 1-3\n");
				break;
			
			}
		}
		
	}

}