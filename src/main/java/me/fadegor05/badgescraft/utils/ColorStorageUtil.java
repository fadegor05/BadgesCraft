package me.fadegor05.badgescraft.utils;

import com.google.gson.Gson;
import me.fadegor05.badgescraft.BadgesCraft;
import me.fadegor05.badgescraft.models.Color;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorStorageUtil {
    private static ArrayList<Color> colors = new ArrayList<>();

    public static Color createColor(int r, int g, int b, String name, String id){

        Color color = new Color(r,g,b,name,id);
        colors.add(color);

        saveColors();
        return color;
    }

    public static Color findColor(String id){
        for (Color color : colors){
            if (color.getId().equals(id)){
                return color;
            }
        }

        return null;
    }

    public static ArrayList<Color> getAllColor() { return colors; }

    public static void deleteColor(String id){
        for (Color color : colors){
            if (color.getId().equals(id)){
                colors.remove(color);
                saveColors();
                break;
            }
        }

    }

    public static Color updateColor(String id, Color newColor){
        for (Color color : colors){
            if (color.getId().equals(id)){
                color.setR(newColor.getR());
                color.setG(newColor.getG());
                color.setB(newColor.getB());
                color.setName(newColor.getName());
                color.setId(newColor.getId());
            }
            saveColors();

            return color;
        }

        return null;
    }

    public static void loadColors() {
        Gson gson = new Gson();
        String path = BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/colors.json";
        File file = new File(path);
        if (file.exists()){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
                StringBuilder out = new StringBuilder();
                String str;

                while ((str = in.readLine()) != null) {
                    System.out.println(str);
                    out.append(str);
                }

                Color[] n = gson.fromJson(String.valueOf(out), Color[].class);
                colors = new ArrayList<>(Arrays.asList(n));
                }
            catch (IOException e){
                e.printStackTrace();
            }

        }

    }


    public static void saveColors() {
        try {
            Gson gson = new Gson();
            File file = new File(BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/colors.json");
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));
            try {
                gson.toJson(colors, writer);
                writer.flush();
            } finally {
                writer.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
