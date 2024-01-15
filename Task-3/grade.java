package skybug_internship;
import java.util.Scanner;


public class grade {

	public static void main(String[] args) {
	while(true) {
		int no;  // to store number of subjects 
		int sum =0;  // to store the sum of marks 
		float percent ;  //to store the percentage of the student 
		char grade='N' ;   // to store the grade 
		Scanner sc = new Scanner(System.in); 
			
			System.out.println("\n`````````````````````` Student Grading System ``````````````````````\n");
			
			System.out.print("\nHow many subjects do you have :- ");
			no=sc.nextInt();
			
			String subjects[]=new String[no];   // array to store the names of the subjects 
			int marks[]=new int[no];         // array to store the marks of the subject 
			
			System.out.println("\nEnter the names of the subjects : ");
			
			
			// loop to input names of all the subjects 
			for (int i =0;i<no;i++) {
				subjects[i]=sc.next();
			}
			
		
			System.out.println("\n*Enter marks out of 100 only ");
			//loop to input marks of all subjects 
			for (int i=0;i<no;i++) {
				System.out.print("\nEnter marks for "+subjects[i]+" : ");
				marks[i]=sc.nextInt();
				sum = sum+marks[i];
				
			}
			if(sum>(no*100)) {
				System.out.println("\nInvalid marks !!\nEnter the information again ! ");
				continue;
				}
		
		
		percent = sum/no;  //calculating percentage 
		int p = Math.round(percent);
		System.out.println("\n\n");
	
		if(p<=25 && p>0) {
			System.out.println("\nSorry you are failed !! ");
			grade ='E';
		}else if(p>25 && p<=50) {
			grade ='D';
		}else if(p>50 && p<=75) {
			grade='C';
		}else if(p>75 && p<=90) {
			grade='B';
		}else if(p>90 && p<100){
			grade='A';
			System.out.println("\n\nCongrats!!! You have passed with Distinction !!!!!!! ");
		}else {
			System.out.println("\nInvalid marks entered !!");
		}
		
		if(grade=='N') {
			System.out.println("\nEntry Error !! Re-enter marks ");
			continue;
		}
		System.out.println("\n----------  SCORECARD ----------");
		for(int i=0;i<no;i++) {
			System.out.print("\n"+subjects[i]+" --> "+marks[i]);
			
		}
		System.out.println("\n\n~~~~~~~~~ RESULT ~~~~~~~~~~~~~~");
		System.out.println("\nTotal Marks = "+sum);
		System.out.println("\nPercentage : "+percent);
		System.out.println("\nGrade : "+grade);
		
		System.out.println("\nDo you want to calculate another result ?\n1--> Yes\n2-->No");
		int ch = sc.nextInt();
		if(ch == 1) {
			continue;
			
		}else {
			System.out.println("\nThank you!! for using student grading system .");
			break;
		}
	}

}
}
