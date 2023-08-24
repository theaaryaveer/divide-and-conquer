public class quickSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quicksort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        //last element ---- here, pIdx means pivot index
        int pIdx = partition(arr, si, ei);
        quicksort(arr, si, pIdx-1); //left
        quicksort(arr, pIdx+1, ei); //right
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; //to make space for elements smaller than pivot element

        for(int j=si; j<ei; j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;


            }
        }
        i++;
        //swap
        int temp = pivot;
        arr[ei] = arr[i]; // pivot = arr[i] will be wrong because pivot is a variable and arr[ei] is the index of pivot
        arr[i] = temp;
        return i;

    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quicksort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
