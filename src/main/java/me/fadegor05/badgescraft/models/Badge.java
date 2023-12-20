package me.fadegor05.badgescraft.models;

public class Badge {
    private String name;
    private String id;
    private String color;
    private String template;

    public Badge(String name, String id, String color, String template) {
        this.name = name;
        this.id = id;
        this.color = color;
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
