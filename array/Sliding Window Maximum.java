class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n= arr.length;
      int []ans= new int[n-k+1];
        ArrayDeque<Integer> dq= new ArrayDeque();
        for(int i=0; i<k;i++){
            while(!dq.isEmpty() && arr[i]>= arr[dq.getLast()])
                dq.pollLast();
            dq.addLast(i);
        }
      ans[0]= arr[dq.getFirst()];
      int j=1;
      
         for(int i=k; i<n;i++){
           if(!dq.isEmpty()&& dq.getFirst()<(i-k+1) )
             dq.pollFirst();
             
            while(!dq.isEmpty() && arr[i]>= arr[dq.getLast()])
                dq.pollLast();
            dq.addLast(i);
           ans[j]= arr[dq.getFirst()];
           j++;
        }
        
        return ans;
    }
}
