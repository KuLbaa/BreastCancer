import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private List<Vector> LV = new ArrayList<>(); //Lista vectorow
    private int n;
    public void ReadFile(String namefile){
        try {
            Scanner sc = new Scanner(new File(namefile));
            sc.nextLine();
            while(sc.hasNextLine()){
                String linia = sc.nextLine();
                System.out.println(linia);
                String tab[] = linia.split(",");
                n = tab.length-2;
                Vector v = new Vector(n);
                try {
                    for (int i = 1; i <= n; i++) {

                        int xi = Integer.parseInt(tab[i]);
                        v.insert(i - 1, xi);

                    }
                    v.setwynik(Integer.parseInt(tab[n + 1]));
                    System.out.println(v.toString());
                    LV.add(v);
                }
                catch(Exception e){
                    System.out.println("Odrzucona linia: "+ linia);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Brak pliku");
        }
    }
    public List<Vector> GetV(){
        return LV;
    }
    public int GetN(){
        return n;
    }

}
