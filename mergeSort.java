public class mergeSort{
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2; // equivalent but more relevant than (si+ei)/2
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid+1, ei); // right part

        merge(arr, si, mid, ei);
    }

    //merge method to merge the sorted parts
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //index for first sorted part
        int j = mid + 1; // index for second sorted part
        int k = 0; //index for temporary array

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;

        }
        // for leftover elements in the first sorted part
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        // for leftover elements in the second sorted part
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        // copying temp to original array
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }

    }
    public static void main(String[] args) {
        int arr[] = {3, 6, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}