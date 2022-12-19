package JAVA_OOP.seminar1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Tree_class implements Serializable{
    private int max_id;
    private ArrayList<Human> humans = new ArrayList<>();
    private Writeable writeable; 

// public Tree_class(int inp_max_id, ArrayList<Human> inp_humans){
//     this.max_id = inp_max_id;
//     this.humans = inp_humans;}

public Tree_class new_read() throws FileNotFoundException, 
                            ClassNotFoundException, IOException { 
    return writeable.new_read();}

public void new_save() throws FileNotFoundException, IOException {
    writeable.new_save(this);}

public void setWriteable(Writeable writeable) {
        this.writeable = writeable;}

public void create_tree() {
    for (Human item : this.getHumans()) item.find_parents(this.getHumans());
    for (Human item : this.getHumans()) item.find_married(this.getHumans());
    for (Human item : this.getHumans()) item.find_childrens(this.getHumans());}

public void add_human() throws FileNotFoundException, IOException {
    Human human = new Human();
    Scanner scan = new Scanner(System.in);
    System.out.println("Создается новый объект с ID "+(this.max_id+1)+" : ");
    human.setId(this.max_id+1);
    System.out.print("Введите имя : ");
    String first_name = scan.nextLine(); human.setFirst_name(first_name);
    System.out.print("Введите фамилию : ");
    String last_name = scan.nextLine(); human.setLast_name(last_name);
    System.out.print("Введите год рождения : ");
    int birth_year = scan.nextInt(); human.setBirth_year(birth_year);
    System.out.print("Введите пол (1-мужской/0-женский): ");
    boolean man = true;
    int m = scan.nextInt(); 
    if (m==1) human.setMan(man);
    else human.setMan(!man);
    System.out.print("Введите ID отца (0 - отсутствует) : ");
    int id_father = scan.nextInt(); human.setId_father(id_father);
    System.out.print("Введите ID матери (0 - отсутствует) : ");
    int id_mother = scan.nextInt(); human.setId_mother(id_mother);
    System.out.print("Введите ID cупруга/супруги (0 - отсутствует) : ");
    int id_married= scan.nextInt(); human.setId_married(id_married);
    this.humans.add(human);
    this.setMax_id(++this.max_id);
    this.create_tree();}

public void getHuman_info_id() {
    Human human = new Human();
    Scanner scan = new Scanner(System.in);
    int id;
    System.out.print("\nВведите ID объекта для получения полной информации : ");
    id = scan.nextInt();
    human = human.getHuman_id(id, this.getHumans());
    System.out.println("\nИсследуется объект : "+human.toString()+"\n");
    for (Human item : this.humans) {
    if (!item.equals(human)&&
    !item.getFamilyType(human).equals("Не является генетическим родственником."))    
        System.out.println(item.getFamilyType(human)+ " : "+item.toString());}}
        
    public ArrayList<Human> getHumans() {
        return humans;}
        
    public void setHumans(ArrayList<Human> humans) {
        this.humans = humans;}
    
    public int getMax_id() {
        return max_id;}
    public void setMax_id(int max_id) {
        this.max_id = max_id;} 

}
