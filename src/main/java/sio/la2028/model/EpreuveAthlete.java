package sio.la2028.model;

public class EpreuveAthlete {
    private Epreuve epreuve;
    private Athlete athlete;
    private int place;

    public EpreuveAthlete() {
    }

    public EpreuveAthlete(Epreuve epreuve, Athlete athlete, int place) {
        this.epreuve = epreuve;
        this.athlete = athlete;
        this.place = place;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
