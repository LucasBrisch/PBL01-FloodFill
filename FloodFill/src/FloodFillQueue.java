public class FloodFillQueue implements FillAlgorithm {
    private final Queue<Point> queue;

    public FloodFillQueue() {
        this.queue = new Queue<>();
    }

    public void fill(int[][] grid, int startX, int startY) {
        // Checks if the clicked coordinate is valid, i.e. inside the boundaries and empty
        if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length || grid[startX][startY] != 0) {
            return;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Queues the initial pixel and immediately fills it
        queue.enqueue(new Point(startX, startY));
        grid[startX][startY] = 2;

        while (!queue.isEmpty()) {
            // then we first dequeue the pixel
            Point p = queue.dequeue();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                // we check if the neighboring pixels are valid
                int newX = x + directions[i][i];
                int newY = y + directions[i][i];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                    // if they are valid, queue them and color them
                    grid[newX][newY] = 2;
                    queue.enqueue(new Point(newX, newY));
                }
            }
        }
    }
}
