import java.util.ArrayList;

abstract class Rute{
    Labyrint labyrint;
    protected Rute[] naboer = new Rute[4];
    protected int radNummer, kolonneNummer, nrBesokt;
    static int teller = 1;
    boolean besokt = false;

    Rute(int radNummer, int kolonneNummer, Labyrint labyrint){
        this.radNummer = radNummer;
        this.kolonneNummer = kolonneNummer;
        this.labyrint = labyrint;
    }

    String hentKoordinater(){
        return "("+radNummer+","+kolonneNummer+")";
    }
    
    void settNaboer(Rute nord, Rute syd, Rute vest, Rute oest){
        naboer[0] = nord; 
        naboer[1] = syd; 
        naboer[2] = vest; 
        naboer[3] = oest;
    }

    abstract public void finn(Rute fra, ArrayList <Tuppel> sti);
}

class HvitRute extends Rute{
    HvitRute(int radNummer, int kolonneNummer, Labyrint labyrint){
        super(radNummer, kolonneNummer, labyrint);
    }

    @Override 
    public void finn(Rute fra, ArrayList <Tuppel> sti){
        besokt = true;
        nrBesokt = teller++;
        
        ArrayList <Tuppel> nySti = new ArrayList<>(sti);
        nySti.add(new Tuppel(radNummer, kolonneNummer));

        for (Rute retning: naboer){
            if (retning != fra && retning.besokt == false){
                retning.finn(this, nySti);
            }
        }
    }

    @Override
    public String toString(){
        if (nrBesokt != 0) return String.format("%5s", nrBesokt);
        else return String.format("%5s", ".");
    }
}

class SortRute extends Rute{
    SortRute(int radNummer, int kolonneNummer, Labyrint labyrint){
        super(radNummer, kolonneNummer, labyrint);
    }

    @Override 
    public void finn(Rute fra, ArrayList <Tuppel> sti){
        return;
    }

    @Override 
    public String toString(){
        return String.format("%5s", "#");
    }
}

class Aapning extends HvitRute{
    Aapning(int radNummer, int kolonneNummer, Labyrint labyrint){
        super(radNummer, kolonneNummer, labyrint);
    }

    @Override
    public void finn(Rute fra, ArrayList <Tuppel> sti){
        nrBesokt = teller++;

        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
        nySti.add(new Tuppel(radNummer, kolonneNummer));
        labyrint.leggTilLoesning(nySti);
        
        System.out.println(hentKoordinater());
        return;
    }
}