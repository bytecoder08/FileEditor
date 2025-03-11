package mypkg.fileeditor;

import java.io.*;
import java.lang.*;

public class FileEditor {
    File my_folder;
    File [] files_list;
    String [] old_name;
    String [] new_name;
    String [] name;
    String [] extension;

    // list all  the files in target directory
    public String listFiles(String loc, int i_do) {
        my_folder = new File(loc);
        files_list = my_folder.listFiles();
        old_name = new String[files_list.length];
        name = new String[old_name.length];
        extension = new String[old_name.length];
        //get all file's names
        for (int i = 0; i < files_list.length; i++) {
            if (files_list[i].isFile()) {
                old_name[i] = files_list[i].getName();
            }
            if (i_do == 3 || i_do == 4) {
                String[] tok = old_name[i].split("\\.");
                name[i] = tok[0];
                extension[i] = tok[1];
            }
        }
        //print all file's names
        System.out.println("List of your files:-");
        String oldName =new String();
        int k=1;
        for (int i = 0; i < files_list.length; i++) {
            System.out.println(old_name[i]);
            oldName+=k+". "+old_name[i]+"\n";
            k++;
        }
        return(oldName);
    }

    // do the assigned task
    public String doTask(String valueGot, int i_do) {
        
        new_name = new String[old_name.length];
        String newName= new String();
        int k=1;
        switch (i_do) {
            case 1 -> {
                // remove word from name of files
                System.out.println("Enter the word or words you want to remove from name:- ");
                String remove = valueGot;
                for (int i = 0; i < old_name.length; i++) {
                    new_name[i] = old_name[i].replaceAll(remove, "");
                    new_name[i] = new_name[i].trim();
                    if (i == 0) {
                        System.out.println("Generating new name for files:- ");
                    }
                    System.out.println(new_name[i]);
                    newName+=k+". "+new_name[i]+"\n";
                    k++;
                }
            }
            case 2 -> {
                // adds words to the start of name of files
                System.out.println("Enter the word or words you want to add to the start of name:- ");
                String add = valueGot + " ";
                for (int i = 0; i < old_name.length; i++) {
                    new_name[i] = add + old_name[i];
                    new_name[i] = new_name[i].trim();
                    if (i == 0) {
                        System.out.println("Generating new name for files:- ");
                    }
                    System.out.println(new_name[i]);
                    newName+=k+". "+new_name[i]+"\n";
                    k++;
                }
            }
            case 3 -> {
                // change the whole name of files
                System.out.println("Enter the name you want to give:- ");
                String add_name = valueGot;
                int j = 1;
                for (int i = 0; i < old_name.length; i++) {
                    new_name[i] = add_name + "(" + j + ")" + "." + extension[i];
                    if (i == 0) {
                        System.out.println("Generating new name for files:- ");
                    }
                    System.out.println(new_name[i]);
                    newName+=k+". "+new_name[i]+"\n";
                    j++;
                    k++;
                }
            }
            case 4 -> {
                // changes extension of files
                System.out.println("Enter the extension you want to give with '.' example-'.jpg':- ");
                String add_extension = valueGot;
                for (int i = 0; i < old_name.length; i++) {
                    new_name[i] = name[i] + add_extension;
                    if (i == 0) {
                        System.out.println("Generating new name for files:- ");
                    }
                    System.out.println(new_name[i]);
                    newName+=k+". "+new_name[i]+"\n";
                    k++;
                }
            }
            case 0 -> {
                System.out.println("Please choose a task:-");
            }
            default -> System.out.println("Please choose a task:-");
        }
        return(newName);
    }

    // it renames all files
    public int doRename(String loc){
        //renames all files
        boolean flag;
        for (int i=0;i<old_name.length;i++) {
            File file = new File(loc+"\\"+old_name[i]);
            File rename = new File(loc+"\\"+new_name[i]);
            flag = file.renameTo(rename);
            if (flag) {
                System.out.println("File "+ i +" Successfully Renamed !");
            }
            else {
                System.out.println(">>>>>> Rename Operation Failed for "+ i +"th file!");
            }
        }
        return 1;
    }
}