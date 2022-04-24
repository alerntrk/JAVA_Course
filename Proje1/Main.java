import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{ 
    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in); 
        int selection;
        String stringselection; 
        String inputtoconvert; 
        Clubs club=new Clubs();
        University marmara = new University(); 
        ArrayList<Student> students = new ArrayList<Student>(); 
        ArrayList<Employee> Employee=new ArrayList<Employee>();
        ArrayList<Academician> Academician=new ArrayList<Academician>();
        mainmenu: // label of main menu
        while(true) { // The while loop that goes until CLOSE PROGRAM is entered.
            clearscreen();
            System.out.println("Welcome to the University Management System ...");
            System.out.println("1- UNIVERSITY\n2- STUDENTS\n3- EMPLOYEE\n4- ACADEMICIANS\n5- CLUBS\n6- CLOSE PROGRAM");
            try { // To prevent errors in the program in case of wrong input.
                inputtoconvert = input.next();
                selection = Integer.parseInt(inputtoconvert);
            } catch (Exception e) {
                System.out.println("Wrong input try again...");
                continue;
            }
            if (selection == 1) {
                clearscreen();
                marmara.showInfo();
                System.out.println("Press 0 to see menu");
                try {
                    inputtoconvert = input.next();
                    input.nextLine();
                    selection = Integer.parseInt(inputtoconvert);
                    if (selection == 0) {
                        continue;
                    } else {
                        System.out.println("Wrong entrance please enter 0");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input try again...");
                }
            } else if (selection == 2) {
                clearscreen();
                System.out.println("1- New Student\n2- Student info\n3- Show all Students\n4- Back to Menu\n");
                selection = input.nextInt();
                if (selection == 1) {
                    int id;
                    String name;
                    String surname;
                    int age;
                    char gender; 
                    String contactNumber;
                    String contactEmail;
                    String position;
                    String department;
                    clearscreen();
                    do {
                        try {
                            while(true){ 
                                System.out.println("ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                id = Integer.parseInt(inputtoconvert);
                                if(idcontrol(id, students, Employee) == 1){
                                    System.out.println("This ID already added...");
                                    continue;
                                }
                                else{
                                    break;
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while(true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Enter the number of position: ");
                            String [] positions = {"Grad Student","Host Grad Student","Undergrad Student"};
                            System.out.println("1- "+ positions[0]+"\n2- "+positions[1]+"\n3- "+positions[2]);
                            selection = input.nextInt(); input.nextLine();
                            switch (selection){
                                case 1:
                                    position = positions[0];
                                    break;
                                case 2:
                                    position = positions[1];
                                    break;
                                case 3:
                                    position = positions[2];
                                    break;
                                default:
                                    position = "";
                                    break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Enter the number of department: ");
                            String [] departments = {"CSE","EEE","IE","ME","CE"};
                            System.out.println("1- "+ departments[0]+"\n2- "+departments[1]+"\n3- "+departments[2]+"\n4- "+departments[3]+"\n5- "+departments[4]);
                            selection = input.nextInt(); input.nextLine();
                            switch (selection){
                                case 1:
                                    department = departments[0];
                                    break;
                                case 2:
                                    department = departments[1];
                                    break;
                                case 3:
                                    department = departments[2];
                                    break;
                                case 4:
                                    department = departments[3];
                                    break;
                                case 5:
                                    department = departments[4];
                                    break;
                                default:
                                    department = "";
                                    break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    Student newstudent = new Student(id, name, surname, age, gender, contactNumber, contactEmail, position,department);
                    students.add(newstudent);
                    University.numberofstudents++; 
                } else if (selection == 2) {
                    try {
                        int idOfstudent;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the student ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfstudent = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Student d : students) {
                            if (d.id == idOfstudent) {
                                System.out.println("-----------------------------------------------");
                                d.show();
                               
                                System.out.println("-----------------------------------------------");
           
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that student...");
                        }
                        System.out.println("Press 0 to see menu...");
                        selection = input.nextInt(); input.nextLine();
                        if(selection == 0){
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 3) {
                    clearscreen();
                    System.out.println("Students:");
                    Collections.sort(students);
                    for (Student d : students) {
                        System.out.println("-----------------------");
                        d.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove student.");
                        inputtoconvert = input.next(); input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if (selection == 0) {
                            continue;
                        }
                        else if(selection == 1){
                            try{
                                System.out.println("Student ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                selection = Integer.parseInt(inputtoconvert);
                                Student toRemoved=new Student(); // The Student that will be removed.
                                for(Student d: students){
                                    if(d.getID() == selection){ 
                                        toRemoved=d;
                                        University.numberofstudents--;  
                                        break;
                                    }
                                }
                              
                                students.remove(toRemoved);
                                System.out.println("Press any button to see menu"); 
                                input.nextLine();
                            }catch(Exception e){
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 4) {
                    continue;
                } else {
                    System.out.println("Wrong entrance!!!");
               }
                
                
                
                
            } 
            
            
            
            
            
            else if (selection == 3) {
                clearscreen();
                System.out.println("1- New Employee\n2- Employee info\n3- Show all Employee\n4- Back to Menu"); 
                selection = input.nextInt(); input.nextLine(); 
                boolean checkStuList = students.isEmpty(); // If there is no Student in School, Employee cannot be added.
                if (selection == 1) {
                    int employeeId;
                    String name;
                    String surname;
                 
                    int age;
                    char gender;  
                    String contactNumber;
                    String contactEmail;
              
                    clearscreen();
                    if(checkStuList==true){
                        System.out.println("There is no student in the List so we cannot insert a Employee.");
                        System.out.println("Press any button to see menu.");
                        stringselection = input.nextLine();
                        continue mainmenu; // Goes to the mainmenu label.
                    }
                    do {
                        try {
                            System.out.println("ID: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            employeeId = Integer.parseInt(inputtoconvert);
                            if (idcontrol(employeeId, students, Employee) == 1) {
                                System.out.println("This ID already added...");
                                continue;
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    
                 
                    Employee newEmployee;
                    newEmployee = new Employee(employeeId, name, surname, age, gender, contactNumber, contactEmail);
                    Employee.add(newEmployee);
                    University.numberofEmployee++; // It increases the number of Employee in School using static variable.
                }
            else if (selection == 2) {
                    
                        int idOfEmployee;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the Employee ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfEmployee = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Employee n : Employee) {
                            if (n.id == idOfEmployee) {
                                System.out.println("------------------------------------------------------");
                                n.show();
                                flag = 1;
                                System.out.println("------------------------------------------------------");
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that Employee...");
                        }
                        System.out.println("Press 0 to see menu...");
                        inputtoconvert = input.next(); input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if(selection == 0){ 
                            continue;
                        
                    }
                } else if (selection == 3) {
                    clearscreen();
                    System.out.println("Employee: ");
                    Collections.sort(Employee);
                    for (Employee n : Employee) {
                        System.out.println("-----------------------");
                        n.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove Employee.");
                        inputtoconvert = input.next();
                        input.nextLine();
                        selection = Integer.parseInt(inputtoconvert);
                        if (selection == 0) {
                            continue;
                        }
                        else if(selection == 1){ 
                            clearscreen();
                            Employee toDeleted=new Employee();
                            System.out.println("Enter Employee ID: ");
                            selection = input.nextInt(); input.nextLine();
                            int i;
                            for(i=0; i<Employee.size();i++){
                                if(Employee.get(i).id==selection){
                                    toDeleted=Employee.get(i); // Student to be removed.
                                    break;
                                }
                            }
                            Employee.remove(toDeleted); // Removed from Employee list.
                            University.numberofEmployee--; // It decreases the number of Employee in school using static variable.
                        }
                        
                    } catch (Exception e) {
                    }
                } else if (selection == 4) {
                    continue;
                } else {
                    System.out.println("Wrong entrance!!!");
                }
            }
            
            else if (selection == 4) {
                clearscreen();
                System.out.println("1- New Academician\n2- Academician info\n3- Show all Academician\n4- Back to Menu");
                selection = input.nextInt(); input.nextLine();
                boolean checkDocList=students.isEmpty();
                if (selection == 1) {
                    int id;
                    String name;
                    String surname;
                    String address;
                    int age;
                    int lec;
                    char gender;
                    String contactNumber;
                    String contactEmail;
   
                    clearscreen();
                    if(checkDocList==true){
                        System.out.println("There is no Student in the List so we cannot insert a academician");
                        System.out.println("Press any button to see menu.");
                        stringselection = input.nextLine();
                        continue mainmenu; // Goes to mainmenu label.

                    }
                    do {
                        try {
                            System.out.println("ID: ");
                                inputtoconvert = input.next(); input.nextLine();
                                id = Integer.parseInt(inputtoconvert);
                                break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Name: ");
                            name = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Surname: ");
                            surname = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Address: ");
                            address = input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Age: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            age = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("Number of lectures: ");
                            inputtoconvert = input.next();
                            input.nextLine();
                            lec = Integer.parseInt(inputtoconvert);
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    while (true) {
                        System.out.println("Gender (F/M): ");
                        gender = input.next().charAt(0);
                        if (Character.toUpperCase(gender) == 'F' || Character.toUpperCase(gender) == 'M') {
                            break;
                        } else {
                            System.out.println("Wrong input try again...");
                        }
                    }
                    do {
                        try {
                            System.out.println("Telephone: ");
                            contactNumber = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.println("E-mail: ");
                            contactEmail = input.next();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong input try again...");
                        }
                    } while (true);
          
                    
               
                    Academician academic;
                    academic = new Academician(id, name, surname, address, age, gender, contactNumber, contactEmail,lec);
                    Academician.add(academic); 
                    University.numberofAcademicians++;
                }
                else if (selection == 2) {
                    try {
                        int idOfAcademician;
                        int flag = 0;
                        clearscreen();
                        System.out.println("Enter the Academician ID: ");
                        inputtoconvert = input.next();
                        input.nextLine();
                        idOfAcademician = Integer.parseInt(inputtoconvert);
                        clearscreen();
                        for (Academician p : Academician) {
                            if (idOfAcademician==p.id) {
                                System.out.println("-----------------------------------------------------");
                                p.show();
                                flag = 1;
                                System.out.println("Salary:"+p.getSalary()+" TL");

                                System.out.println("-----------------------------------------------------");
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Could not find that Academician...");
                        }
                        System.out.println("Press 0 to see menu...");
                        selection = input.nextInt(); input.nextLine();
                        if(selection == 0 ){
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input try again...");
                    }
                } else if (selection == 3) {
                    clearscreen();
                    Collections.sort(Academician);
                    System.out.println("Academicians: ");
                    for (Academician p : Academician) {
                        System.out.println("-----------------------");
                        p.showshort();
                    }
                    try {
                        System.out.println("-----------------------");
                        System.out.println("Press 0 to see menu.");
                        System.out.println("Press 1 to remove academician.");
                        stringselection = input.nextLine();
                        if (stringselection.equals("0")) {
                            continue;
                        }
                        else if(stringselection.equals("1")){
                            clearscreen();
                            System.out.println("academician ID: ");
                            stringselection = input.nextLine();
                            for (Academician p : Academician) {
                                if(p.getID() == Integer.parseInt(stringselection)){
                                	Academician.remove(p); 
                                }
                            }
                        }
                    } catch (Exception e) {

                    }
                } else if (selection == 4) {
                    continue;
                }

                else {
                    System.out.println("Wrong entrance!!!");
                }
            }
            
            else if(selection==5){
                clearscreen();
                System.out.println("1- Show all Student Clubs\n2- Back to Menu");
                selection = input.nextInt();input.nextLine();
                if(selection == 1){
                    clearscreen();
                   
                    club.showclub();
                    System.out.println("------------------------");
                    System.out.println("Press 2 to see the information about the related club");
                    System.out.println("Press 1-5 to see the room of the club");
                    selection = input.nextInt();input.nextLine();
                    clearscreen();
                    if(selection==1){ 
                        club.showinfo(1);
                    }
                    else if(selection==2){
                        club.showinfo(2);
                    }
                    else if(selection==3){
                    	club.showinfo(3);
                    }
                    else if(selection==4){
                    	club.showinfo(4);
                    }
                    else if(selection==5){
                    	club.showinfo(5);
                    }
                    else if(selection==0){
                        continue;
                    }
                    else{
                        System.out.println("Wrong input...");
                    }
                    System.out.println("Press any button to see menu.");
                    selection = input.nextInt(); input.nextLine(); 
                }
                else if(selection == 2){
                    continue;
                }
                else {
                    System.out.println("Wrong entrance!!!");
                }
            }
            else if(selection == 6){
                input.close();
                break;
            }
            else{
                continue;
            }
          
        }
    }
    public static void clearscreen(){ // Clears the console screen every time it is called.
        //System.out.print("\033[H\033[2J"); // ANSI ESCAPE CODE
        System.out.flush();
    }
    public static int idcontrol(int id, ArrayList<Student> students, ArrayList<Employee> Employee){
        for(Student d: students){
            if(d.getID() == id){
                return 1;
            }
        }
        for(Employee n: Employee){
            if(n.getID() == id){
                return 1;
            }
        }
        
        return 0;
    }
}

interface IDate // The interface that stores date data.
{
    void setter(int day, int month, int year); 
    int getDay();
    int getMonth();
    int getYear();
    void showDate();
}

interface IPerson // The interface that stores person data.
{
    public void setter(int id, String name, String surname, int age, char gender, String contactNumber, String contactEmail);
    public void getFullname();
    public void getAddress();
    public void getAge();
    public void getGender();
    public void getcontactNumber();
    public void getcontactEmail();
    public void show();
    public void showshort();
    public int getID();
}

class PersonInfo implements IDate,IPerson{ // The class that stores person data.
    protected int id;
    protected String name,surname; 
    protected String address;
    protected int age;
    protected char gender; // F / M
    protected String contactNumber,contactEmail;
    protected int day;
    protected int month;
    protected int year;
    
    @Override
    public void setter(int id, String name, String surname, int age, char gender, String contactNumber,
            String contactEmail) { // Setter method of personal data.
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    @Override
    public void getFullname() { 
        System.out.println("Name: " + name + " Surname: " + surname);
    }

    @Override
    public void getAddress() { 
        System.out.println("Address: " + address);
    }

    @Override
    public void getAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void getGender() {
        System.out.println("Gender: " + gender);
    }

    @Override
    public void getcontactNumber() {
        System.out.println("Telephone Number: " + contactNumber);
    }

    @Override
    public void getcontactEmail() {
        System.out.println("E-mail: " + contactEmail);
    }

    @Override
    public void show() { // Shows all the data.
        System.out.println("ID: " + id);
        System.out.println("Name: " + name + " Surname: " + surname);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Telephone Number: " + contactNumber);
        System.out.println("E-mail: " + contactEmail);

    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setter(int day, int month, int year) { // Setter method of date.
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void showDate() {
        System.out.println("Day: " + day + "Month: " + month + "Year: " + year);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void showshort() { // Shows information shortly.
        System.out.println(id + "- " + name + " " + surname);
    }
}

class Student extends PersonInfo implements Comparable<Student>{ // The class stores Students' info. 
 
    private String position; 
    String department;
    public Student(){  // Empty constructor.

    }
    
    
    public Student(int id, String name, String surname, int age, char gender, String contactNumber,
    String contactEmail, String position,String department){ // Constructor. Notice that it is Overload.
        this.position = position;
        this.department=department;
        super.setter(id, name, surname, age, gender, contactNumber, contactEmail);
    }

    @Override
    public void showshort() { // Shows information shortly.
        System.out.println(id + "- " + position + " " +name + " " + surname);
    }

    public String getPosition(){ // Returns the position of Student in form of a string.
        return position;
    }


    @Override
    public void show() { // Shows information of Student.
        System.out.println("ID: " + id);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.println("Name: " + name + " Surname: " + surname);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Telephone Number: " + contactNumber);
        System.out.println("E-mail: " + contactEmail);
    }

    @Override
    public int compareTo(Student d) { // Compares the ids of two Student objects.
        int compareId = d.id;
        return this.id - compareId;
    }
}

class Employee extends PersonInfo implements Comparable<Employee>{ // The class that stores information of Employee.
    protected Student relatedStudent;
    public Employee(){ // Empty constructor.

    }
    public Employee(int id, String name, String surname, int age, char gender, String contactNumber,
                 String contactEmail){ // Constructor. Notice that it is overload.
        super.setter(id, name, surname, age, gender, contactNumber, contactEmail);
    }

    public void changeDoc(Student newdoc){ // Changes the Student of Employee.
        relatedStudent = newdoc;
    }

    public void showRelatedStudent(){ // Shows the Student that the Employee is related.
        if(relatedStudent.name == null){
            System.out.println("No Student is attached.");
        }
        else{
        System.out.println(relatedStudent.getPosition() + " " + relatedStudent.name + " " + relatedStudent.surname);
        }
    }

    @Override
    public int compareTo(Employee n) { // Compares the ids of two Employee objects.
        int compareId = n.id;
        return this.id - compareId;
    }

}

class Academician extends PersonInfo implements Comparable<Academician>{ 
	protected int numberOfdays;
    protected int numofLec;
    protected Student relatedStudent;
    private double totalPrice=0;
    Academician(int id, String name, String surname, String address, int age, char gender, String contactNumber,
    String contactEmail,int lec){ // Constructor.
    
    	this.numofLec=lec;
        super.setter(id, name, surname, age, gender, contactNumber, contactEmail);
        salaryCalculator();
    }

   
    public void salaryCalculator(){ 
        
        totalPrice = (double)numofLec*99;
    }
    public double getSalary(){ 
        
        return totalPrice;
    }


    @Override 
    public int compareTo(Academician p) { 
        int compareId = p.id;
        return this.id - compareId;
    }
}

abstract class UniversityInfo{ 
    protected String universityname = "MARMARA UNIVERSITY";
    protected String universityaddress = "Maltepe / Istanbul";
    protected int capacityofcafeteria = 6;
    protected String [] departments = {"CSE","EEE","IE","ME","CE"};
   
    public void showInfo(){
    }
}

class University extends UniversityInfo{ 
    static int numberofstudents=0; 
    static int numberofEmployee=0;
    static int numberofAcademicians=0;

   
    @Override
    public void showInfo(){
        System.out.println("-----------------------------------------------");
        System.out.println("Name: " + universityname);
        System.out.println("Address: " + universityaddress);
        System.out.println("Capacity of cafeteria: " + capacityofcafeteria);
        System.out.println("Students: " + numberofstudents);
        System.out.println("Employee: " + numberofEmployee);
        System.out.println("Academicians: " + numberofAcademicians);

        System.out.print("Departments: ");
        for(int i=0;i<departments.length;i++){
            if(i==departments.length-1){
                System.out.print(departments[i]);
            }
            else{
                System.out.print(departments[i] + ", ");
            }
        }
       
        System.out.print("\n");
        System.out.println("-----------------------------------------------");
    }
}

class Clubs{ // The class that stores the information about diseases and their medicines.
    static String[][] club_infos= {{"Kizilay","M1.123"},{"Robotics","M4.234"},{"Yesilay","M5.432"},
    {"Epic","M3,345"},{"Mies","M5.126"}};
    public static void showclub(){ // Shows the all diseases.
        for(int i=0;i<club_infos.length;i++){
            System.out.println((i+1) + "- " +club_infos[i][0]);
        }
    }
    public static void showinfo(int clubnumber){ // Shows the suggested medicine for specific disease.
        clubnumber = clubnumber-1;
        System.out.println(club_infos[clubnumber][0]+" at "+ club_infos[clubnumber][1] + ".");
    }
}
