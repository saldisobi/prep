package amazon;

import java.util.ArrayList;
import java.util.List;

class PowerSet {
    int[] nums;
    List<List<Integer>> results;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        results = new ArrayList();
        
        recursiveHelper(0, new ArrayList());
        
        return results;
    }
    
    void recursiveHelper(int index, List<Integer> midWay){
        if(index == nums.length - 1){
            results.add(new ArrayList<Integer>(midWay));
            midWay.add(nums[index]);
            results.add(new ArrayList<Integer>(midWay));
        } else{
            recursiveHelper(index + 1, new ArrayList<Integer>(midWay));
            midWay.add(nums[index]);
            recursiveHelper(index + 1, new ArrayList<Integer>(midWay));
        }
    }
    
    
}