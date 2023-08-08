import java.util.*;
class Oblig6{
    public static void main(String[] args){
        String filnavn;
        Labyrint lab;
        String[] koordinater;
        int rad, kolonne;

        try{
            filnavn = args[0];
            lab = new Labyrint("labyrinter/labyrinter/"+filnavn);

            System.out.println("Slik ser labyrinten ut:");
            System.out.println(lab);

            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1' for a avslutte).");
                String brukerInput = sc.nextLine();

                if (brukerInput.equals("-1")){
                    sc.close();
                    System.exit(-1);
                } else {
                    koordinater = brukerInput.split(" ");
                    rad = Integer.parseInt(koordinater[0]);
                    kolonne = Integer.parseInt(koordinater[1]);
                    
                    if (lab.hentRute(rad, kolonne) instanceof SortRute){
                        System.out.println("Kan ikke gaa langs sorte ruter.");
                    } else if (rad < lab.hentAntRader() && kolonne < lab.hentAntKolonner()){
                        System.out.println("-------------------");
                        System.out.println("Aapninger: ");
                        System.out.println("-------------------");
                        lab.finnUtveiFra(rad, kolonne);
                        System.out.println("-------------------");
                        System.out.println("\n");

                        System.out.println("Her er labyrinten slik du gikk gjennom den:");
                        System.out.println(lab);

                        if (lab.hentAntLoesninger() == 1){
                            System.out.println(lab.hentAntLoesninger()+" loesning funnet.");
                        } else {
                            System.out.println(lab.hentAntLoesninger()+" loesninger funnet.");
                        }
                        //lab.printLoesninger();
                        ArrayList <Tuppel> kortesteSti = lab.kortesteLoesning();
                        System.out.println("Den korteste veien:");
                        for (Tuppel koordinat: kortesteSti){
                            System.out.print(koordinat+" ");
                        }
                        System.out.println("\n");
                    } else {
                        System.out.println("Skriv pa formen: <rad> <kolonne>. Rad < "+lab.hentAntRader()+", kolonne < "+lab.hentAntKolonner());
                    }
                }
            }
        } catch (IndexOutOfBoundsException oobe){
            System.out.println("Angi fil til opplesning, og saa angi et radnummer og kolonnenummer.");
            System.exit(-1);
        } catch (NumberFormatException nfe){
            System.out.println("Ugyldig input. <rad> <kolonne> maa vaere heltall.");
            System.exit(-1);
        }
    }
}