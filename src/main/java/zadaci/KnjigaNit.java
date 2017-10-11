package zadaci;

import model.Knjiga;

import java.util.Random;

public class KnjigaNit extends Thread{

    private String imeClana;
    private Knjiga knjiga;
    private int brojac = 0;
   //private boolean trenutnaPrisutnost;

    public KnjigaNit() {
    }

    public KnjigaNit(String imeClana, Knjiga knjiga) {
        this.imeClana = imeClana;
        this.knjiga = knjiga;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public void ispisSinhronizovan(String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }


    private boolean pozajmljena;

    public boolean isPozajmljena() {
        return pozajmljena;
    }

    public void setPozajmljena(boolean pozajmljena) {
        this.pozajmljena = pozajmljena;
    }


    public synchronized void izdajKadJePrisutna(){
        /*do {
            if (this.knjiga.isPrisutna()){
                this.knjiga.setPrisutna(false);
                ispisSinhronizovan("Clan" + this.imeClana + " je pozajmio knjigu " + this.knjiga.getNaslov());

                //trenutnaPrisutnost = false;
                Random random = new Random();
                long vreme = Math.round(random.nextDouble() * 4000 + 1000);
                try {
                    this.sleep(vreme);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.knjiga.setPrisutna(true);
                // trenutnaPrisutnost = true;
                ispisSinhronizovan("Clan" + this.imeClana + " je vratio knjigu " + this.knjiga.getNaslov());
            }
        } while (!this.knjiga.isPrisutna());*/

    }
        @Override
        public synchronized void run() {
            do {
                synchronized(Knjiga.prisutna){
                    if (Knjiga.prisutna){
                        Knjiga.prisutna = false;
                        pozajmljena = true;
                        ispisSinhronizovan("Clan" + this.imeClana + " je pozajmio knjigu " + this.knjiga.getNaslov());
                        Random random = new Random();
                        long vreme = Math.round(random.nextDouble() * 4000 + 1000);
                        try {
                            this.sleep(vreme);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Knjiga.prisutna = true;

                        // trenutnaPrisutnost = true;
                        ispisSinhronizovan("Clan" + this.imeClana + " je vratio knjigu " + this.knjiga.getNaslov());
                    }else{
                        pozajmljena = false;
                        brojac++;
                        if (brojac == 1) {
                            ispisSinhronizovan("Clan" + this.imeClana + " ceka knjigu " + this.knjiga.getNaslov());
                        }
                    }
                }
            } while (!pozajmljena);
           /*ispisSinhronizovan("Clan " + this.imeClana + " trazi knjigu " + this.knjiga.getNaslov());
            //trenutnaPrisutnost = this.knjiga.isPrisutna();
            if(!this.knjiga.isPrisutna()) {
                ispisSinhronizovan("Clan " + this.imeClana + " ceka knjigu " + this.knjiga.getNaslov());
            }
            izdajKadJePrisutna();
            //System.out.println("Clan" + this.imeClana + " ceka da se vrati knjiga " + this.knjiga.getNaslov());*/

        }





}
