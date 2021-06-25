public class solution {

    /// 1380

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    idx = j;

                }
            }

            int maxI = -1;
            for (int j = 0; j < n; j++) {
                if (matrix[j][idx] > maxI) {
                    maxI = matrix[j][idx];

                }
            }

            if (maxI == min) {
                list.add(maxI);
            }
        }
        return list;
    }

    //////////////// 1365

    public int[] smallerNumbersThanCurrent(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] num = nums.clone();

        Arrays.sort(num);

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(num[i], i);

        }
        for (int i = 0; i < nums.length; i++) {
            num[i] = map.get(nums[i]);
        }
        return num;

    }

    //// 1464

    public int maxProduct(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        if (length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        if (length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        for (int i = 0; i < length; i++) {

            if (nums[i] >= max2) {

                if (nums[i] >= max1) {
                    max2 = max1;
                    max1 = nums[i];

                } else {
                    max2 = nums[i];
                }
            }

        }
        return (max1 - 1) * (max2 - 1);

    }

    // 1486

    public int xorOperation(int n, int start) {

        int ans = start;

        for (int i = 1; i < n; i++) {
            ans ^= (start + 2 * i);
        }
        return ans;

    }

    ///// 862. Shortest Subarray with Sum at Least K

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] newArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i + 1] = newArr[i] + (long) nums[i];
        }

        int ans = n + 1;

        Deque<Integer> que = new LinkedList<>();

        for (int y = 0; y < newArr.length; y++) {
            while (!que.isEmpty() && newArr[y] <= newArr[que.getLast()]) {
                que.removeLast();
            }
            while (!que.isEmpty() && newArr[y] >= newArr[que.getFirst()] + k) {
                ans = Math.min(ans, y - que.removeFirst());
            }

            que.addLast(y);
        }

        if (ans < n + 1) {
            return ans;
        } else {
            return -1;
        }
    }

    //////// decode ways 2

    static int mod = 1000000007;

    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        long ans = numDecodings_opti(s);
        return (int) ans;
    }

    public long numDecodings_opti(String s) {
        long a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            long count = 0;
            char ch1 = s.charAt(idx);
            if (ch1 == '0') {
                count = 0;
            } else if (ch1 == '*') {
                count = (count + 9 * a) % mod;
                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    if (ch2 == '*')
                        count = (count + 15 * b) % mod;
                    else if (ch2 >= '0' && ch2 <= '6')
                        count = (count + 2 * b) % mod;
                    else if (ch2 > '6')
                        count = (count + b) % mod;

                }
            } else {
                count = (count + a) % mod;
                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        char ch2 = s.charAt(idx + 1);
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if (num <= 26)
                            count = (count + b) % mod;
                    } else {
                        if (s.charAt(idx) == '1')
                            count = (count + 9 * b) % mod;
                        else if (s.charAt(idx) == '2')
                            count = (count + 6 * b) % mod;
                    }
                }
            }

            b = a;
            a = count;
        }

        return (int) a;
    }

    //// 10 regular expression

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    char pc = p.charAt(i - 1);
                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];

                    } else {
                        dp[i][j] = false;
                    }
                } else {

                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);

                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];

                        char pslc = p.charAt(i - 2);
                        if (pslc == '.' || pslc == sc) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];

                        }
                    } else if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];

                    } else if (pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    //// 13 ROMAN TO INTEGER

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {

            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {

                ans -= map.get(s.charAt(i));

            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }

    //// 12 integer to roamn

    public String intToRoman(int num) {
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                sb.append(symbol[i]);
                num -= value[i];

            }
        }
        return sb.toString();
    }

    //// 309 best time to buy stock
    public int maxProfit(int[] prices) {
        int oldsell = 0;
        int oldbuy = -prices[0];
        ;
        int oldcool = 0;

        for (int i = 1; i < prices.length; i++) {
            int newbuy = 0;
            int newsell = 0;
            int newcool = 0;

            if (oldcool - prices[i] > oldbuy) {
                newbuy = oldcool - prices[i];
            } else {
                newbuy = oldbuy;

            }

            if (oldbuy + prices[i] > oldsell) {
                newsell = oldbuy + prices[i];
            } else {
                newsell = oldsell;
            }

            if (oldsell > oldcool) {
                newcool = oldsell;
            } else {
                newcool = oldcool;
            }

            oldbuy = newbuy;
            oldsell = newsell;
            oldcool = newcool;
        }

        return oldsell;
    }

    //// 714

    public int maxProfit(int[] arr, int fee) {

        int obsp = -arr[0];
        int ossp = 0;

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;

            if (ossp - arr[i] > obsp) {
                nbsp = ossp - arr[i];
            } else {
                nbsp = obsp;
            }

            if (obsp + arr[i] - fee > ossp) {
                nssp = obsp + arr[i] - fee;
            } else {
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;

        }
        return ossp;
    }

    /// 123
    public int maxProfit(int[] prices) {

        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }

            pist = prices[i] - lsf;
            if (pist > op) {
                op = pist;
            }
        }
        return op;

    }

    /// 122

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {

    }
}
