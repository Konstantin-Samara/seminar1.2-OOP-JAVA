package JAVA_OOP.seminar1;

import java.util.ArrayList;
import java.util.Scanner;

public class My_menu {
 
    public void h2h_community(ArrayList<Human> humans) {
        Human human = new Human();
        Scanner scan = new Scanner(System.in); 
        int n1 = 1;
        int n2 = 1;  
        while (n1!=0||n2!=0){
            System.out.println();
            for (Human item : humans) System.out.println(item.toString());

            System.out.print("\nВведите ID исследуемого человека (0-exit): ");
            n1 = scan.nextInt();
            if (n1==0) break;
            System.out.print("Введите ID для установления степени родства (0-exit): ");
            n2 = scan.nextInt();
            if (n2==0) break;
            System.out.println("\n"+human.getHuman_id(n1, humans).toString());
            System.out.println(human.getHuman_id(n1, humans).
            getFamilyType(human.getHuman_id(n2, humans))+" для");
            System.out.println(human.getHuman_id(n2, humans).toString());}}

    public int main_menu() {
        Scanner scan = new Scanner(System.in); 
        int sel;
        System.out.println("\n1. Вывести краткий список.");
        System.out.println("2. Вывести подробный список.");
        System.out.println("3. Вывести тип родственной связи между объектами.");
        System.out.println("4. Добавить объект.");
        System.out.println("5. Вывести подробную информацию об объекте по ID.");
        System.out.println("6. Завершить.");
        System.out.print("Выберите пункт меню (1-6) : ");
        sel = scan.nextInt();
        if(sel==6) scan.close();
        return sel;}    
}
