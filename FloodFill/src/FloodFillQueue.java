public class FloodFillQueue implements FillAlgorithm {
    private final Queue<Point> queue;

    public FloodFillQueue() {
        this.queue = new Queue<>();
    }

    public void fill(int[][] grid, int startX, int startY) {
        if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length || grid[startX][startY] != 0) {
            return;
        }

        queue.enqueue(new Point(startX, startY));
        grid[startX][startY] = 2;

        while (!queue.isEmpty()) {
            Point p = queue.dequeue();
            int x = p.x;
            int y = p.y;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                    grid[newX][newY] = 2;
                    queue.enqueue(new Point(newX, newY));
                }
            }
        }
    }
}
