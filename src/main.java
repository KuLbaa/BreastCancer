import java.util.List;

public class main {
    public static void main(String[] args){
        double dokladnosc = 0.99;
        double procentpoprawnych = 0;
        Trainer tr = new Trainer();
        double P = tr.ComputeAndLearn();
        int TP = tr.GetCounterCorrect();
        int FP = tr.GetCounterFaulse();
        int TN = tr.GetCounterFaulseTest();
        int FN = tr.GetCounterCorrectTest();
        while(procentpoprawnych<=dokladnosc){
            P = tr.ComputeAndLearn();
            procentpoprawnych = tr.ReadTestFileAndCompute();
            TP = tr.GetCounterCorrect();
            FP = tr.GetCounterFaulse();
            TN = tr.GetCounterFaulseTest();
            FN = tr.GetCounterCorrectTest();
            System.out.println("Precyzja " + procentpoprawnych);
            System.out.println("Pelnosc " + P);
            System.out.println("F-Miara "+  (2*procentpoprawnych*P)/(procentpoprawnych+P));
        }
        System.out.println(TP +" "+ FP);
        System.out.println(FN+" "+TN);
    }
}
