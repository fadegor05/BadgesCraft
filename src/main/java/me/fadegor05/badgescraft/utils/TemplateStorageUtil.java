package me.fadegor05.badgescraft.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import me.fadegor05.badgescraft.BadgesCraft;
import me.fadegor05.badgescraft.models.Template;

public class TemplateStorageUtil {
    private static ArrayList<Template> templates = new ArrayList<Template>();

    public static Template createTemplate(char symbol, String name, String id){

        Template template = new Template(symbol, name, id);
        templates.add(template);

        saveTemplates();
        return template;
    }

    public static Template findTemplate(String id){
        for (Template template : templates){
            if(template.getId().equals(id)){
                return template;
            }
        }

        return null;
    }

    public static ArrayList<Template> getAllTemplate() { return templates; }

    public static void deleteTemplate(String id) {
        for (Template template : templates) {
            if(template.getId().equals(id)){
                templates.remove(template);
                saveTemplates();
                break;
            }
        }
    }

    public static Template updateTemplate(String id, Template newTemplate){
        for (Template template : templates) {
            if(template.getId().equals(id)){
                template.setTemplate(newTemplate.getTemplate());
                template.setName(newTemplate.getName());
                template.setId(newTemplate.getId());
                saveTemplates();


                return template;
            }
        }
        return null;

    }

    public static void loadTemplates() {
        Gson gson = new Gson();
        String path = BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/templates.json";
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

                Template[] n = gson.fromJson(String.valueOf(out), Template[].class);
                templates = new ArrayList<>(Arrays.asList(n));
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public static void saveTemplates(){
        try {
            Gson gson = new Gson();
            File file = new File(BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/templates.json");
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));
            try {
                gson.toJson(templates, writer);
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
