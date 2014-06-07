import java.io.*;  
public class StreamPipe {
    //メインメソッド
    public static void main(String[] args) throws IOException {
        StreamPipe obj = new StreamPipe(); //コンストラクタを実行
        obj.sortout(obj.getData()); //getDaa()メソッドの結果を使う
    }
    //csvファイルよりデータ読み込みバッファに格納
    Reader getData () throws IOException {
        //文字ストリームFileRraderクラスのインスタンス
        FileReader seiseki = new FileReader("src/seiseki.csv");
        //FileReaderクラスのオブジェクトseisekiをラップ
        BufferedReader bin = new BufferedReader(seiseki);
        
        PipedWriter pipeOut = new PipedWriter();  //バッファに書き込み
        //pipeoutをそのままpipeinの入力に使う
        PipedReader pipeIn = new PipedReader(pipeOut); 
        
        PrintWriter out = new PrintWriter(pipeOut);
        
        String[] arrayLine;     
        String line;    
        //ソースがなくなるまで読み込み
        while((line = bin.readLine()) != null) {
            arrayLine = line.split(",");  //String lineを","で分割
            //文字列を整数に変換
            int s1 = Integer.parseInt(arrayLine[1]); 
            int s2 = Integer.parseInt(arrayLine[2]);
            int s3 = Integer.parseInt(arrayLine[3]);  
                
            int goukei = s1 + s2 + s3;//合計を計算
            
            out.println(line + "," + String.valueOf(goukei)); //成績合計を文字列にして出力
            out.flush();
        }

        bin.close();  
        out.close(); 

        return pipeIn;  //pipeInオブジェクトを返す
    }
    //sortValueメソッド
    void sortout(Reader source) throws IOException {
        //BufferedReaderクラスでPipedReaderクラスのオブジェクトsourceをラップ

        BufferedReader in = new BufferedReader(source);
        String line;
        String[][] seiseki = new String[8][8];
        int s = 0, r=0;
        //パイプからデータがなくなるまで読み込み
        while ((line = in.readLine()) != null) {
            seiseki[s]=line.split(",");
            s++;
       }
       int j=0;
       //成績データを合計でソート
       int m = seiseki.length;  
       for (int i = 0; i < seiseki.length - 1; i++) {
           for (j = seiseki.length - 1; j > i; j--) { 
                int s1 = Integer.parseInt(seiseki[j][m]);
                int s2 = Integer.parseInt(seiseki[j-1][m]);
                if (s1 > s2) {
                    String temp[] = seiseki[j];
                    seiseki[j] = seiseki[j-1];
                    seiseki[j-1] = temp;
                }
           }
        }

        //ソートされた成績データを出力
        System.out.println("番号" + "\t"+ "名前" + "\t\t" + "英語" + "\t" + "数学" + "\t" +
                "国語" + "\t" + "合計");
        for (int k = 0; k < seiseki.length; k++) {
               for (int l = 0; l < seiseki[k].length; l++){
                   System.out.print((String)seiseki[k][l] + "\t");
               }
               System.out.println();
        }
        in.close();  
    }
}