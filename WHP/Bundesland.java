package u00_whp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Bundesland {
    private static final List<Bundesland> BUNDESLAENDER = Arrays.asList(
            new Bundesland("Oberösterreich (OÖ)","Linz",1482095,11980),
            new Bundesland("Niederösterreich (NÖ)","St. Pölten",1677542,19186),
            new Bundesland("Kärnten (Ktn.)","Klagenfurt am Wörthersee",560939,9538),
            new Bundesland("Steiermark (Stmk.)","Graz",1243052,16401),
            new Bundesland("Salzburg (Sbg.)","Salzburg",555221,7156),
            new Bundesland("Tirol (T)","Innsbruck",754705,12640),
            new Bundesland("Burgenland (Bgld.)","Eisenstadt",293433,3962),
            new Bundesland("Vorarlberg (Vbg.)","Bregenz",397094,2601),
            new Bundesland("Wien (W)","–",1897491,415)
            );
    private String name;
    private String landeshauptstadt;
    private int einwohner;
    private int flaeche;
    public Bundesland(String name, String landeshauptstadt, int einwohner, int flaeche) {
        this.name = name;
        this.landeshauptstadt = landeshauptstadt;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
    }

    public static void getInfo(){
        List<String> kleineStaedte = new ArrayList<>();

        List<Integer> namenLaenge = new ArrayList<>();

        BUNDESLAENDER.forEach((Bundesland b)->{if(b.einwohner<500000)kleineStaedte.add(b.name);});




        System.out.println(Arrays.toString(kleineStaedte.toArray()));

        System.out.println(BUNDESLAENDER.stream().max((Bundesland b1, Bundesland b2)->{return (int)(b1.flaeche-b2.flaeche);}).get().flaeche);

        BUNDESLAENDER.forEach((Bundesland b)->{namenLaenge.add(b.landeshauptstadt.length());});


        System.out.println(Arrays.toString(namenLaenge.toArray()));
    }
}
