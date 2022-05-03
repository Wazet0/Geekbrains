package classes;

import java.util.ArrayList;

public class TeleDictionary{
    private final ArrayList<String> names = new ArrayList<>();
    private final ArrayList<String> phones = new ArrayList<>();

    public TeleDictionary(ArrayList<String> names, ArrayList<String> phones){
        this.names.addAll(names);
        this.phones.addAll(phones);
    }
    public TeleDictionary(){}

    public void add(String name, String phone){
        names.add(name);
        phones.add(phone);
    }

    public ArrayList<String> get(String name){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < this.names.size(); i++){
            if(names.get(i).equals(name)){
                result.add(phones.get(i));
            }
        }
        return result;
    }
}
