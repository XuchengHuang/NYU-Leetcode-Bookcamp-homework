class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j}); 
                } else if (grid[i][j] == 1) {
                    freshOranges++; 
                }
            }
        }

        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRot = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; 
                        freshOranges--; 
                        queue.add(new int[]{newRow, newCol}); 
                        anyRot = true;
                    }
                }
            }

            if (anyRot) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}