import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> s = new ArrayDeque<>();
        
        for (int i : asteroids) {
            boolean destroyed = false;
            
            // Collision ONLY happens when top of stack moves RIGHT (+) and current moves LEFT (-)
            while (!s.isEmpty() && s.peek() > 0 && i < 0) {
                if (s.peek() < Math.abs(i)) {
                    s.pop(); // The top asteroid is smaller; destroy it and keep checking
                    continue;
                } else if (s.peek() == Math.abs(i)) {
                    s.pop(); // Both are the same size; destroy both
                }
                destroyed = true; // Current asteroid is either destroyed or equal
                break;
            }
            
            // If the current asteroid survived all collisions, push it to the stack
            if (!destroyed) {
                s.push(i);
            }
        }
        
        // Convert the stack back into the result array
        int[] sol = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            sol[i] = s.pop();
        }
        
        return sol;
    }
}
