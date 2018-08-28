package leetcode;

import java.util.*;

/**
 * 求凸包问题（hard）
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class Erect_the_Fence_587 {
    public static void main(String[] args) {
        Point[] p = {new Point(1,1), new Point(2,2), new Point(2,0),
                new Point(2,4), new Point(3,3), new Point(4,2)};
//        Erect_the_Fence_587 t = new Erect_the_Fence_587();
//        List<Point> l = t.outerTrees(p);
        Arrays.sort(p, (a,b)->{
            return a.x - b.x;
        });
        for (int i = 0;i < p.length;i++){
            System.out.print("["+p[i].x+"]");
        }
    }

    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 1)
            return Arrays.asList(points);
        sortByPolar(points, bottomLeft(points));
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < points.length; i++) {
            Point top = stack.pop();
            while (ccw(stack.peek(), top, points[i]) < 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points[i]);
        }
        return new ArrayList<>(stack);
    }

    private static Point bottomLeft(Point[] points) {
        Point bottomLeft = points[0];
        for (Point p : points)
            if (p.y < bottomLeft.y || p.y == bottomLeft.y && p.x < bottomLeft.x)
                bottomLeft = p;
        return bottomLeft;
    }

    /**
     * @return positive if counter-clockwise, negative if clockwise, 0 if collinear
     * 判断c是否在ab构成的直线左侧，a,b,c顺时针：c在右侧，返回负数
     */
    private static int ccw(Point a, Point b, Point c) {
        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
    }

    /**
     * @return distance square of |p - q|
     */
    private static int dist(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    /**
     * 将所有点按极角大小排序
     * @param points
     * @param r
     */
    private static void sortByPolar(Point[] points, Point r) {
        Arrays.sort(points, (p, q) -> {
            //q在左边返回正，在右边返回负，负的排在前面
            int compPolar = ccw(p, r, q);
            int compDist = dist(p, r) - dist(q, r);
            return compPolar == 0 ? compDist : compPolar;
        });
        //将最后共线的几个点按照距离参考点距离从大到小的顺序排序
        // find collinear points in the end positions
        Point p = points[0], q = points[points.length - 1];
        int i = points.length - 2;
        while (i >= 0 && ccw(p, q, points[i]) == 0)
            i--;
        // reverse sort order of collinear points in the end positions
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point tmp = points[l];
            points[l] = points[h];
            points[h] = tmp;
        }
    }
    public static void printlist(List<Point> list){
        for (Point point : list) {
            System.out.print("["+point.x+","+point.y+"] ");
        }
    }
}
