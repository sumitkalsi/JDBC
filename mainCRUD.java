package layers;

import java.sql.Connection;
import java.util.Scanner;

public class mainCRUD {

	public static void main(String[] args) {
	Connection con =   Connectiondb.connect();
	
	Scanner sc = new Scanner(System.in);
	boolean b =true;
		while (b) {
		System.out.println("1: CREATE");
		System.out.println("2: READ");
		System.out.println("3: UPDATE");
		System.out.println("4: DELETE");
	
		int a = sc.nextInt();
		
		switch (a) {
		
		
		case 1:{
			System.out.println("enter id ");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name= sc.next();
			System.out.println("enter address");
			String address= sc.next();
			  Entry obj = new Entry(id,name,address);
				
				boolean c = DAO.CREATE(con, obj);
				if(c==false) {
					System.out.println("record created");
					
				}else {
					System.out.println("cannot create new record");
				}
			break;
		}
		
		
		
		case 2:{
			 DAO.READ(con);	
			
				break;
		}
		
		
		
		
		case 3:{
			System.out.println("enter id ");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name= sc.next();
			System.out.println("enter address");
			String address= sc.next();
			  Entry obj = new Entry(id,name,address);
			  int i = DAO.UPDATE(con, obj);
			  if (i>0) {
				System.out.println("updated");
				
			} else {
             System.out.println("cannot update");
			}
			  break;
		}
		
		
		
		
		case 4:{
			System.out.println("enter id no to delete");
			int id = sc.nextInt();
			int i = DAO.DELETE(con, id);
			if (i>0) {
				System.out.println("record deleted");
				
			}else {
				System.out.println("cannot delete");
			}
			break;
		}
		
		
		default:{
			b=false;
			break;
		}
		
		}
  
	}
	sc.close();	
		

}
}