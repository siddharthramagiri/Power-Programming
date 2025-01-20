package DSA;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1x1 = rec1[0], r1y1 = rec1[1], r1x2=rec1[2], r1y2=rec1[3];
        int r2x1 = rec2[0], r2y1 = rec2[1], r2x2=rec2[2], r2y2=rec2[3];
        if(r2x2 <= r1x1 || r2y2 <= r1y1 || r2x1 >= r1x2 || r2y1 >= r1y2) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {2,2,3,3};
        RectangleOverlap solution = new RectangleOverlap();
        System.out.println(solution.isRectangleOverlap(rec1, rec2));
    }
}
