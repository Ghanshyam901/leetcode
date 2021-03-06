import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Questions {

    // 11. Container With Most Water

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while (left < right) {
            int lh = height[left];
            int rh = height[right];

            int min_length = Math.min(lh, rh);
            int len = right - left;

            int currArea = min_length * len;

            max = Math.max(max, currArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // ===================================================================

    // 977. Squares of a Sorted Array

    public int[] sortedSquares_(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    // 2.

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        int square = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }

            ans[i] = square * square;
        }
        return ans;

    }
    // ================================================================
    // 169. Majority Element

    // approach : by using Boyer moore algo ;
    public static int majorityElement(int[] nums) {
        int val = nums[0];

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else if (count == 0) {
                val = nums[i];
                count = 1;

            } else {
                count--;
            }
        }
        return val;
    }

    // ===================================================================

    // 229. Majority Element II
    public List<Integer> majorityElement2(int[] nums) {
        int val1 = nums[0];
        int val2 = nums[0];
        int count1 = 1;
        int count2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val1) {
                count1++;
            } else if (nums[i] == val2) {
                count2++;
            } else if (count1 == 0) {
                val1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                val2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // make freq;

        int freq1 = 0;
        int freq2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val1) {
                freq1++;

            } else if (nums[i] == val2) {
                freq2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (freq1 > nums.length / 3) {
            ans.add(val1);
        }
        if (val1 != val2 && freq2 > nums.length / 3) {
            ans.add(val2);
        }

        return ans;
    }

    // ============================================================
    // 556. Next Greater Element III
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();

        int i, j;
        for (i = number.length - 1; i > 0; i--) {
            if (number[i - 1] < number[i]) {
                break;
            }

        }
        if (i == 0) {
            return -1;
        }

        int x = number[i - 1], smallest = i;
        for (j = i + 1; j < number.length; j++) {
            if (number[j] > x && number[j] <= number[smallest]) {
                smallest = j;
            }
        }

        char temp = number[i - 1];
        number[i - 1] = number[smallest];
        number[smallest] = temp;

        // Arrays.sort(number, i, number.length);
        reverseChar_(number, i);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private void reverseChar_(char[] arr, int i) {
        int start = i;
        int end = arr.length - 1;
        while (end >= start) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }

    // 2 approach

    public int nextGreaterElement_(int nums) {

        char[] arr = (nums + "").toCharArray();

        int i = arr.length - 1;

        while (i > 0) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
            i--;
        }

        if (i == 0) {
            return -1;
        }
        int val1 = i - 1;

        int val2 = arr.length - 1;

        while (val2 >= val1) {
            if (arr[val1] < arr[val2]) {
                break;
            }
            val2--;
        }

        System.out.println(arr[val2] + " " + arr[val1]);

        // swap

        char temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;

        reverseChar(arr, i);

        Long rev = Long.parseLong(new String(arr));
        if (rev <= Integer.MAX_VALUE) {
            return rev.intValue();
        } else {
            return -1;
        }
    }

    private void reverseChar(char[] arr, int i) {
        int start = i;
        int end = arr.length - 1;
        while (end >= start) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }
    // ==================================================================

    // 628. Maximum Product of Three Numbers

    public int maximumProduct(int[] nums) {
        int max1 = -(int) 1e9;
        int max2 = -(int) 1e9;
        int max3 = -(int) 1e9;

        int min1 = (int) 1e9;
        int min2 = (int) 1e9;

        for (int n = 0; n < nums.length; n++) {
            if (nums[n] < min1) {
                min2 = min1;
                min1 = nums[n];
            } else if (nums[n] < min2) {
                min2 = nums[n];
            }

            if (nums[n] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[n];

            } else if (nums[n] >= max2) {
                max3 = max2;
                max2 = nums[n];

            } else if (nums[n] >= max3) {
                max3 = nums[n];
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    // 769. Max Chunks To Make Sorted

    public int maxChunksToSorted(int[] arr) {
        int max = -(int) 1e9;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    // 768. Max Chunks To Make Sorted II

    public int maxChunksToSorted_(int[] arr) {
        int n = arr.length;

        int[] prefixMax = new int[n];
        int[] sufficMin = new int[n];

        prefixMax[0] = arr[0];
        sufficMin[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            sufficMin[i] = Math.min(sufficMin[i + 1], arr[i]);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (prefixMax[i] <= sufficMin[i + 1]) {
                ans++;
            }
        }
        ans++;

        return ans;
    }

    // 795. Number of Subarrays with Bounded Maximum

    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        // int n
        int ans = 0;
        int precount = 0;
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] >= left && arr[j] <= right) {
                ans += ((j - i) + 1);
                precount += ((j - i) + 1);
            } else if (arr[j] < left) {
                ans += precount;
            } else {
                i = j + 1;
                precount = 0;
            }
        }
        return ans;
    }

    // https://www.lintcode.com/problem/508/
    // wiggle sort 508

    public void wiggleSort(int[] arr) {
        // write your code here
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i + 1] > arr[i]) {
                    swap(arr, i, i + 1);
                }

            }
        }

    }

    public void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    // =============================
    // 747. Largest Number At Least Twice of Others
    public int dominantIndex(int[] arr) {

        int max = 0;
        int secondMAX = 0;
        int maxIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMAX = max;
                max = arr[i];
                maxIdx = i;
            } else if (arr[i] > secondMAX) {
                secondMAX = arr[i];
            }
        }

        return secondMAX * 2 > max ? -1 : maxIdx;

    }

    // ==========================================================
    // 238. Product of Array Except Self

    public int[] productExceptSelf(int[] arr) {

        int[] ans = new int[arr.length];
        int i = 0;
        int product = 1;

        ans[0] = 1;
        for (i = 1; i < arr.length; i++) {
            ans[i] = arr[i - 1] * ans[i - 1];
        }

        for (i = arr.length - 2; i >= 0; i--) {
            product = product * arr[i + 1];
            ans[i] = ans[i] * product;
        }
        return ans;
    }

    // ======================================================
    // 41. First Missing Positive

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums[i]) {
                continue;
            }

            if (nums[i] < 1 || nums[i] > n) {
                continue;
            }

            int idx1 = i;
            int idx2 = nums[i] - 1;

            if (nums[idx2] == nums[idx1])
                continue;

            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;

            i--;

        }

        // int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;

    }

    // 849. Maximize Distance to Closest Person

    public int maxDistToClosest(int[] seats) {
        int maxval = 0;
        int prev = -1;
        int s = seats.length;
        int i = 0;

        if (seats[0] == 1) {
            prev = 0;
        }
        for (i = prev + 1; i < s; i++) {
            if (seats[i] == 1) {
                if (prev != -1) {
                    maxval = Math.max(maxval, ((i + prev) / 2) - prev);
                } else {
                    maxval = Math.max(maxval, i - 1 - prev);
                }
                prev = i;
            }
        }

        return Math.max(maxval, s - 1 - prev);
    }
    // ==============================================================================
    // 345. Reverse Vowels of a String

    public String reverseVowels(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (IsVowel(arr, i) && IsVowel(arr, j)) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (IsVowel(arr, i)) {
                j--;
            } else if (IsVowel(arr, j)) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    // check vowels
    public boolean IsVowel(char[] arr, int i) {

        char ch = Character.toLowerCase(arr[i]);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    // swap function
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // /===============================================

    // 903 ?? Range Addition /// lint codet ad
    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] res = new int[length];

        for (int i = 0; i < queries.length; i++) {
            int st = queries[i][0];
            int end = queries[i][1];
            int inc = queries[i][2];

            res[st] += inc;
            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }

    // 215. Kth Largest Element in an Array

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if (pq.size() > k) {

                pq.poll();
            }
        }

        return pq.poll();

        // Arrays.sort(nums);

        // return nums[nums.length -k];

    }

    // 829. Consecutive Numbers Sum
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int k = 1; k < Math.sqrt(2 * N); k++) {
            if ((N - (k * (k - 1) / 2)) % k == 0) {
                count++;
            }
        }
        return count;
    }

    // 33. Search in Rotated Sorted Array

    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = (ei + si) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target < nums[mid])
                    ei = mid - 1;
                else {
                    si = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[ei])
                    si = mid + 1;
                else {
                    ei = mid - 1;
                }
            }
        }
        return -1;
    }

    // 415. Add Strings

    public String addStrings(String num1, String num2) {

        StringBuilder ans = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {

            int isum = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jsum = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = isum + jsum + carry;

            carry = sum / 10;
            ans.append(sum % 10);

            i--;
            j--;
            // j--;

        }

        if (carry != 0) {
            ans.append(1);
        }
        return ans.reverse().toString();

    }

    // 915. Partition Array into Disjoint Intervals

    public int partitionDisjoint(int[] nums) {
        int currMax = nums[0];
        int nextMax = nums[0];
        int partIdx = 1;

        for (int i = 01; i < nums.length; i++) {
            if (nums[i] < currMax) {
                partIdx = i + 1;
                currMax = nextMax;
            } else {
                nextMax = Math.max(nums[i], nextMax);
            }
        }
        return partIdx;
    }

    // 1007. Minimum Domino Rotations For Equal Row

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        int count_4 = 0;

        int num1 = tops[0];
        int num2 = bottoms[0];

        // COUTN1
        // NUM1

        for (int i = 0; i < tops.length; i++) {

            if (count_1 != Integer.MAX_VALUE) {
                if (tops[i] == num1) {

                }

                else if (bottoms[i] == num1) {
                    count_1++;
                } else {
                    count_1 = Integer.MAX_VALUE;
                }
            }

            // COUNT 2;

            if (count_2 != Integer.MAX_VALUE) {

                if (bottoms[i] == num1) {

                } else if (tops[i] == num1) {
                    count_2++;
                } else {
                    count_2 = Integer.MAX_VALUE;
                }
            }

            // COUNT 3

            if (count_3 != Integer.MAX_VALUE) {
                if (bottoms[i] == num2) {

                }

                else if (tops[i] == num2) {
                    count_3++;
                } else {
                    count_3 = Integer.MAX_VALUE;
                }
            }

            if (count_4 != Integer.MAX_VALUE) {

                if (tops[i] == num2) {

                }

                else if (bottoms[i] == num2) {
                    count_4++;
                } else {
                    count_4 = Integer.MAX_VALUE;
                }
            }
        }

        int ans = Math.min(Math.min(count_1, count_2), Math.min(count_3, count_4));

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    // 1030. Matrix Cells in Distance Order

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] arr = new int[rows * cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int bno = i * cols + j;
                arr[bno][0] = i;
                arr[bno][1] = j;
            }
        }
        Arrays.sort(arr, (a, b) -> {

            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);

            return d1 - d2;
        });

        return arr;
    }

    // 43. Multiply Strings
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int idx1 = i + j;
                int idx2 = i + j + 1;

                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                val = val + ans[idx2];

                int carry = val / 10;

                int rem = val % 10;

                ans[idx2] = rem;
                ans[idx1] += carry;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ans.length; i++) {
            if (sb.length() == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]);
        }

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    // 152. Maximum Product Subarray

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        int prefix = 0;
        int suffix = 0;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1 * nums[i];
            } else {
                prefix = prefix * nums[i];
            }

            if (suffix == 0) {
                suffix = 1 * nums[n - 1 - i];
            } else {
                suffix = suffix * nums[n - 1 - i];
            }

            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }

    public int maxProduct_(int[] arr) {

        if (arr.length == 0)
            return 0;

        int prod = 1;
        int oprd = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            prod = prod * arr[i];
            if (prod > oprd) {
                oprd = prod;
            }
            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            prod = prod * arr[j];

            if (prod > oprd) {
                oprd = prod;
            }
            if (prod == 0) {
                prod = 1;
            }
        }

        return oprd;

    }

    // 680. Valid Palindrome II
    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;

    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {

                return false;

            }
            i++;
            j--;

        }
        return true;
    }
    // 891. Sum of Subsequence Widths

    public int sumSubseqWidths(int[] nums) {

        int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);

        long[] power = new long[n];
        power[0] = 1;

        for (int i = 01; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (power[i] - power[n - 1 - i]) * nums[i]) % mod;
        }

        return (int) ans;
    }
    // 487. Max Consecutive Ones II

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        int length = 0;
        int zero = 0;
        int k = 1;

        while (j < n) {
            if (nums[j++] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[i++] == 0) {
                    zero--;
                }
            }
            length = Math.max(length, j - i);
        }
        return length;
    }

    // 1004. Max Consecutive Ones III

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int length = 0;

        while (j < n) {
            if (nums[j++] == 0) {

                zeroCount++;

            }

            while (zeroCount > k) {
                if (nums[i++] == 0) {

                    zeroCount--;

                }

            }

            length = Math.max(length, j - i);
        }
        return length;
    }

    // https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1

    public static long pairWithMaxSum(long arr[], long N) {
        if (N < 2)
            return -1;

        long res = arr[0] + arr[1];

        for (int i = 2; i < N; i++) {
            if (arr[i] + arr[i - 1] > res) {
                res = arr[i] + arr[i - 1];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        // int [] nums ={2,4,4,4,5,5};
        // System.out.println(majorityElement(nums));
        // majorityElement(nums);
    }
}