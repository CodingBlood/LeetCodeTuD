class Solution {
    public int[] NGE(int[] nums) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] r = new int[nums.length];
        Arrays.fill(r, nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty()) {
                if (nums[s.peek()] < nums[i]) {
                    r[s.pop()] = i;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }

    public int[] NSE(int[] nums) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] r = new int[nums.length];
        Arrays.fill(r, nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty()) {
                if (nums[s.peek()] > nums[i]) {
                    r[s.pop()] = i;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }

    public int[] PGE(int[] nums) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] r = new int[nums.length];
        Arrays.fill(r, -1);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty()) {
                if (nums[s.peek()] <= nums[i]) {
                    r[s.pop()] = i;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }

    public int[] PSE(int[] nums) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] r = new int[nums.length];
        Arrays.fill(r, -1);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty()) {
                if (nums[s.peek()] >= nums[i]) {
                    r[s.pop()] = i;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }

    public long subArrayRanges(int[] nums) {
        int[] nge = NGE(nums);
        int[] nse = NSE(nums);
        int[] pge = PGE(nums);
        int[] pse = PSE(nums);
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nge[i] + " ");
        // }
        // System.out.println("");
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(pge[i] + " ");
        // }
        // System.out.println("");
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nse[i] + " ");
        // }
        // System.out.println("");
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(pse[i] + " ");
        // }
        // System.out.println("");

        long l_tot = 0;
        long s_tot = 0;
        for (int i = 0; i < nums.length; i++) {
            l_tot+=((long)nums[i]*(nge[i]-i)*(i-pge[i]));
            // System.out.print(" ( " + (nge[i]-i) + " * " + (i-pge[i]) + " = " + ((nge[i]-i)*(i-pge[i]))+ " ) ");
        }
        System.out.println("");
        for (int i = 0; i < nums.length; i++) {
            s_tot+=((long)nums[i]*(nse[i]-i)*(i-pse[i]));
            // System.out.print(" ( " + (nse[i]-i) + " * " + (i-pse[i]) + " = " + ((nse[i]-i)*(i-pse[i]))+ " ) ");
        }
        // System.out.println("");
        // System.out.println(l_tot);
        // System.out.println(s_tot);
        return l_tot-s_tot;
    }
}

//     0  1  2  3  4
//     4 -2 -3  4  1
// NGE n  3  3  n  n
// PGE-1  0  1 -1  3

//     4 -2 -3  4  1
// NSE 1  2  n  4  n
// PSE-1 -1 -1  2  2
