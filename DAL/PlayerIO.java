package edu.neumont.oop.DAL;

import edu.neumont.oop.Model.Profile;

import java.io.*;
import java.util.ArrayList;

public class PlayerIO {
    private File profileSaveLoc = new File("C:\\CnBS\\profiles.txt");


    public void save(ArrayList<Profile> profiles) throws IOException {
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(profileSaveLoc));

        if(!profileSaveLoc.exists()){
            profileSaveLoc.createNewFile();
        }

        outStream.writeObject(profiles);
        outStream.close();
    }

    public ArrayList<Profile> load()throws IOException, ClassNotFoundException{
        if(!profileSaveLoc.exists()){
            return new ArrayList<>();
        }
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(profileSaveLoc));
        ArrayList<Profile> profileHolder = (ArrayList<Profile>) inStream.readObject();
        inStream.close();
        return profileHolder;
    }
}
