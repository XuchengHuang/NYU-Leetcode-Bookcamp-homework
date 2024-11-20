class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, result)) {
                return new int[0]; 
            }
        }

        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited, List<Integer> result) {
        if (visited[course] == 1) {
            return false; 
        }
        if (visited[course] == 2) {
            return true; 
        }

        visited[course] = 1; 
        for (int nextCourse : graph.get(course)) {
            if (!dfs(nextCourse, graph, visited, result)) {
                return false;
            }
        }
        visited[course] = 2;
        result.add(course);
        return true;
    }
}