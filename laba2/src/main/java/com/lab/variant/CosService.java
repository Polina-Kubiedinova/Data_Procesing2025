package com.lab.variant;

import com.lab.variant.Cosmetic;
import com.lab.variant.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CosService {
private static final String FILE_PATH = "C:\\polina\\yniver\\Data_Procesing2025\\laba2\\src\\main\\resources\\data.json";
private List<Cosmetic> cos;
public CosService(){
    cos = loadCos();
}
public List<Cosmetic> getAllCos(){
    return cos;
}
public void addCos(Cosmetic cosm) {
    cosm.setId(generateNextId());
    cos.add(cosm);
    saveCos();
}
public boolean updateCos(Cosmetic updateCos){
    for(int i =0;i<cos.size();i++){
        if(cos.get(i).getId()==updateCos.getId()){
            cos.set(i, updateCos);
            saveCos();
            return true;
        }
    }
    return false;
}
public boolean deleteCos(int id){
    boolean removed = cos.removeIf(c -> c.getId()==id);
    if(removed) saveCos();
    return removed;
}

private int generateNextId() {
    int maxId = 0;
    for (Cosmetic c : cos) {
        if (c.getId() > maxId) {
            maxId = c.getId();
        }
    }
    return maxId + 1;
}

private List<Cosmetic> loadCos(){
    try{
        String json = FileUtil.readFromFile(FILE_PATH);
        return new Gson().fromJson(json, new TypeToken<List<Cosmetic>>() {}.getType());
    }catch(IOException e){
        return new ArrayList<>();
    }
}
private void saveCos(){
    try{
        String json = new Gson().toJson(cos);
        FileUtil.writeToFile(FILE_PATH, json);
    } catch (IOException e){
        e.printStackTrace();
    }
}
}
