//Problem 1
// TC O(n)
//SC O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
      if(intervals==null || intervals.length==0)
      {
        return 0;
      }  
      Arrays.sort(intervals,(a,b)->a[0]-b[0]);
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      for(int interval[]:intervals)
      {
        if(pq.size()==0)
        {
            pq.add(interval[1]);
        }
        else{
            if(pq.peek()>interval[0])
            {
                pq.add(interval[1]);// new room created
            }
            else{// old room has been used
                pq.remove();
                pq.add(interval[1]);
            }
        }
      }
      

      return pq.size();
    }
}
//Problem 2
// TC O(logn)
//SC O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int left=matrix[0][0];
        int right=matrix[n-1][n-1];
        while(left<right)
        {
int mid=left+(right-left)/2;
int count=getCount(matrix,mid);
if(count<k) left=mid+1;
else right=mid-1;
        }
        return left;
    }
    public int getCount(int matrix[][],int mid)
    {
        int count=0;
        int j=matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            while(j>0&&matrix[i][j]>mid)j--;
            count=count+j+1;
        }
        return count;
    }
}