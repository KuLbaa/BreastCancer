public class Vector {
    private int v[];
    private int wynik;

    public Vector(int n){
        v = new int[n];
    }
    public void insert (int index, int value){
        v[index] = value;
    }
    public void setwynik(int wynik){
        this.wynik = wynik;
    }

    public String toString(){
        String napis = "Vector: ";
        for(int i=0; i<v.length; i++) {
            napis += v[i]+" ";
        }
        napis += wynik;
        return napis;
    }
    public int[] GetTab(){
        return v;
    }
    public int GetWynik(){
        if(wynik == 2)
        return -1;
        else
            return 1;
    }

}
