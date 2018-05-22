public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        // 要点1: start + 1 < end，避免死循环
	// while循环退出时，start和end相邻
        while (start + 1 < end) {
	    // 要点2：start + (end - start) / 2
	    // 防溢出，start和end可能会达到int类型的最大值，此时若(start + end) / 2会溢出
            int mid = start + (end - start) / 2;
            // 要点3：=, <, > 分开讨论，mid 不+1也不-1
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        // 要点4: 循环结束后，单独处理start和end
	// while循环退出时，start和end相邻，故需单独判断start和end对应的值
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}


常见问题
Q: 为什么要用 start + 1 < end？而不是 start < end 或者 start <= end？

A: 为了避免死循环。二分法的模板中，整个程序架构分为两个部分：

通过 while 循环，将区间范围从 n 缩小到 2 （只有 start 和 end 两个点）。
在 start 和 end 中判断是否有解。
start < end 或者 start <= end 在寻找目标最后一次出现的位置的时候，出现死循环。
例如在[1, 1]中找last position of 1，或是在[1, 2]中找last position of 1
若while条件是start<end，则会产生死循环或者wrong answer

Q: 为什么明明可以 start = mid + 1 偏偏要写成 start = mid?

A: 大部分时候，mid 是可以 +1 和 -1 的。在一些特殊情况下，比如寻找目标的最后一次出现的位置时，
当 target 与 nums[mid] 相等的时候，是不能够使用 mid + 1 或者 mid - 1 的。因为会导致漏掉解。
那么为了节省脑力，统一写成 start = mid / end = mid 并不会造成任何解的丢失，并且也不会损失效率——log(n) 和 log(n+1) 没有区别。

while循环的目的不是为了找到答案，而是为了不断把搜索的区间缩小直至可以使用两个if语句找到答案



