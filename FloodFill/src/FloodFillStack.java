public class FloodFillStack implements FillAlgorithm {
    private Stack<Point> stack;

    public FloodFillStack() {
        this.stack = new Stack<>();
    }

    public void fill(int[][] grid, int startX, int startY) {
        if (grid[startX][startY] != 0) return;

        stack.push(new Point(startX, startY));

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (p == null) continue;

            int x = p.x;
            int y = p.y;

            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;

            if (grid[x][y] != 0) continue;

            grid[x][y] = 2;

            stack.push(new Point(x + 1, y));
            stack.push(new Point(x - 1, y));
            stack.push(new Point(x, y + 1));
            stack.push(new Point(x, y - 1));
        }
    }
}