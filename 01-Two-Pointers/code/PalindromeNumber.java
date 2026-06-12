public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 23432;
        int rev = 0;
        int temp = num;

        while (temp > 0) {
            int lastDigit = temp % 10;
            temp = temp / 10;
            rev = rev * 10 + lastDigit;
        }

        if (num == rev) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
