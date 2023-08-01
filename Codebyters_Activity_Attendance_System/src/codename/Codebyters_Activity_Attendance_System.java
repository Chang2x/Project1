package codename;

import java.util.Scanner;
//import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Codebyters_Activity_Attendance_System {
	static ArrayList<String[]> activities = new ArrayList<String[]>();
	static ArrayList<String[]> participants = new ArrayList<String[]>();
	static ArrayList<String[]> attendance = new ArrayList<String[]>();
	static ArrayList<String> courses = new ArrayList<String>();
	private static final String ACTIVITY_FILE_NAME = "activity.txt";
    private static final String PARTICIPANTS_FILE_NAME = "participant.txt";

    public static void main(String[] args) {
    	initializeSampleData();
    	Scanner scanner = new Scanner(System.in);
    	int choice = 0;

    	while (true) {
    		System.out.println("=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n"
    				+ "-------------------[Codebyters Activity Menu]--------------------\n"
    				+ "[]                                                             []\n"
    				+ "[]    1. Create new activity                                   []\n"
    				+ "[]    2. Register new participant                              []\n"
    				+ "[]    3. Record attendance                                     []\n"
    				+ "[]    4. View Dashboard                                        []\n"
    				+ "[]    5. Search Participants                                   []\n"
    				+ "[]    6. Exit                                                  []\n"
    				+ "-----------------------------------------------------------------\n");

    		System.out.print("Enter your choice: ");
    		if (scanner.hasNextInt()) {
    			choice = scanner.nextInt();
    			scanner.nextLine(); // consume the remaining newline character

    			System.out.println("---------------------------------------------------------------");

    			switch (choice) {
    				case 1:
    					createActivity();
    					break;
    				case 2:
    					createParticipant();
    					break;
    				case 3:
    					recordAttendance();
    					break;
    				case 4:
    					dashboard();
    					break;
    				case 5:
    					search();
    					break;
    				case 6:
    					System.out.println("Thank you for using Codebyters Attendance Program!");
    					scanner.close();
    					System.exit(0);
    				default:
    					System.out.println("Invalid choice. Please enter a number between 1 and 6.");
    			}
    		} else {
    			System.out.println("------------------------------------------------------------------------");
    			System.out.println("Invalid input. Please enter a number.");
    			scanner.nextLine(); // consume the invalid input
    		}
    	}
    }
public static void initializeSampleData() {
	String[] activity1 = {"001", "Codebyters Hackathon", "24-hour hackathon", "2023-05-01", "10", "Codebyters"};
	String[] activity2 = {"002", "Codebyters Workshop", "Learn Java programming", "2023-05-15", "2", "Codebyters"};
	String[] participant1 = {"001", "John", "Macapagal", "Male", "2000-01-01", "BSCS"};
	String[] participant2 = {"002", "Jane", "Aquino", "Female", "2002-03-15", "BSIT"};
	courses.add("BSCE");
	courses.add("BSIT");
	courses.add("BSMATH");
	courses.add("BITM");
	activities.add(activity1);
	activities.add(activity2);
	participants.add(participant1);
	participants.add(participant2);
}



public static void createActivity() {
    int maxAttempts = 5;
    int attempts = 0;
    String activityId = "";
    String activityName = "";
    String activityDescription = "";
    String activityDate = "";
    String creditHours = "";
    String organizer = "";
    Scanner scanner = new Scanner(System.in);

    System.out.println("[]==========================================[]\n"
    		+ "[]                                          []\n"
    		+ "[]                                          []\n"
    		+ "[]          Creating An Activity            []\n"
    		+ "[]                                          []\n"
    		+ "[]                                          []\n"
    		+ "[]==========================================[]\n");
    
    while (attempts < maxAttempts) {
    int remainingAttempts = maxAttempts - attempts;
        System.out.print("Enter activity ID: ");
        activityId = scanner.nextLine();	
        boolean idExists = false;
        for (String[] activity : activities) {
            if (activity[0].equalsIgnoreCase(activityId)) {
                idExists = true;
                break;
            }
        }

        if (idExists) {
            System.out.println("Activity ID already exists!");
        } else if (!activityId.matches("\\d+")) {
            System.out.println("Invalid activity ID! Please enter an integer.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create activity.");
        return;
    }
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter activity name: ");
        activityName = scanner.nextLine();

        boolean nameExists = false;
        for (String[] activity : activities) {
            if (activity[1].equalsIgnoreCase(activityName)) {
                nameExists = true;
                break;
            }
        }

        if (nameExists) {
            System.out.println("Activity with the same name already exists!");
        } else if (!activityName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid activity name! Only alphabetic characters are allowed.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create activity.");
        return;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter activity description: ");
        activityDescription = scanner.nextLine();

        if (!activityDescription.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid activity description! Only alphabetic characters and spaces are allowed.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create activity.");
        return;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter activity date (yyyy-MM-dd): ");
        activityDate = scanner.nextLine();

        if (!activityDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create activity.");
        return;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter activity credit hours: ");
        creditHours = scanner.nextLine();

        if (!creditHours.matches("\\d+")) {
            System.out.println("Invalid credit hours! Please enter an integer.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create activity.");
        return;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter activity organizer: ");
        organizer = scanner.nextLine();

        if (!organizer.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid organizer! Only alphabetic characters and spaces are allowed.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create activity.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    String[] activity = {activityId, activityName, activityDescription, activityDate, creditHours, organizer};
    activities.add(activity);
    System.out.println("Activity added successfully!");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACTIVITY_FILE_NAME, true))) {
        writer.write("Activity ID: " + activity[0] + "\n");
        writer.write("Activity Name: " + activity[1] + "\n");
        writer.write("Activity Description: " + activity[2] + "\n");
        writer.write("Activity Date: " + activity[3] + "\n");
        writer.write("Credit Hours: " + activity[4] + "\n");
        writer.write("Organizer: " + activity[5] + "\n");
        writer.write("\n");

        System.out.println("Data saved to file 'activities.txt'.");
    } catch (IOException e) {
        System.out.println("Error occurred while saving data to file: " + e.getMessage());
    }
}
public static void createParticipant() {
    int maxAttempts = 5;
    int attempts = 0;
   
    String dateString = "";
    String gender = "";
    String memberId = "";
    String firstName = "";
    String lastName = "";
    String course = "";
    Scanner scanner = new Scanner(System.in);

    System.out.println("[]==========================================[]\n"
    		+ "[]                                          []\n"
    		+ "[]                                          []\n"
    		+ "[]          Register new participants       []\n"
    		+ "[]                                          []\n"
    		+ "[]                                          []\n"
    		+ "[]==========================================[]\n");
    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;
        
        System.out.print("Enter participant ID: ");
        memberId = scanner.nextLine();

        boolean idExists = false;
        for (String[] participant : participants) {
            if (participant[0].equalsIgnoreCase(memberId)) {
                idExists = true;
                break;
            }
        }

        if (idExists) {
            System.out.println("participant ID already exists!");
            if (remainingAttempts == 1) {
                System.out.println("Maximum attempts reached. Unable to create participant.");
                return;
            }
            System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
            System.out.println("-------------------------------------------------");

        } else if (!memberId.matches("\\d+")) {
            System.out.println("Invalid member ID! Please enter an integer.");
            if (remainingAttempts == 1) {
                System.out.println("Maximum attempts reached. Unable to create participant.");
                return;
            }
            System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
            System.out.println("-------------------------------------------------");

        } else {
            break;
        }
        
        attempts++;
    }

    if (attempts >= maxAttempts) {
        System.out.println("Maximum attempts reached. Unable to create participant.");
        return;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();

        if (!firstName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid first name! Only alphabetic characters are allowed.");
            if (remainingAttempts == 1) {
                System.out.println("Maximum attempts reached. Unable to create participant.");
                return;
            }
            System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
            System.out.println("-------------------------------------------------");
        } else {
            break;
        }

        attempts++;
    }
    
    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();

        boolean participantExists = false;
        for (String[] participant : participants) {
            if (participant[2].equalsIgnoreCase(lastName)) {
                participantExists = true;
                break;
            }
        }

        if (participantExists) {
            System.out.println("Participant with the same last name already exists!");
        } else if (!lastName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid last name! Only alphabetic characters are allowed.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create a participant.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter gender (Female/Male): ");
        gender = scanner.nextLine();

        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            System.out.println("Invalid gender!");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create a participant.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        dateString = scanner.nextLine();

        if (!dateString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create a participant.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;

        System.out.print("Enter course: ");
        course = scanner.nextLine();

        boolean validCourse = false;
        for (String availableCourse : courses) {
            if (availableCourse.equalsIgnoreCase(course)) {
                validCourse = true;
                break;
            }
        }

        if (!validCourse) {
            System.out.println("Invalid course!");
        } else {
            break;
        }

        if (remainingAttempts == 1) {
            System.out.println("Maximum attempts reached. Unable to create a participant.");
            return;
        }

        System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
        System.out.println("-------------------------------------------------");

        attempts++;
    }

    String[] participant = {memberId, firstName, lastName, gender, dateString, course};
    participants.add(participant);
    System.out.println("Participant added successfully!");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PARTICIPANTS_FILE_NAME, false))) {
        for (String[] participant1 : participants) {
            writer.write("Member ID: " + participant1[0] + "\n");
            writer.write("First Name: " + participant1[1] + "\n");
            writer.write("Last Name: " + participant1[2] + "\n");
            writer.write("Gender: " + participant1[3] + "\n");
            writer.write("Birthdate: " + participant1[4] + "\n");
            writer.write("Course: " + participant1[5] + "\n");
            writer.write("\n");
        }

        System.out.println("Data saved to file 'participants.txt'.");
    } catch (IOException e) {
        System.out.println("Error occurred while saving data to file: " + e.getMessage());
    }
}
public static void recordAttendance() {
    int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {
        int remainingAttempts = maxAttempts - attempts;
        boolean valid = false;
        String dateString = "";
        String memberId = "";
        String timeString = "";
        String activityId = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Recording attendance");

        while (!valid) {
            boolean idExists = false;
            System.out.print("Enter activity ID (or 'exit' to cancel): ");
            activityId = scanner.nextLine();

            if (activityId.equalsIgnoreCase("exit")) {
                System.out.println("Attendance recording canceled.");
                return;
            }

            idExists = false;
            String[] foundActivity = null;
            for (String[] activity : activities) {
                if (activity[0].equalsIgnoreCase(activityId)) {
                    idExists = true;
                    foundActivity = activity;
                    break;
                }
            }

            if (!idExists) {
                System.out.println("Activity ID does not exist!");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            if (!activityId.matches("\\d+")) {
                System.out.println("Invalid activity ID! Please enter an integer.");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            System.out.println("Activity Information:");
            System.out.println("Activity ID: " + foundActivity[0]);
            System.out.println("Activity Name: " + foundActivity[1]);
            System.out.println("Activity Description: " + foundActivity[2]);
            System.out.println("Activity Date: " + foundActivity[3]);
            System.out.println("Credit Hours: " + foundActivity[4]);
            System.out.println("Organizer: " + foundActivity[5]);
            System.out.println("-------------------------------------------------");

            System.out.print("Enter participant member ID: ");
            memberId = scanner.nextLine();

            idExists = false;
            for (String[] participant : participants) {
                if (participant[0].equalsIgnoreCase(memberId)) {
                    idExists = true;
                    break;
                }
            }

            if (!idExists) {
                System.out.println("Member ID does not exist!");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            if (!memberId.matches("\\d+")) {
                System.out.println("Invalid member ID! Please enter an integer.");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            System.out.print("Enter login date (yyyy-MM-dd): ");
            dateString = scanner.nextLine();

            if (!dateString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            System.out.print("Enter login time (HH:mm:ss): ");
            timeString = scanner.nextLine();

            if (!timeString.matches("\\d{2}:\\d{2}:\\d{2}")) {
                System.out.println("Invalid time format. Please enter a time in the format HH:mm:ss.");
                if (remainingAttempts == 1) {
                    System.out.println("Maximum attempts reached. Unable to record attendance.");
                    return;
                }
                System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
                System.out.println("-------------------------------------------------");
                break;
            }

            valid = true;
        }

        if (valid) {
            String[] attendanceRecord = { activityId, memberId, dateString, timeString };
            attendance.add(attendanceRecord);
            System.out.println("Attendance recorded successfully!");
            return;
        }

        attempts++;
    }

    System.out.println("Maximum attempts reached. Redirecting back to the main menu.");
}
public static void dashboard(){
	
	System.out.println("Select 1 of the following:");
    System.out.println("1 - List all activities");
    System.out.println("2 - List all participants");
    System.out.println("3 - list of Female participants");
    System.out.println("4 - list of Male participants");
    System.out.println("5 - view participants of an activity");
    System.out.print("Enter choice: ");
    Scanner sc = new Scanner(System.in);
    if (sc.hasNextInt()) {
    int choice = sc.nextInt();
    sc.nextLine();
    System.out.println("---------------------------------------------------------------------------");
    switch (choice) {
    
        case 1:
        	System.out.println("List of activities");      	
//        	try (BufferedReader reader = new BufferedReader(new FileReader("activity.txt"))) {
//        	    String line;
//        	    while ((line = reader.readLine()) != null) {
//        	        System.out.println(line);
//        	    }
//        	    reader.close();
//        	} catch (IOException e) {
//        	    System.out.println("Error occurred while reading data from file: " + e.getMessage());
//        	}
        	
        	System.out.println("List of all activities");
        	System.out.println("Activity ID\tName\t\t\tDate\t\tHours\tOrganizer");
        	for (String[] activity : activities) {
        		System.out.printf("%s\t\t%s\t%s\t%s\t%s\n", activity[0], activity[1], activity[3], activity[4], activity[5]);
}
            break;
        case 2:
            System.out.println("List of participants");
//            try (BufferedReader reader = new BufferedReader(new FileReader("participant.txt"))) {
//        	    String line;
//        	    while ((line = reader.readLine()) != null) {
//        	        System.out.println(line);
//        	    }
//        	    reader.close();
//        	} catch (IOException e) {
//        	    System.out.println("Error occurred while reading data from file: " + e.getMessage());
//        	}
        	
        	System.out.println("List of all participants");
        	System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
        	for (String[] participant : participants) {
        		System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n", participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
        	}
            break;
        case 3:
        	 System.out.println("List Female Members:");
        	 System.out.println("List of female participants");
        		System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
        		for (String[] participant : participants) {
        			if (participant[3].equalsIgnoreCase("Female")) {
        				System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n", participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
        				}
        			}
                     break;
         case 4:
            System.out.println("List Male participants:");
            System.out.println("List of male participants");
         	System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
         	for (String[] participant : participants) {
         		if (participant[3].equalsIgnoreCase("Male")) {
         			System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n",participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
         		}
         	}
            	 break;
         case 5:
        	 System.out.print("Enter activity ID: ");
        	    String activityId = sc.nextLine();

        	    boolean activityExists = false;
        	    for (String[] activity : activities) {
        	        if (activity[0].equalsIgnoreCase(activityId)) {
        	            activityExists = true;
        	            System.out.println("Participants of Activity ID " + activity[0]);
        	            System.out.println("-------------------------------------------------");
        	            System.out.println("Activity\t\tParticipant\tTime\t\tDate");
        	            

        	            boolean participantsFound = false;
        	            for (String[] attendanceRecord : attendance) {
        	                if (attendanceRecord[0].equalsIgnoreCase(activityId)) {
        	                    String memberId = attendanceRecord[1];
        	                    String time = attendanceRecord[3];
        	                    String date = attendanceRecord[2];
        	                    for (String[] participant : participants) {
        	                        if (participant[0].equals(memberId)) {
        	                            System.out.printf("%s\t%s %s\t%s\t%s\n", activity[1], participant[1], participant[2], time, date);
        	                            participantsFound = true;
        	                            break;
        	                        }
        	                    }
        	                }
        	            }

        	            if (!participantsFound) {
        	                System.out.println("No participants found for Activity ID " + activityId);
        	            }
        	            System.out.println("-------------------------------------------------");
        	            return;
        	        }
        	    }

        	    if (!activityExists) {
        	        System.out.println("Invalid activity ID!");
        	    }
        	    break;
         default:
             System.out.println("Invalid choice. Redirecting back to the main menu.");
             break;
     }
 } else {
     System.out.println("Invalid input. Redirecting back to the main menu.");
 }
}
    
public static void search() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Search an ID number: ");
    String search = scanner.nextLine();
    
    boolean found = false;
    
    for (String[] participant : participants) {
        if (participant[0].equals(search)) {
            System.out.println("ID number found!");
            System.out.println("Participant Information:");
            System.out.println("Member ID: " + participant[0]);
            System.out.println("First Name: " + participant[1]);
            System.out.println("Last Name: " + participant[2]);
            System.out.println("Gender: " + participant[3]);
            System.out.println("Birthdate: " + participant[4]);
            System.out.println("Course: " + participant[5]);
            System.out.println();
            found = true;
            break;
        }
    }
    
    if (!found) {
        System.out.println("ID number not found.");
    }
}   

//public static void listActivities() {
//	
//	try (BufferedReader reader = new BufferedReader(new FileReader("activity.txt"))) {
//	    String line;
//	    while ((line = reader.readLine()) != null) {
//	        System.out.println(line);
//	    }
//	    reader.close();
//	} catch (IOException e) {
//	    System.out.println("Error occurred while reading data from file: " + e.getMessage());
//	}
	
//	System.out.println("List of all activities");
//	System.out.println("Activity ID\tName\t\t\tDate\t\tHours\tOrganizer");
//	for (String[] activity : activities) {
//		System.out.printf("%s\t\t%s\t%s\t%s\t%s\n", activity[0], activity[1], activity[3], activity[4], activity[5]);
//}
//}
//public static void listParticipants() {
//	
//	try (BufferedReader reader = new BufferedReader(new FileReader("participant.txt"))) {
//	    String line;
//	    while ((line = reader.readLine()) != null) {
//	        System.out.println(line);
//	    }
//	    reader.close();
//	} catch (IOException e) {
//	    System.out.println("Error occurred while reading data from file: " + e.getMessage());
//	}
	
//	System.out.println("List of all participants");
//	System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
//	for (String[] participant : participants) {
//		System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n", participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
//	}
//}

//public static void listParticipantsOfActivity() {
//    int maxAttempts = 3;
//    int attempts = 0;
//
//    while (attempts < maxAttempts) {
//    	int remainingAttempts = maxAttempts - attempts;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("List participants of an activity");
//        System.out.print("Enter activity ID: ");
//        String activityId = scanner.nextLine();
//
//        boolean activityExists = false;
//        for (String[] activity : activities) {
//            if (activity[0].equalsIgnoreCase(activityId)) {
//                activityExists = true;
//                break;
//            }
//        }
//
//        if (!activityExists) {
//            System.out.println("Invalid activity ID!");
//            if (remainingAttempts == 1) {
//                System.out.println("Maximum attempts reached. Unable to record attendance.");
//                return; 
//            }
//            System.out.println("Warning: " + (remainingAttempts - 1) + " attempt(s) left.");
//            System.out.println("-------------------------------------------------");
//            attempts++;
//        } else {
//            System.out.println("Participants of Activity ID " + activityId);
//            System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
//
//            for (String[] attendanceRecord : attendance) {
//                if (attendanceRecord[1].equals(activityId)) {
//                    String memberId = attendanceRecord[2];
//                    for (String[] participant : participants) {
//                        if (participant[0].equals(memberId)) {
//                            System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n", participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
//                            break;
//                        }
//                    }
//                }
//            }
//
//            return;
//        }
//    }
//
//    System.out.println("Maximum attempts reached. Redirecting back to the main menu.");
//}
//public static void listMaleParticipants() {
//	System.out.println("List of male participants");
//	System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
//	for (String[] participant : participants) {
//		if (participant[3].equalsIgnoreCase("Male")) {
//			System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n",participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
//		}
//	}
//}
//public static void listFemaleParticipants() {
//	System.out.println("List of female participants");
//	System.out.println("Member ID\tName\t\tGender\tDate of Birth\t\tCourse");
//	for (String[] participant : participants) {
//		if (participant[3].equalsIgnoreCase("Female")) {
//			System.out.printf("%s\t\t%s %s\t%s\t%s\t%s\n", participant[0], participant[1], participant[2], participant[3], participant[4], participant[5]);
//			}
//		}
//	}

//public static void savedata() {
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PARTICIPANTS_FILE_NAME, false))) {
//        for (String[] participant : participants) {
//            writer.write("Member ID: " + participant[0] + "\n");
//            writer.write("First Name: " + participant[1] + "\n");
//            writer.write("Last Name: " + participant[2] + "\n");
//            writer.write("Gender: " + participant[3] + "\n");
//            writer.write("Birthdate: " + participant[4] + "\n");
//            writer.write("Course: " + participant[5] + "\n");
//            writer.write("\n");
//        }
//
//        System.out.println("Data saved to file 'participants.txt'.");
//    } catch (IOException e) {
//        System.out.println("Error occurred while saving data to file: " + e.getMessage());
//    }
//    
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACTIVITY_FILE_NAME, true))) {
//        for (String[] activity : activities) {
//            writer.write("Activity ID: " + activity[0] + "\n");
//            writer.write("Activity Name: " + activity[1] + "\n");
//            writer.write("Activity Description: " + activity[2] + "\n");
//            writer.write("Activity Date: " + activity[3] + "\n");
//            writer.write("Credit Hours: " + activity[4] + "\n");
//            writer.write("Organizer: " + activity[5] + "\n");
//            writer.write("\n");
//        }
//        System.out.println("Data saved to file 'activities.txt'.");
//    } catch (IOException e) {
//        System.out.println("Error occurred while saving data to file: " + e.getMessage());
//    }
//}
}


