package easy.string;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("malayalam"));
        System.out.println(isPalindrome("akhil"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("akshay"));
        System.out.println(isPalindrome("rtddtr"));
        System.out.println(isPalindrome("kalpana"));
    }

    public static boolean isPalindrome(String str) {
        int index = 0;
        while (index < str.length() / 2) {
            if (str.charAt(index) != str.charAt(str.length() - index - 1)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
