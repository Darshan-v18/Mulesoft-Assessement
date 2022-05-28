package mulesoft;

import java.util.*;

public class mainClass {
	public static void main(String[] args) {
		
		String db,tblName ;
		int ch;
//		Connect connect = new Connect();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1:Create DB \n2:Create Table\n3:Insert\n4:Select\n5:Quit\nEnter Your Choice:");
			ch = scanner.nextInt();
			
			Scanner input = new Scanner(System.in);
			switch(ch) {
			
			case 1 :
				System.out.println("Enter the database name");
				db = input.nextLine();
				connect.connect(db);
				break;
			case 2:
				
				System.out.println("Enter the database name");
				db = input.nextLine();
				if(connect.check(db)) {
				System.out.println(db);
				connect.connect(db);	
//				System.out.println("New database "+db +" created");
				System.out.println("Enter the table name");
				tblName = input.nextLine();
				createTable.createNewTable(db, tblName);
				}else {
					System.out.println("No such database exists");
				}
				break;
			case 3:
				System.out.println("Enter the database name");
				db = input.nextLine();
				if(connect.check(db)) {
				connect.connect(db);		
				System.out.println("New database "+db +" created");
				createTable.listTables(db);
				System.out.println("Enter the table name");
				tblName = input.nextLine();
//				Connect.connect(db);
				createTable.createNewTable(db, tblName);
				System.out.println("Table "+tblName+" created");
				insert insdata = new insert();
				insdata.insertNewData(db, tblName);
				}else {
					System.out.println("No such database exists");
				}
				break;
			case 4:
				
				System.out.println("1:Select all\n2:Select by actor\nEnter the choice:");
				ch = scanner.nextInt();
				
				switch(ch) {
				case 1:
					System.out.println("Enter the database name");
					db=input.nextLine();
					if(connect.check(db)) {
					connect.connect(db);
					createTable.listTables(db);
					System.out.println("Enter the table name");
					tblName = input.nextLine();
					select selectall = new select();
					selectall.selectAll(db,tblName);
					}else {
						System.out.println("No such database exists");
						
					}
					break;
				case 2:
					System.out.println("Enter the database name");
					db=input.nextLine();
					if(connect.check(db)) {
					connect.connect(db);
					createTable.listTables(db);
					System.out.println("Enter the table name");
					tblName = input.nextLine();
					System.out.println("Enter the actor name");
					String actor=input.nextLine();
					select selectactor=new select();
					selectactor.selectByActor(db,tblName,actor);
					}else {
						System.out.println("No such database exists");
					}
					break;
					default:System.out.println("invlaid option");
				}
			case 5:return;
			default:System.out.println("invlaid option");
			}
			
		}
    }

	}
