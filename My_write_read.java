package JAVA_OOP.seminar1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class My_write_read {
    public static void my_write(ArrayList<Human> humans) throws IOException {
        FileWriter f_w = new FileWriter("humans.txt");
        for (Human item: humans) {
            f_w.append(item.getId()+"\n");
            f_w.append(item.getFirst_name()+"\n");
            f_w.append(item.getLast_name()+"\n");
            f_w.append(item.getbirth_year()+"\n");
            if (item.getMan()) f_w.append("1\n");
            else f_w.append("0\n");
            f_w.append(item.getId_father()+"\n");
            f_w.append(item.getId_mother()+"\n");
            f_w.append(item.getId_married()+"\n");}
        f_w.close();}

    public static void my_read(ArrayList<Human> humans) throws IOException {
        ArrayList<String> log_list = new ArrayList<>();
        BufferedReader f_r = new BufferedReader(new FileReader("humans.txt"));
        String line;
        while ((line=f_r.readLine())!=null) log_list.add(line); f_r.close();
    
        for (int i = 0; i < log_list.size(); i++) {
            Human human = new Human();
            human.setId(Integer.parseInt(log_list.get(i))); 
            human.setFirst_name(log_list.get(++i));;
            human.setLast_name(log_list.get(++i));
            human.setBirth_year(Integer.parseInt(log_list.get(++i)));
            if (log_list.get(++i).equals("1")) human.setMan(true);
            else human.setMan(false);
            human.setId_father(Integer.parseInt(log_list.get(++i)));
            human.setId_mother(Integer.parseInt(log_list.get(++i)));
            human.setId_married(Integer.parseInt(log_list.get(++i)));
            humans.add(human);}}
    

    
}
