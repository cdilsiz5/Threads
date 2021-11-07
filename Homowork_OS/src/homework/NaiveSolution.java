package homework;

import java.io.*;
import java.nio.charset.Charset;


public class NaiveSolution {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String path=("Assignment1.java input\\_file");
        int [] arr=new int[50];//create array

            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(path),
                            Charset.forName("UTF-8")));
            int c;
            String data="";
            int count=0;
            while ((c= reader.read())!=-1){
                char character=(char)c;
                if(character==' '){
                    //if char is space do nothing
                }
                else if (character==','){
                    if(arr.length==count){
                        arr=expandCapacity(arr);
                        //if size of array not enough capacity will be expanded
                    }
                    arr[count]=Integer.parseInt(data);
                    data="";
                    count++;
                    //if char is "," it save data as  int into list
                }
                else{
                    data+=character;
                }
            }
        arr[count]=Integer.parseInt(data);


        int sum=0;
        for (Integer a:arr
             ) {sum+=a;
            //addition number in the array
        }
        System.out.println(sum);
        long finish = System.currentTimeMillis();
        System.out.println("it worked in : " +(finish-start)+" millisecond");//shows how many millisecond passed while program is worked
    }
    public static int[] expandCapacity(int [] array){
        int [] temp=new int[array.length*2];
        for (int i=0;i<array.length;i++){
            temp[i]=array[i];
        }
        array=temp;
        return array;
    }
}
