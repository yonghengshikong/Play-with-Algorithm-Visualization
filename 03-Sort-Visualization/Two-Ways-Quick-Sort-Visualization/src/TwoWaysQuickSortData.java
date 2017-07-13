import java.util.Arrays;
import java.util.Random;


public class TwoWaysQuickSortData {

    private int N;

    public int[] numbers;
    public int l, r;
    public boolean[] fixedPivots;
    public int curPivot;
    public int curElement;

    // 生成N个[0,randomBound)之间的随机数；nearlyOrdered控制随机数是否近乎有序
    public TwoWaysQuickSortData(int N, int randomBound, boolean nearlyOrdered){
        this.N = N;

        numbers = new int[N];
        fixedPivots = new boolean[N];

        Random rand = new Random();
        for( int i = 0 ; i < N ; i ++) {
            numbers[i] = rand.nextInt(randomBound) + 1;
            fixedPivots[i] = false;
        }

        if(nearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.02*N);
            for(int i = 0 ; i < swapTime; i ++){
                int a = rand.nextInt(N);
                int b = rand.nextInt(N);
                swap(a, b);
            }
        }
    }

    // 生成N个[lBound,rBound]之间的随机数
    public TwoWaysQuickSortData(int N, int lBound, int rBound){
        this.N = N;

        numbers = new int[N];

        Random rand = new Random();
        for( int i = 0 ; i < N ; i ++)
            numbers[i] = rand.nextInt(rBound-lBound+1) + lBound;
    }

    public int N(){
        return N;
    }

    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Selection Sort Data.");

        return numbers[index];
    }

    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}