package xust;

/*
1. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
注意:
假设字符串的长度不会超过 1010。

示例 1:
输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
/*
 * 分析：
 * 用sum统计计算最长的回文串的长度，计算A~Z，a~z之间字母各自出现的数量，如果出现次数是偶数次，则将次数加到sum上，如果出现次数是奇数次，则将次数减一加到sum上，
 * 如果此奇数次的字母是第一次出现，再给sum加一。
 */
//public class Test_0130 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "abccccdd";
//		System.out.println(So.longestPalindrome(s));
//	}
//}
//class Solution {
//    public int longestPalindrome(String s) {
//    	int sum = 0;
//    	int flag = 0;
//        for(char i = 'A'; i<='z'; i++){
//        	int count = 0;
//        	for(int j = 0; j<s.length(); j++){
//        		if(i == s.charAt(j)){
//        			count++;
//        		}
//        	}
//        	if(count%2 == 0){
//        		sum += count;
//        	}
//        	else{
//        		sum += (count-1);
//        		if(flag == 0){
//        			sum += 1;
//        		}
//        		flag = 1;
//        	}
//        	if(i == 'Z'){
//        		i =(char)96;
//        	}
//        }
//        return sum;
//    }
//}
/*
2. 第三大的数
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:
输入: [3, 2, 1]
输出: 1
解释: 第三大的数是 1.

示例 2:
输入: [1, 2]
输出: 2
解释: 第三大的数不存在, 所以返回最大的数 2 .

示例 3:
输入: [2, 2, 3, 1]
输出: 1
解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
 */

/*
 * 分析：先判断nums.length的长度，如果是1，直接返回 nums[0]，如果是2，返回nums[0]、nums[1]大的数，
 * 用max、secondMax、thirdMax来表示数组中最大、次大、第三大的数，初始默认int型最小的数-2147483648，flag1、flag2是两个标记，初始默认为0
 * 然后遍历数组，
 * 若nums[i] == -2147483648 && flag2 == 0，表示这个数初次出现并等于-2147483648，则falg++，相当于此时将这个数存入了max、secondMax、thirdMax中，flag2 = 1，下次出现不会再存，
 * 其他情况下：
 * 判断nums[i]与max、secondMax、thirdMax的关系，并根据相应情况更新max、secondMax、thirdMax的值。
 * 循环完毕，若flag1 > 2 则返回 thirdMax，否则返回 max。
 */
//public class Test_0130 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] nums = {2, 2, 3, 1};
//		System.out.println(So.thirdMax(nums));
//	}
//}
//class Solution {
//    public int thirdMax(int[] nums) {
//    	if(nums.length ==1){
//    		return nums[0];
//    	}
//    	if(nums.length ==2){
//    		return nums[0] > nums[1] ? nums[0]: nums[1];
//    	}
//    	int max = -2147483648;
//    	int secondMax = -2147483648;
//    	int thirdMax = -2147483648;
//    	int flag1 = 0;
//    	int flag2 = 0;
//        for(int i=0; i<nums.length ; i++){
//        	if(nums[i] == -2147483648 && flag2 == 0){
//        		flag1++;
//        		flag2 = 1;
//        	}
//        	else if(nums[i] > max){
//        		flag1 ++;
//        		thirdMax = secondMax;
//        		secondMax = max;
//        		max = nums[i];
//        	}
//    		else if(secondMax < nums[i] && nums[i] < max){
//    			flag1 ++;
//    			thirdMax = secondMax;
//    			secondMax = nums[i];
//    		}
//    		else if(thirdMax < nums[i] && nums[i] < secondMax){
//    			flag1 ++;
//    			thirdMax = nums[i];
//    		}
//        }
//        return flag1 > 2 ? thirdMax : max ;
//    }
//}
/*
3. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Test_0130 {
	public static void main(String[] args) {
		Solution So = new Solution();
		String num1 ="98";
	    String num2 ="9";
		System.out.println(So.addStrings(num1, num2));
	}
}
class Solution {
    public String addStrings(String num1, String num2) {
    	int num1i = 0;
    	int num2j = 0;
    	int num = 0;
    	int carry = 0;
    	String ret = "";
        for(int i=num1.length()-1,j=num2.length()-1; i>=0 || j>=0; i--,j--){
        	num1i = i>=0 ? num1.charAt(i) - '0': 0;
        	num2j = j>=0 ? num2.charAt(j) - '0': 0;
        	num = (num1i + num2j + carry)%10;
        	ret = String.valueOf(num) + ret;
        	carry = (num1i + num2j + carry)/10;
        }
        if(carry != 0){
        	ret = String.valueOf(carry) + ret;
        }
        return ret;
    }
}