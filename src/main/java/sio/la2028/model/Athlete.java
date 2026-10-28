/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.la2028.model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zakina
 */
public class Athlete {
    
    private int id;
    private String nom ;
    private Pays pays ;
    private LocalDateTime dataNaissance;
    private String prenom;
    private List<EpreuveAthlete> lesEpreuveAthletes;

    public Athlete() {
    }

    public Athlete(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Athlete(int id, String nom, String prenom, Pays pays, LocalDateTime dateNaissance, List<EpreuveAthlete> lesEpreuveAthletes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.dataNaissance = dateNaissance;
        this.lesEpreuveAthletes = lesEpreuveAthletes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public LocalDateTime getDataNaissance() {
        return dataNaissance;
    }

    public void setDataNaissance(LocalDateTime dataNaissance) {
        this.dataNaissance = dataNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<EpreuveAthlete> getLesEpreuveAthletes() {
        return lesEpreuveAthletes;
    }

    public void setLesEpreuveAthletes(List<EpreuveAthlete> lesEpreuveAthletes) {
        this.lesEpreuveAthletes = lesEpreuveAthletes;
    }

    public void addEpreuveAthlete(EpreuveAthlete ea){

        if (lesEpreuveAthletes == null){
            lesEpreuveAthletes = new ArrayList<EpreuveAthlete>();
        }
        lesEpreuveAthletes.add(ea);
        ea.setAthlete(this);
    }
}
