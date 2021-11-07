package homework;

import java.io.IOException;
import java.lang.Thread;
public class ThreadSolution {
    public static void main(String[] args) throws IOException  {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of Cores works : "+cores);
        long start = System.currentTimeMillis();
        String path=("Assignment1.java input\\_file");
        Reader reader=new Reader(path);
        reader.readFile();
        int [] array=reader.getArr();
        int arraySize=array.length;

        int threadMax=1;
        Thread [] threads=new Thread[threadMax];
        int [] sum=new int[threadMax];
        for(int i=0;i<threads.length;i++){
            int part=i;
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadSolution.sum(threadMax,array,part,arraySize,sum);
                }
            });
        }
        for(int i=0;i<threads.length;i++){
            try {
                threads[i].start();
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        int sumOfNumber=0;
        for(int i=0;i<sum.length;i++){
            sumOfNumber+=sum[i];

        }
        System.out.println("Sum : "+sumOfNumber);
        long finish = System.currentTimeMillis();
        System.out.println("it worked in : " +(finish-start)+" millisecond");
    }

    public static  void sum(int threadMax,int array[],int part,int arraySize,int[] sum){
        int threadPart=part++;
         for (int i=threadPart*(arraySize/threadMax);i< (threadPart+1)*(arraySize/threadMax);i++){
            sum[threadPart]+=array[i];
        }
    }
}
