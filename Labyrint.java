import java.util.*;
import java.io.*;

class Labyrint{
    ArrayList <ArrayList <Tuppel>> loesninger = new ArrayList<>();
    private int antRader, antKolonner;
    Rute[][] rutenett;

    public Labyrint(String filnavn){
        filLeser(filnavn);
    }

    public int hentAntRader(){
        return antRader;
    }

    public int hentAntKolonner(){
        return antKolonner;
    }

    public int hentAntLoesninger(){
        return loesninger.size();
    }

    public Rute hentRute(int rad, int kolonne){
        return rutenett[rad][kolonne];
    }

    void leggTilLoesning(ArrayList <Tuppel> sti){
        loesninger.add(sti);
    }

    private void filLeser(String filnavn){
        Scanner sc;
        try{
            sc = new Scanner(new File(filnavn));
            String[] inf = sc.nextLine().split(" ");

            antRader = Integer.parseInt(inf[0]);
            antKolonner = Integer.parseInt(inf[1]);
            rutenett = new Rute[antRader][antKolonner];

            int rad = 0;
            while (sc.hasNextLine()){
                String[] linje = sc.nextLine().split("");
                for (int kolonne = 0; kolonne < antKolonner; kolonne++){
                    Rute rute;
                    if ((rad == 0 || rad == antRader-1 || kolonne == 0 || kolonne == antKolonner-1) 
                                        && linje[kolonne].equals(".")){
                        rute = new Aapning(rad, kolonne, this);
                    } else if (linje[kolonne].equals("#")){
                        rute = new SortRute(rad, kolonne, this);
                    } else {
                        rute = new HvitRute(rad, kolonne, this);
                    }
                    rutenett[rad][kolonne] = rute;
                }
                rad++;
            }
            sc.close();
        } catch (FileNotFoundException fnfe){
            System.err.println(fnfe);
            System.exit(-1);

        } catch (IndexOutOfBoundsException oobe){
            System.err.println(oobe);
            System.exit(-1);

        } catch (NumberFormatException nfe){
            System.err.println(nfe);
            System.exit(-1);
        }
         
        for (int rad = 0; rad < antRader; rad++){
            for (int kolonne = 0; kolonne < antKolonner; kolonne++){
                Rute nord, syd, vest, oest;
                try {
                    nord = rutenett[rad-1][kolonne];
                } catch (IndexOutOfBoundsException errN){
                    nord = null;
                } try {
                    syd = rutenett[rad+1][kolonne];
                } catch (IndexOutOfBoundsException errS){
                    syd = null;
                } try {
                    vest = rutenett[rad][kolonne-1];
                } catch (IndexOutOfBoundsException errV){
                    vest = null;
                } try {
                    oest = rutenett[rad][kolonne+1];
                } catch (IndexOutOfBoundsException errO){
                    oest = null;
                }
                rutenett[rad][kolonne].settNaboer(nord, syd, vest, oest);
            }
        }
    }

    public void finnUtveiFra(int rad, int kol){
        loesninger.clear();
        rutenett[rad][kol].finn(null, new ArrayList<Tuppel>());
    }

    void printLoesninger(){
        int i = 1;
        for (ArrayList <Tuppel> sti: loesninger){
            System.out.println("Loesning nr "+i+":");
            for (Tuppel koordinat: sti){
                System.out.print(koordinat+" ");
            }
            System.out.println("\n");
            i++;
        }
    }

    ArrayList <Tuppel> kortesteLoesning(){
        ArrayList <Tuppel> kortesteSti = loesninger.get(0);
        for (ArrayList <Tuppel> sti: loesninger){
            if (sti.size() < kortesteSti.size()){
                kortesteSti = sti;
            }
        }
        return kortesteSti;
    }

    @Override
    public String toString(){
        String labyrint = "";
        for (int rad = 0; rad < antRader; rad++){
            for (int kolonne = 0; kolonne < antKolonner; kolonne++){
                labyrint += rutenett[rad][kolonne];
            }
            labyrint += "\n";
        }
        return labyrint;
    }
}

