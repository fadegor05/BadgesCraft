package me.fadegor05.badgescraft.utils;

import java.util.ArrayList;
import me.fadegor05.badgescraft.models.Template;

public class TemplateStorageUtil {
    private static ArrayList<Template> templates = new ArrayList<Template>();

    public static Template createTemplate(char symbol, String name, String id){

        Template template = new Template(symbol, name, id);
        templates.add(template);

        return template;

        //TODO: save templates

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
                break;
            }
        }

        //TODO: save templates
    }

    public static Template updateTemplate(String id, Template newTemplate){
        for (Template template : templates) {
            if(template.getId().equals(id)){
                template.setTemplate(newTemplate.getTemplate());
                template.setName(newTemplate.getName());
                template.setId(newTemplate.getId());
                // TODO: save templates


                return template;
            }
        }
        return null;

    }

}
