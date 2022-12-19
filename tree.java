package JAVA_OOP.seminar1;
import java.io.IOException;
import java.io.Serializable;
// import java.util.ArrayList;

public class tree implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree_class my_tree = new Tree_class();
        My_menu my_menu = new My_menu();
        int sel = 0;
       
        // ArrayList<Human> humans = new ArrayList<>();
        // My_write_read.my_read(humans);
        // my_tree.setHumans(humans);
        // my_tree.setMax_id(8);
        
        my_tree.setWriteable(new New_write_read());
        my_tree = my_tree.new_read();
        my_tree.create_tree();

        System.out.println("\n\n\nmax ID : "+ my_tree.getMax_id());        
        while (sel!=6) {
        sel = my_menu.main_menu();
        switch (sel) {
            case 1: System.out.println();
                    for (Human item : my_tree.getHumans()) System.out.println(item.toString());
                    break; 
            case 2: System.out.println();
                    for (Human item : my_tree.getHumans()) item.toString_1(); 
                    break;
            case 3: my_menu.h2h_community(my_tree.getHumans());
                    break;
            case 4: my_tree.add_human(); 
                    break;
            case 5: my_tree.getHuman_info_id();
                    break;
            case 6: break;}}

            my_tree.new_save();

        // New_write_read new_write_read = new New_write_read();
        // new_write_read.new_save(my_tree);
}
    
}
