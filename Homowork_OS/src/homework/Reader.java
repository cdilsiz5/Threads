package homework;

import java.io.*;
import java.nio.charset.Charset;

public class Reader {
    private String path;
    private int [] arr=new int[50];//create array
    private BufferedReader reader;
    private  int count=0;


    public void readFile () throws IOException {
        reader=new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path),
                        Charset.forName("UTF-8")));
        int c;
        String data="";
        while ((c= reader.read())!=-1){
            char character=(char)c;
            if(character==' '){
                //if char is space do nothing
            }else if (character==','){
                if(arr.length==count){
                    arr=expandCapacity(arr);
                    //if size of array not enough capacity will be expanded
                }
                arr[count]=Integer.parseInt(data);
                data="";
                count++;
                //if char is "," it save data as a int on to list
            }else{
                data+=character;
            }
        }
        arr[count]=Integer.parseInt(data);
    }
    public  int[] expandCapacity(int [] array){
        int [] temp=new int[array.length*2];
        for (int i=0;i<array.length;i++){
            temp[i]=array[i];
        }
        array=temp;
        return array;
    }
    public String getPath() {
        return path;
    }

    public int[] getArr() {
        return arr;
    }

    public int getCount() {
        return count;
    }

    public Reader(String path) {
        this.path = path;
    }
}
