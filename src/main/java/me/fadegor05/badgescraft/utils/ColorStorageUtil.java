package me.fadegor05.badgescraft.utils;

import me.fadegor05.badgescraft.models.Color;

import java.util.ArrayList;

public class ColorStorageUtil {
    private static ArrayList<Color> colors = new ArrayList<>();

    public static Color createColor(int r, int g, int b, String name, String id){

        Color color = new Color(r,g,b,name,id);
        colors.add(color);

        return color;

        // TODO: save colors
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
                // TODO: save colors
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
            // TODO: save colors

            return color;
        }

        return null;
    }
}
