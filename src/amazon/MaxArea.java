package amazon;

class MaxArea {
    public int maxArea(int[] height) {
        
        int maxArea = 0;
        
        int start = 0;
        
        int end = height.length - 1;
        
        while(start<end){
            int minHeight = Math.min(height[start], height[end]);
            
            int area = minHeight * (end-start);
            
            if(area > maxArea){
                maxArea = area;
            }
            
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
            
        }
        
        return maxArea;
        
    }
}