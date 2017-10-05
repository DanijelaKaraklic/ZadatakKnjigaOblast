package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "knjiga")
public class Knjiga {
    public static final String POLJE_NASLOV = "naslov";
    public static final String POLJE_BROJ_STRANA = "brojStrana";
    public static final String POLJE_DATUM_IZDAVANJA = "datumIzdavanja";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NASLOV,canBeNull = false)
    private String naslov;
    @DatabaseField(columnName = POLJE_BROJ_STRANA,canBeNull = false)
    private int brojStrana;
    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA,canBeNull = false)
    private Date datum;
    private boolean prisutna;



    @ForeignCollectionField(foreignFieldName = "knjiga",eager = false,maxEagerLevel = 1)
    ForeignCollection<Oblast> oblasti;

    public ForeignCollection<Oblast> getOblasti() {
        return oblasti;
    }

    public void setOblasti(ForeignCollection<Oblast> oblasti) {
        this.oblasti = oblasti;
    }

    public Knjiga() {
    }

    public Knjiga(String naslov, int brojStrana, Date datum) {
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datum = datum;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public boolean isPrisutna() {
        return prisutna;
    }

    public void setPrisutna(boolean prisutna) {
        this.prisutna = prisutna;
    }


    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", brojStrana=" + brojStrana +
                ", datum=" + datum +
                '}';
    }
}
    