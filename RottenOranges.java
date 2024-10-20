#https://leetcode.com/problems/rotting-oranges/
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
        int freshOranges=0;
        int minCount=0;
        Queue<int[]> ro= new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if (grid[i][j]==1){
                    freshOranges++;}
                else if(grid[i][j]==2){
                    ro.offer(new int[]{i,j});
                } 
            }
        }
        if(freshOranges==0) return 0;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(!ro.isEmpty()){
            int size=ro.size();
            for(int i=0;i<size;i++){
                int[] ro_pos=ro.poll();
                for(int[] direction : directions){
                    int ro_nx=ro_pos[0]+direction[0];
                    int ro_ny=ro_pos[1]+direction[1];
                    if(ro_nx<grid.length && ro_nx>=0 && ro_ny<grid[0].length && ro_ny>=0 && grid[ro_nx][ro_ny]==1){
                        grid[ro_nx][ro_ny]=2;
                        freshOranges--;
                        ro.offer(new int[]{ro_nx,ro_ny});
                    }
                }
            }
            minCount++;
        }
        return freshOranges==0?minCount-1:-1;
    }   
}
