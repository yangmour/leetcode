//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1319 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs2(candidates, target, res, l, 0);
        return res;
    }

    private void dfs2(int[] candidates, int target, List<List<Integer>> res, List<Integer> l, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(l));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //剪大枝排序后后面全是比较大数，直接跳过
            if (target - candidates[i] < 0) break;

            //剪小枝
            if (i>index && candidates[i] == candidates[i-1]) continue;

            l.add(candidates[i]);

            //避免相同的值
            dfs2(candidates, target - candidates[i], res, l, i + 1);
            //如果没有等于0 就删除添加的
            l.remove(Integer.valueOf(candidates[i]));

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
