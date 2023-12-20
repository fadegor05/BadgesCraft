package me.fadegor05.badgescraft.utils;

import com.google.gson.Gson;
import me.fadegor05.badgescraft.BadgesCraft;
import me.fadegor05.badgescraft.models.Badge;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class BadgeStorageUtil {
    private static ArrayList<Badge> badges = new ArrayList<>();

    public static Badge createBadge(String name, String id, String color, String template){

        Badge badge = new Badge(name, id, color, template);
        badges.add(badge);

        saveBadges();
        return badge;
    }

    public static Badge findBadge(String id){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                return badge;
            }
        }
        return null;
    }

    public static ArrayList<Badge> getAllBadge() { return badges; }

    public static void deleteBadge(String id){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                badges.remove(badge);
                saveBadges();
                break;
            }
        }
    }

    public static Badge updateBadge(String id, Badge newBadge){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                badge.setColor(newBadge.getColor());
                badge.setTemplate(newBadge.getTemplate());
                badge.setId(badge.getId());
                badge.setName(badge.getName());
                saveBadges();
            }
        }
        return null;
    }

    public static void loadBadges() {
        Gson gson = new Gson();
        String path = BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/badges.json";
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

                Badge[] n = gson.fromJson(String.valueOf(out), Badge[].class);
                badges = new ArrayList<>(Arrays.asList(n));
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public static void saveBadges(){
        try {
            Gson gson = new Gson();
            File file = new File(BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/badges.json");
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));
            try {
                gson.toJson(badges, writer);
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
