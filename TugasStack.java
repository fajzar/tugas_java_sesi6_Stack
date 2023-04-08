
import java.util.Scanner;


public class TugasStack {
    private String[] playlist;
    private int top;
    private int size;
    
    public TugasStack(int max_data){
        playlist = new String [max_data];
        size = max_data;
        top = -1;
    }
    public void push(String lagu){
        if (top == size -1){
            System.out.println("playlist penuh !");
        }
        else{
            top++;
            playlist[top]=lagu;
            System.out.println(lagu + " ditambahkan ke playlist");
        }
    }
    public void pop (){
        if (top == -1){
            System.out.println("playlist kosong !");
        }
        else{
            String lagu = playlist[top];
            top--;
            System.out.println(lagu + " dihapus dari playlist");
        }
    }
    public void remove (int index){
        if (index < 0 || index > top){
            System.out.println(" indeks tidak valid !");
            
        }
        else{
            String lagu = playlist[index];
            for (int i = index; i<top; i++){
                playlist[i]=playlist[i+1];
                
            }
            top--;
            System.out.println(lagu + " dihapus dari playlist");
        }
    }
    public void insert(int index, String lagu){
        if (top==size -1){
            System.out.println("playlist penuh !");
            
        }
        else if(index < 0 || index > top){
            System.out.println("indeks tidak valid !");
            
        }
        else{
            for(int i=top; i >= index; i--){
                playlist[i+1]=playlist[i];
            }
            top++;
            playlist[index]=lagu;
            System.out.println(lagu + " ditambahkan ke playlist");
        }
    }
    public void removeAll(){
        top = -1;
        System.out.println("playlist telah dihapus");
    }
    public void display(){
        if(top == -1){
            System.out.println("playlist kosong !");
        }
        else{
            System.out.println("daftar lagu :");
            for (int i=0; i<=top; i++){
                System.out.println(i+1 + ". " + playlist[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("masukan kapasitas playlist :");
        int max_data = scanner.nextInt();
        TugasStack tugasStack = new TugasStack(max_data);
        
        int pilih = 0;
        while (pilih != 99){
            System.out.println("\n1. tampilkan data playlist");
            System.out.println("2. tambah data playilst");
            System.out.println("3. hapus data playlist");
            System.out.println("4. tambah data playlist di urutan tertentu");
            System.out.println("5. hapus data playlist di urutan tertentu");
            System.out.println("6. hapus semua playlist");
            System.out.println("99. keluar");
            System.out.print("masukan pilihan anda :");
            pilih = scanner.nextInt();
            
            switch (pilih){
                case 1:
                    tugasStack.display();
                    break;
                case 2:
                    System.out.print("masukan judul lagu :");
                    scanner.nextLine();
                    String lagu = scanner.nextLine();
                    tugasStack.push(lagu);
                    break;
                case 3:
                    tugasStack.pop();
                    break;
                case 4:
                    System.out.println("masukan indeks :");
                    int index = scanner.nextInt();
                    System.out.println("masukan judul lagu :");
                    scanner.nextLine();
                    lagu = scanner.nextLine();
                    tugasStack.insert(index -1, lagu);
                    break;
                case 5:
                    System.out.println("masukan indeks :");
                    index = scanner.nextInt();
                    tugasStack.remove(index - 1);
                    break;
                case 6:
                    tugasStack.removeAll();
                    break;
                case 99 :
                    System.out.println("terima kasih :)");
                    break;
                default:
                    System.out.println("pilihan tidak ada !");
            }
        }
        scanner.close();
    }
}

//nama : fajar sidik
//kelas : TI22M
//NIM : 20220040012
//tugas : Stack Sesi 6