package xust;

/*
1. ����Ĵ�
����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
ע��:
�����ַ����ĳ��Ȳ��ᳬ�� 1010��

ʾ�� 1:
����:
"abccccdd"
���:
7
����:
���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 */
/*
 * ������
 * ��sumͳ�Ƽ�����Ļ��Ĵ��ĳ��ȣ�����A~Z��a~z֮����ĸ���Գ��ֵ�������������ִ�����ż���Σ��򽫴����ӵ�sum�ϣ�������ִ����������Σ��򽫴�����һ�ӵ�sum�ϣ�
 * ����������ε���ĸ�ǵ�һ�γ��֣��ٸ�sum��һ��
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
2. ���������
����һ���ǿ����飬���ش������е������������������ڣ��򷵻���������������Ҫ���㷨ʱ�临�Ӷȱ�����O(n)��

ʾ�� 1:
����: [3, 2, 1]
���: 1
����: ����������� 1.

ʾ�� 2:
����: [1, 2]
���: 2
����: ���������������, ���Է��������� 2 .

ʾ�� 3:
����: [2, 2, 3, 1]
���: 1
����: ע�⣬Ҫ�󷵻ص������������ָ��������Ψһ���ֵ�����
��������ֵΪ2���������Ƕ��ŵڶ���
 */

/*
 * ���������ж�nums.length�ĳ��ȣ������1��ֱ�ӷ��� nums[0]�������2������nums[0]��nums[1]�������
 * ��max��secondMax��thirdMax����ʾ��������󡢴δ󡢵������������ʼĬ��int����С����-2147483648��flag1��flag2��������ǣ���ʼĬ��Ϊ0
 * Ȼ��������飬
 * ��nums[i] == -2147483648 && flag2 == 0����ʾ��������γ��ֲ�����-2147483648����falg++���൱�ڴ�ʱ�������������max��secondMax��thirdMax�У�flag2 = 1���´γ��ֲ����ٴ棬
 * ��������£�
 * �ж�nums[i]��max��secondMax��thirdMax�Ĺ�ϵ����������Ӧ�������max��secondMax��thirdMax��ֵ��
 * ѭ����ϣ���flag1 > 2 �򷵻� thirdMax�����򷵻� max��
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
3. �ַ������
���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺ͡�
ע�⣺
num1 ��num2 �ĳ��ȶ�С�� 5100.
num1 ��num2 ��ֻ�������� 0-9.
num1 ��num2 ���������κ�ǰ���㡣
�㲻��ʹ���κ΃Ƚ� BigInteger �⣬ Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��
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