import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trainer {
    private int dimension;
    private Percepton percepton;
    private List<Vector> LV = new ArrayList<Vector>();
    int countFalse=0;
    int countCorrect=0;
    int counterCorrectTest = 0;
    int counterFalseTest = 0;

    public Trainer() {
        ReadTrainFIle();
        percepton = new Percepton(dimension);

    }

    public void ReadTrainFIle() {
        ReadFile rd = new ReadFile();
        rd.ReadFile("breast-cancer-wisconsin.data");
        LV = rd.GetV();
        System.out.println(LV);
        this.dimension = rd.GetN();
        System.out.println(dimension);

    }

    public double ReadTestFileAndCompute() {
        ReadFile rd = new ReadFile();
        rd.ReadFile("test-file");
        List<Vector> LV = rd.GetV();
        counterCorrectTest = 0;
        counterFalseTest = 0;
        for (int i = 0; i < LV.size(); i++) {
        int d = 0;
        d = LV.get(i).GetWynik();
        int y = percepton.Compute(LV.get(i).GetTab());
        if (y == d) {
            counterCorrectTest++;
        } else {
            counterFalseTest++;
            for (int j = 0; j < LV.get(i).GetTab().length; j++)
                System.out.println((float) LV.get(i).GetTab()[j]);
        }
        if (y == -1) {
            System.out.println("Wynik: " + 2);
        } else
            System.out.println("Wynik: " + 4);
    }


            System.out.println("Prawidlowe: "+counterCorrectTest);
            System.out.println(("Nieprawidlowe: "+counterFalseTest));

            return counterCorrectTest/(double)(counterFalseTest+counterCorrectTest);

        }


    public double ComputeAndLearn(){
        countFalse=0;
        countCorrect=0;
        for(int i=0; i<LV.size(); i++){
            int x[] = LV.get(i).GetTab();
            int d = LV.get(i).GetWynik();
            int y = percepton.Compute(x);
            if(d !=y){
                countFalse++;
            }
            else
                countCorrect++;
            System.out.println(y);
            percepton.Learn(x, d, y);

        }
        return countCorrect/(double)LV.size();

    }
    public int GetCounterCorrect(){
        return countCorrect;
    }
    public int GetCounterFaulse(){
        return countFalse;
    }
    public int GetCounterCorrectTest(){
        return counterCorrectTest;
    }
    public int GetCounterFaulseTest(){
        return counterFalseTest;
    }
}
