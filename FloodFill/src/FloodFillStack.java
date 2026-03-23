public class FloodFillStack implements FillAlgorithm {
    private Node<Point> top;

    public FloodFillStack() {
        top = null;
    }

    public void push(Point p) {
        Node<Point> newNode = new Node<>(p);
        newNode.next = top;
        top = newNode;
    }

    public Point pop() {
        if (top == null) return null;
        Point p = top.data;
        top = top.next;
        return p;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void fill(int[][] grid, int startX, int startY) {
        if (grid[startX][startY] != 0) return;

        push(new Point(startX, startY));

        while (!isEmpty()) {
            Point p = pop();
            int x = p.x;
            int y = p.y;

            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
            if (grid[x][y] != 0) continue;

            grid[x][y] = 2;

            push(new Point(x + 1, y));
            push(new Point(x - 1, y));
            push(new Point(x, y + 1));
            push(new Point(x, y - 1));
        }
    }
}
