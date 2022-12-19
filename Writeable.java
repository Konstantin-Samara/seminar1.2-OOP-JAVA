package JAVA_OOP.seminar1;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writeable {
    void new_save(Tree_class my_tree) throws FileNotFoundException, IOException;
    Tree_class new_read() throws FileNotFoundException, IOException, ClassNotFoundException;}
