package JAVA_OOP.seminar1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Human implements Serializable{
    private String first_name,last_name;
    private Boolean man;
    private int birth_year,id,id_father,id_mother,id_married;
    private Human father, mother, married;
    private LinkedList<Human> child = new LinkedList<>(); 

    // public Human(int id,String first_name, String last_name, int birth_year,
    // boolean man,int id_father, int id_mother, int id_married) {
    //     this.id = id;
    //     this.first_name = first_name;
    //     this.last_name = last_name;
    //     this.birth_year = birth_year;
    //     this.man = man;
    //     this.id_father = id_father;
    //     this.id_mother = id_mother;
    //     this.id_married = id_married;}
 
    public boolean equals(Human human) {
        boolean test = false;
        if (this.id==human.id) test = true;
        return test;}

    public void find_childrens(ArrayList<Human> list1) {
        for (Human item : list1) item.child.clear();
        for (Human item : list1) {
            if (item.getId_father()>0) getHuman_id(item.getId_father(), list1).child.add(item);
            if (item.getId_mother()>0) getHuman_id(item.getId_mother(), list1).child.add(item);}}

    public void find_parents(ArrayList<Human> list1) {
        for (Human item : list1) {
            if (item.getId_father()>0) item.setFather(getHuman_id(item.getId_father(), list1));
            if (item.getId_mother()>0) item.setMother(getHuman_id(item.getId_mother(), list1));}} 

    public void find_married(ArrayList<Human> list1) {     
        for (Human item : list1)
            if (item.getId_married()!=0) 
                item.setMarried(getHuman_id(item.getId_married(), list1) );}

    public String getFamilyType(Human human) {
        String str1 = "Не является генетическим родственником.";
        int gender;
        if (this.getMan()) {gender = 0;}
        else {gender = 1;}
        String[] type1 = {"Сын","Дочь"};
        String[] type2 = {"Отец","Мать"};
        String[] type3 = {"Брат","Сестра"};
        String[] type4 = {"Дедушка","Бабушка"};
        String[] type5 = {"Внук","Внучка"};
        String[] type6 = {"Племянник","Племянница"};
        String[] type7 = {"Дядя","Тетя"};
        String[] type8 = {"Муж","Жена"};        
        String[] type9 = {"Тесть","Теща"};
        String[] type10 = {"Свекор","Свекровь"};
        String[] type11 = {"Зять","Невестка"};

// тесть-теща-свекор-свекровь
        if (this.child.size()>0&&human.married!=null){
            if (this.child.contains(human.married)) {
                if (human.man) return type9[gender];
                else return type10[gender];}}
// зять-невестка
        if (this.married!=null&&this.married.father!=null&&this.married.mother!=null){
            if (this.married.father.equals(human)||this.married.mother.equals(human))
                return type11[gender];}
// брат-сестра
        if (this.getFather()!=null&&human.getFather()!=null&&
            this.getMother()!=null&&human.getMother()!=null&&
            this.getFather().equals(human.getFather())
            &&this.getMother().equals(human.getMother())) return type3[gender];        
// сын-дочь
        if ((this.father!=null&&this.father.equals(human))||
            (this.mother!=null&&this.mother.equals(human))) return type1[gender];
// внук-внучка
        if (this.father!=null&&this.mother!=null){
            if ((this.father.father!=null&&this.father.father.equals(human))||
                (this.father.mother!=null&&this.father.mother.equals(human))||
                (this.mother.mother!=null&&this.mother.mother.equals(human))||
                (this.mother.father!=null&&this.mother.father.equals(human))) 
                return type5[gender];}
// отец-мать
        if (this.child.size()>0&&this.child.contains(human)) return type2[gender];
// дедушка-бабушка
        if ((this.child.size()>0&&human.father!=null&&human.mother!=null)&&
            (this.child.contains(human.father)||(this.child.contains(human.mother)))) 
            return type4[gender];
// племянник-племянница
        if (this.father!=null&&this.father.father!=null&&
            this.father.mother!=null&&human.father!=null&&human.mother!=null) {
                if (this.father.father.equals(human.father)&&
                this.father.mother.equals(human.mother))
                {return type6[gender]+" по отцовской линии";}}
        if (this.mother!=null&&this.mother.father!=null&&
            this.mother.mother!=null&&human.father!=null&&human.mother!=null) {
                if (this.mother.father.equals(human.father)&&
                this.mother.mother.equals(human.mother))
                {return type6[gender]+" по материнской линии";}}
// дядя-тетя
        if (this.father!=null&&this.mother!=null&&human.father!=null&&
            human.father.father!=null&&human.father.mother!=null){
                if (this.father.equals(human.father.father)&&
                    this.mother.equals(human.father.mother)) 
                    return type7[gender]+" по отцовской линии";}
        if (this.father!=null&&this.mother!=null&&human.mother!=null&&
        human.mother.father!=null&&human.mother.mother!=null){
            if (this.father.equals(human.mother.father)&&
                this.mother.equals(human.mother.mother)) 
                return type7[gender]+" по материнской линии";}
// муж-жена 
        if (this.getMarried()!=null&&this.getMarried().equals(human)) return type8[gender];
        return str1;}
    
    public Human getHuman_id(int id, ArrayList<Human> humans) {
        Human human = new Human();
        for (Human item : humans) {if (item.getId()==id) human = item;}
        return human;}

    @Override
    public java.lang.String toString() 
        {return this.getFirst_name()+" "+this.getLast_name()+" "
        +this.getbirth_year()+"г.р. ( id : "+this.getId()+" )";}

    public void toString_1() {
        System.out.print("\nID : "+this.getId()+" Имя : "+this.getFirst_name()+ " "
        +this.getLast_name()+" Пол : ");
        if (this.getMan()==true) System.out.print("Мужской");
        else System.out.print("Женский");
        System.out.println(" Год рождения : "+this.getbirth_year());
        if (this.getFather()!= null) System.out.println("Отец : "+this.getFather().toString());
        if (this.getMother()!= null) System.out.println("Мать : "+this.getMother().toString());
        if (this.getId_married()!=0){
            if (this.getMan()==true) System.out.println("Жена : "+this.getMarried().toString());
            else System.out.println("Муж : "+this.getMarried().toString());}
        if (this.getChild().size()>0) 
            {System.out.println("Дети : ");
            for (Human child:this.getChild()) {System.out.println(child.toString());}}}  
    
     public Human getMarried() {
        return married;}

    public void setMarried(Human married) {
        this.married = married;}

    public int getId_married() {
        return id_married;}

    public void setId_married(int married) {
        this.id_married = married;}

    public int getId_mother() {
        return id_mother;}
        
    public void setId_mother(int id_mother) {
        this.id_mother = id_mother;}

    public int getId_father() {
        return id_father;}

    public void setId_father(int id_father) {
        this.id_father = id_father;}

    public int getId() {
        return id;}

    public void setId(int id) {
        this.id = id;}                   
    
    public boolean getMan() {
        return man;}

    public void setMan(Boolean man) {
        this.man = man;} 

    public String getFirst_name() {
        return first_name;}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;}

    public String getLast_name() {
        return last_name;}

    public void setLast_name(String last_name) {
        this.last_name = last_name;}

    public int getbirth_year() {
        return birth_year;}

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;}

    public Human getFather() {
        return father;}

    public void setFather(Human father) {
        this.father = father;}

    public Human getMother() {
        return mother;}

    public void setMother(Human mother) {
        this.mother = mother;}

    public LinkedList<Human> getChild() {
        return child;}
        
}
