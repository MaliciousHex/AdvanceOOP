package test;

import java.util.*;

public class Assigment1_1901507654 {
	
	private static ArrayList<Integer> studentId = new ArrayList<Integer>();
	private static ArrayList<String>studentName = new ArrayList<String>();
	private static ArrayList<Integer>studentMark = new ArrayList<Integer>();

	private static void cls() {
		for (int i = 0; i < 27; i++) {
			System.out.println("");
		}
	}
	
	private static int inputVal(int choose,int min,int max,String words) {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println(words);
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be a numeric");
				scan.nextLine();
			}
			
			if(choose < min || choose > max) {
				System.out.println("Input must be between "+min+" and "+max);
				scan.nextLine();
			}
		}while(choose < min || choose > max);
		return choose;
	}
	
	private static int inputVal(int choose,int min,int max,String[] words) {
		Scanner scan = new Scanner(System.in);
		
		do {
			for(int i = 0 ; i < words.length ;i++) {
				System.out.println(words[i]);
			}
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be a numeric");
				scan.nextLine();
			}
			if(choose < min || choose > max) {
				System.out.println("Input must be between "+min+" and "+max);
				scan.nextLine();
			}		
		}while(choose < min || choose > max);
		return choose;
	}

	private static void editData() {
		int choose;
		choose = seeData();
		connectArrayList(choose,"edit");
	}

	private static int seeData() {
		Scanner scan = new Scanner(System.in);
		
		if(studentId.size() > 0) {
			String word;
			int choose=0,max;
			
			if(studentId.size()>1) {
				word="Please input student no [1-"+ studentId.size() +"]";
			}else {
				word="Please input student no ["+studentId.size() +"]";
			}
			
			choose = inputVal(choose,1,studentId.size()+1,word);
			System.out.println("Student with No "+choose+" is ");
			choose--;
			System.out.println(studentId.get(choose));
			System.out.println(studentName.get(choose));
			System.out.println(studentMark.get(choose));
			scan.nextLine();
			return choose;
		}else {
			System.out.println("No Data");
			return 0;
		}

	}
	
	private static void connectArrayList(int i,String mode) {
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		int temp=0,temp2=0;
		String temp1="";
		
		do {
			flag = false;
			System.out.print((i+1)+". Please input student Id [10] ");
			try {
				temp = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Must Numeric and Number must ten digits");
				scan.nextLine();
			}
			if(!(temp/1000000000 < 1 || temp/1000000000 >9)) {
				flag = true;
			}
		}while(flag!=true);
		scan.nextLine();
		do {
			flag = false;
			System.out.print("Please input Student Name = ");
			temp1 = scan.nextLine();
			if(temp1 != null && !temp1.isEmpty() && temp1 != ""){
				flag = true;
			}
		}while(flag!=true);
		String words1 = "Please input Student Mark [0-100] = ";
		temp2 = inputVal(temp2,0,100,words1);
		
		if(mode.equalsIgnoreCase("insert")) {
			studentId.add(temp);
			studentName.add(temp1);
			studentMark.add(temp2);
		}else {
			studentId.set(i,temp);
			studentName.set(i,temp1);
			studentMark.set(i,temp2);
		}
	}
	
	private static void inputStudent() {
		Scanner scan = new Scanner(System.in);
		int choose = 0;
		String temp1="";
		//String[] words = new String[10];
		String words = "How many student [1-5] ? ";
		choose = inputVal(choose,1,5,words);
		for(int i = 0 ; i < choose ; i++) {
			connectArrayList(i,"insert");	
		}	
	}

	public static void main(String[] args) {
		int choose=0;	
		String[] words = {"Student Mark List","1. Input Student","2. See All Data",
							"3. Edit Data","4. Exit","","Input Your Choice [1-4] ?"};
		do {
			cls();
			choose = inputVal(choose,1,4,words);
			switch(choose){
				case 1 :
					inputStudent();
				break;
				case 2 :
					seeData();
				break;
				case 3 :
					editData();
				break;
			}
		}while(choose!=4);
		
	}

}
