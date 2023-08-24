public class sortedRotatedArray {
    public static int search(int arr[], int tar, int si, int ei){
        if(si>ei){
            return -1;
        }
        //main work
        int mid = si + (ei-si)/2; // equivalent but more relevant than (si+ei)/2

        //case - Found
        if(arr[mid] == tar){
            return mid;
        }
        //mid on Line 1
        if(arr[si] <= arr[mid]){
            //case: a - Left
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid-1);


            }
            else{
                //case: b - Right
                return search(arr, tar, mid+1, ei);
            }

        }
        //mid on Line 2
        else{
            // case:c - right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return search(arr, tar, mid+1, ei);
            }
            else{
                return search(arr, tar, si, mid-1);
            }

        }

    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0; //output = 4
        int tarIdx = search(arr, target, 0, arr.length);
        System.out.println(tarIdx);

    }
}
