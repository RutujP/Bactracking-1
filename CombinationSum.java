// Time Complexity : O(2*n) // n is size of candidates
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach:
1) We use backtracking for this approach
2) we use an apprach were we check for 3 conditions
3) if the targetSum is reached, we can complete the arrayList
4) if the sum<0, then its a wrong combination, we simply return.
5) we use the same list, thus once we add that number to the arraylist -> we will have list as [2,3,3] target=7 its exceding the targetvalue and target would be -ve.
-> in this case we just return from recurision and delete the last element lst.remove(lst.size()-1);
thus now list would look like [2,3] and we continue to use the same elements and move ahead.



*/

import java.util.*;

public class CombinationSum {
    
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
         res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),0);
        
        
        return res;
    }
    
    public void helper(int[] candidates, int target, List<Integer> lst, int index)
    {
        if(target<0)
        {
            
            return;
        }
        else if(target==0)
        {
            res.add(new ArrayList<>(lst));
        }
        else
        {
            for(int i=index;i<candidates.length;i++)
            {
                lst.add(candidates[i]);
                helper(candidates, target-candidates[i],lst,i);
                lst.remove(lst.size()-1);
            }
        }
        
        
    }
    


}
