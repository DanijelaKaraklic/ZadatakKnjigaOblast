package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "oblast")
public class Oblast {
    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_POCETNA_STRANA = "pocetna_strana";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false)
    private String naziv;
    @DatabaseField(columnName = POLJE_POCETNA_STRANA,canBeNull = false)
    private int pocetnaStrana;
    @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = true)
    private Knjiga knjiga;

    public Oblast() {
    }

    public Oblast(String naziv, int pocetnaStrana) {
        this.naziv = naziv;
        this.pocetnaStrana = pocetnaStrana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPocetnaStrana() {
        return pocetnaStrana;
    }

    public void setPocetnaStrana(int pocetnaStrana) {
        this.pocetnaStrana = pocetnaStrana;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return "Oblast{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", pocetnaStrana=" + pocetnaStrana +
                '}';
    }
}
2.1.2 ZADATAK KLASA OBLAST
        U paketu model napraviti novu klasu Oblast. Za ovu klasu definisati slede´ce atribute:
        a) id koji je tipa int
        b) naziv koji je tipa String
        c) pocetnaStrana koji je tipa int
        Svi atributi treba da imaju modifikator pristupa postavljen na private. Za klasu Oblast treba
        dodati slede´ce statiˇcke atribute i njihove vrednosti:
        a) POLJE_NAZIV vrednost je: "naziv"
        b) POLJE_POCETNA_STRANA vrednost je: "pocetna_strana"
        Za klasu Oblast dodati odgovaraju´cu anotaciju da u bazi odgovara tabeli "oblast". Za atribute
        klase Oblast, osim statiˇckih atributa, dodati odgovaraju´ce anotacije da bi nazivi kolona odgovarali
        vrednostima statiˇckih atributa i da bi vrednosti atributa klase Oblast morale biti unete
        prilikom upisa u bazu. Klasi Oblast bi trebalo da se automatski generiše primarni kljuˇc.
        Jedna oblast odgovara taˇcno jednoj knjizi. U klasi Oblast ubaciti odgovaraju´ci atribut i anotaciju
        atributa kako bi se predstavio jediniˇcni kraj veze izme ¯ du Knjiga i Oblast klasa.
        Za klasu Oblast napisati i konstruktor bez parametara i konstruktor koji oˇcekuje parametre
        naziv i pocetnaStrana. Za odgovaraju´ce atribute dodati i get i set metode. Za statiˇcke atribute
        ne treba da se dodaju get i setmetode.
        Redefinisati toStringmetodu, tako da prikazuje vrednosti atributa id, naziv i pocetnaStrana.
        Implementiranu funkcionalnost komitovati u git repozitoriju