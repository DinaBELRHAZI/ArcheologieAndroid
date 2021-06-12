package com.example.archeologiewebservice;


public class France {


    private int id;


    private String Lambert_X;


    private String Lambert_Y;


    private String Region;


    private String Departement;


    private String Commune;


    private String Nom_du_site;


    private String Date_debut;


    private String Date_fin;


    private String Periodes;


    private String Themes;


    private String Type_intervention;


    public France(int id, String lambert_X, String lambert_Y, String region, String departement, String commune, String nom_du_site, String date_debut, String date_fin, String periodes, String themes, String type_intervention) {
        this.id = id;
        Lambert_X = lambert_X;
        Lambert_Y = lambert_Y;
        Region = region;
        Departement = departement;
        Commune = commune;
        Nom_du_site = nom_du_site;
        Date_debut = date_debut;
        Date_fin = date_fin;
        Periodes = periodes;
        Themes = themes;
        Type_intervention = type_intervention;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getLambert_X() {
        return Lambert_X;
    }
    public void setLambert_X(String lambert_X) {
        Lambert_X = lambert_X;
    }


    public String getLambert_Y() {
        return Lambert_Y;
    }
    public void setLambert_Y(String lambert_Y) {
        Lambert_Y = lambert_Y;
    }


    public String getRegion() {
        return Region;
    }
    public void setRegion(String region) {
        Region = region;
    }


    public String getDepartement() {
        return Departement;
    }
    public void setDepartement(String departement) {
        Departement = departement;
    }


    public String getCommune() {
        return Commune;
    }
    public void setCommune(String commune) {
        Commune = commune;
    }


    public String getNom_du_site() {
        return Nom_du_site;
    }
    public void setNom_du_site(String nom_du_site) {
        Nom_du_site = nom_du_site;
    }


    public String getDate_debut() {
        return Date_debut;
    }
    public void setDate_debut(String date_debut) {
        Date_debut = date_debut;
    }


    public String getDate_fin() {
        return Date_fin;
    }
    public void setDate_fin(String date_fin) {
        Date_fin = date_fin;
    }


    public String getPeriodes() {
        return Periodes;
    }
    public void setPeriodes(String periodes) {
        Periodes = periodes;
    }


    public String getThemes() {
        return Themes;
    }
    public void setThemes(String themes) {
        Themes = themes;
    }


    public String getType_intervention() {
        return Type_intervention;
    }
    public void setType_intervention(String type_intervention) {
        Type_intervention = type_intervention;
    }


}
